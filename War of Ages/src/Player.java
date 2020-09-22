/**
 * Player.java
 * Player class
 * Matthew Hao
 * Jan 20, 2020
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Font;
import java.awt.Color;

public class Player implements GameConstants, EntityConstants {
    
    private Tower tower;
    private int teamSide;
    private LinkedList<Creature> creatures = new LinkedList<Creature>();
    private Queue<Creature> summonQueue = new LinkedList<Creature>();
    private String userName;
    private double gold;
    
    private int currentEvolution = 0;
    private int evolutionCost;
    
    private BufferedImage[][][] moveSprites;
    private BufferedImage[][][] attackSprites;
    private BufferedImage[][] projectileSprites;
    private BufferedImage[] towerSprites;
    private BufferedImage[] turretSprites;
    
    public Player(int team, String name, BufferedImage[][][] move, BufferedImage[][][] attack, BufferedImage[][] projectiles, BufferedImage[] tower, BufferedImage[] turret) {
        this.teamSide = team;
        this.userName = name;
        this.moveSprites = move;
        this.attackSprites = attack;
        this.projectileSprites = projectiles;
        this.towerSprites = tower;
        this.turretSprites = turret;
        this.gold = START_GOLD;
        this.evolutionCost = EVOLVE_COST;
        this.tower = new Tower(team, TOWER_TYPE, this.currentEvolution, this.towerSprites, this.turretSprites, projectileSprites[TURRET_PROJECTILES]);
        this.currentEvolution = STARTING_EVOLUTION;
    }
    
    public void queueCreature(int cost, int type) {
        if(this.summonQueue.size() < MAX_CREATURES_IN_QUEUE){
            this.gold -= cost;
            Creature creature = null;
            BufferedImage projectileSprite = null;
            if(type == FIRST_TYPE || type == THIRD_TYPE) {
                creature = new Creature(teamSide, type, currentEvolution, moveSprites[type][currentEvolution], attackSprites[type][currentEvolution]);
            } else {
                if(type == SECOND_TYPE) {
                    projectileSprite = this.projectileSprites[SECOND_PROJECTILES][this.currentEvolution];
                } else {
                    projectileSprite = this.projectileSprites[FOURTH_PROJECTILES][this.currentEvolution];
                }
                creature = new Ranged(teamSide, type, currentEvolution, moveSprites[type][currentEvolution], attackSprites[type][currentEvolution], projectileSprite);
            }
            this.summonQueue.add(creature);
        }
    }
    
    public void summonCreature() {
        this.creatures.add(this.summonQueue.poll());
    }
    
    public boolean evolve() {
        if(this.currentEvolution == 2) {
            return false;
        }
        this.currentEvolution++;
        this.gold -= this.evolutionCost;
        this.evolutionCost = this.currentEvolution * EVOLVE_MULTIPLIER * EVOLVE_COST;
        this.tower.setCurrentSprite(towerSprites[this.currentEvolution]);
        return true;
    }
    
    public void buyTurret(int cost, int spot) {
        this.gold -= cost;
        this.tower.addTurret(spot);
    }
    
    public void sellTurret(int amount, int spot) {
        this.gold += amount;
        this.tower.getTurrets().set(spot, null);
    }
    
    public int removeDeadCreatures() {
        int goldGained = 0;
        for(int i = HEAD; i < this.creatures.size(); i++) {
            if(this.creatures.get(i).getHealth() <= 0) {
                Creature creature = this.creatures.remove(i);
                goldGained += creature.getGoldFromKill();
            }
        }
        return goldGained;
    }
    
    public boolean checkGameOver() {
        if(this.tower.getHealth() <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void gainGold() {
        this.gold += GOLD_GAINED;
    }
    
    public void gainGold(int amount) {
        this.gold += amount;
    }
    
    // automate troop movements, turret functions, etc
    public void automate(Player other) {
        Creature creature;
        Turret turret;
        Destructible enemyAhead;
        Creature friendlyAhead = null;
        long currentTime;
        long timeElapsed;
        
        // Creatures
        for(int currentCreature = HEAD; currentCreature < this.creatures.size();currentCreature++) {
            creature = this.creatures.get(currentCreature);
            enemyAhead = creature.getEnemyAhead(other);
            creature.setCurrentTarget(enemyAhead);
            
            if(currentCreature != HEAD) {
                friendlyAhead = creature.getFriendlyAhead(this);
            } 
            
            if(creature instanceof Ranged){    
                // animate projectiles
                for(int i = 0; i < ((Ranged)creature).getProjectiles().size(); i++) {
                    Projectile proj = ((Ranged)creature).getProjectiles().get(i);
                    proj.move();
                    
                    if(proj.checkCollide(creature.getCurrentTarget())) {
                        creature.getCurrentTarget().takeDamage(creature.getDamage());
                        ((Ranged)creature).getProjectiles().remove(i);
                    }
                    
                    if(creature.getTeamSide() == LEFT_TEAM){
                        if(proj.getInitialPos().x - proj.getPosition().x  > ((Ranged)creature).getRangebox().getBoundingBox().getWidth()){
                            ((Ranged)creature).getProjectiles().remove(i);
                        }
                    } else {
                        if(proj.getInitialPos().x - proj.getPosition().x  > ((Ranged)creature).getRangebox().getBoundingBox().getWidth()){
                            ((Ranged)creature).getProjectiles().remove(i);
                        }
                    }
                }
            }
            
            // Attack
            if(creature.getRangebox().checkCollide(enemyAhead.getHitbox())) {
                currentTime = System.currentTimeMillis();
                timeElapsed = currentTime-creature.getTimeStartedAttack();
                // Check if they are eligible to attack again
                if(creature.getTimeStartedAttack() == 0 ||(timeElapsed >= creature.getAttackSpeed())){           
                    creature.attack(enemyAhead);
                    creature.setIdling(false);
                }
                
            } else {
                // Movement / Idle
                if(currentCreature == HEAD) {
                    creature.move();
                    creature.setIdling(false);
                    
                } else {
                    if(this.getTeamSide() == LEFT_TEAM) {
                        if((creature.getPosition().x + creature.getWidth() + creature.getSpeed() < friendlyAhead.getPosition().x)) {
                            creature.move();
                            creature.setIdling(false);
                        } else {
                            creature.setIdling(true);
                        }
                        
                    } else {
                        if((creature.getPosition().x - creature.getWidth() + creature.getSpeed() > friendlyAhead.getPosition().x)) {
                            creature.move();
                            creature.setIdling(false);
                        } else {
                            creature.setIdling(true);
                        }
                    }
                }
            }
        }
        
        // Turrets
        for(int i = 0; i < this.tower.getTurrets().size(); i++){
            turret = this.tower.getTurrets().get(i);
            if(turret != null) {
                enemyAhead = turret.getEnemyAhead(other);
                turret.setCurrentTarget(enemyAhead);
                Projectile proj;
                
                for(int projectile = 0; projectile < turret.getProjectiles().size(); projectile++) {
                    proj= turret.getProjectiles().get(projectile);
                    proj.move();
                    if(proj.checkCollide(turret.getCurrentTarget())){
                        turret.getCurrentTarget().takeDamage(turret.getDamage());
                        turret.getProjectiles().remove(projectile);
                    }
                    
                    if(this.teamSide == LEFT_TEAM){
                        if(proj.getPosition().x - proj.getInitialPos().x > turret.getRangebox().getBoundingBox().getWidth()){ 
                            turret.getProjectiles().remove(projectile);
                        }
                    } else {
                        if(proj.getInitialPos().x - proj.getPosition().x > turret.getRangebox().getBoundingBox().getWidth()){ 
                            turret.getProjectiles().remove(projectile);
                        }
                    }       
                }
                
                // Turret Attack
                if(turret.getRangebox().checkCollide(enemyAhead.getHitbox())&& (turret.getCurrentTarget().getHealth()>0)) {
                    currentTime = System.currentTimeMillis();
                    timeElapsed = currentTime-turret.getTimeStartedAttack();
                    // Check if they are eligible to attack again
                    if(turret.getTimeStartedAttack() == 0 ||(timeElapsed >= turret.getAttackSpeed())){           
                        turret.attack(enemyAhead);
                        turret.setIdling(false);
                    }   
                } else {
                    turret.setIdling(true);
                }
            }
        }
        
    }
    
    public void draw(Graphics g) {
        this.tower.draw(g);
        for(Creature creature : this.creatures) {
            creature.draw(g);
        }
        
        Font guideFont = new Font("Tahoma", Font.BOLD, 21);
        g.setFont(guideFont);
        if(this.teamSide == LEFT_TEAM){
            if(this.getGold()>=this.getEvolutionCost()){
                g.drawString(LEFT_EVOLVE_STRING,50,SCREEN_HEIGHT-50);
                g.drawString(Integer.toString(this.getEvolutionCost()),275,SCREEN_HEIGHT-50);
            } 
            g.drawString(this.userName,400,20);
            g.drawString(Double.toString(this.gold),430,75);
            g.drawString(Integer.toString(this.currentEvolution),450,100);
            for(int i= 0;i<NUM_CC_ICONS;i++){
                // Left Menu
                g.drawString(Integer.toString(CREATURE_HEALTHS[i]+(STAT_MULTIPLIERS[i]*this.currentEvolution)),LEFT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),LEFT_FIRST_ICON_POS.y+7+(2*NUMBER_SEPARATOR));
                g.drawString(Integer.toString(CREATURE_DAMAGES[i]+(STAT_MULTIPLIERS[i]*this.currentEvolution)),LEFT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),LEFT_FIRST_ICON_POS.y+7+(4*NUMBER_SEPARATOR));
                g.drawString(Integer.toString(CREATURE_RANGES[i]),LEFT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),LEFT_FIRST_ICON_POS.y+7+(6*NUMBER_SEPARATOR));
                g.drawString(LEFT_CREATURE_KEYS[i],LEFT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),LEFT_FIRST_ICON_POS.y+7+(8*NUMBER_SEPARATOR));
            }
            
            // Rectangles of monsters in queue
            for(int i = 0; i<MAX_IN_QUEUE;i++){
                for(int j =0 ;j < this.summonQueue.size();j++){
                    g.fillRect(4+(j*65) + 5, 10, 45, 25);
                }
                g.drawRect(4+(i*65) + 5, 10, 45, 25);
            }
            
        // right team    
        } else {
            if(this.getGold()>=this.getEvolutionCost()){
                g.drawString(RIGHT_EVOLVE_STRING,950,SCREEN_HEIGHT-50);
                g.drawString(Integer.toString(this.getEvolutionCost()),860,SCREEN_HEIGHT-50);
            }
            g.drawString(this.userName,700,20);
            g.drawString(Double.toString(this.gold),730,75);
            g.drawString(Integer.toString(this.currentEvolution),750,100);
            for(int i= 0;i<NUM_CC_ICONS;i++){
                // Right Menu
                g.drawString(Integer.toString(CREATURE_HEALTHS[i]+(STAT_MULTIPLIERS[i]*this.currentEvolution)),RIGHT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),RIGHT_FIRST_ICON_POS.y+7+(2*NUMBER_SEPARATOR));
                g.drawString(Integer.toString(CREATURE_DAMAGES[i]+(STAT_MULTIPLIERS[i]*this.currentEvolution)),RIGHT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),RIGHT_FIRST_ICON_POS.y+7+(4*NUMBER_SEPARATOR));
                g.drawString(Integer.toString(CREATURE_RANGES[i]),RIGHT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),RIGHT_FIRST_ICON_POS.y+7+(6*NUMBER_SEPARATOR));
                g.drawString(RIGHT_CREATURE_KEYS[i],RIGHT_FIRST_CC_POS.x + (i*2*ICON_WIDTH),RIGHT_FIRST_ICON_POS.y+7+(8*NUMBER_SEPARATOR));
            }
            // Rectangles of monsters in queue
            for(int i = 0; i<MAX_IN_QUEUE;i++){
                for(int j =0; j < this.summonQueue.size();j++){
                    g.fillRect(SCREEN_WIDTH-(ICON_WIDTH*2) - 215 + (j*65),10,45,25);
                }
                g.drawRect(SCREEN_WIDTH-(ICON_WIDTH*2) - 215 + (i*65),10,45,25);
            }
        }        
    }
    
    //---------------------------------------
    public Tower getTower() {
        return this.tower;
    }
    
    public int getTeamSide() {
        return this.teamSide;
    }
    
    public LinkedList<Creature> getCreatures() {
        return this.creatures;
    }
    
    public Queue<Creature> getSummonQueue() {
        return summonQueue;
    }
    
    public double getGold() {
        return gold;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public int getCurrentEvolution() {
        return this.currentEvolution;
    }
    
    public int getEvolutionCost() {
        return evolutionCost;
    }
    
    //------------------------------------------
    
}
