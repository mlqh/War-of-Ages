/**
 * Turret.java
 * Turret class
 * Matthew Hao
 * Jan 20, 2020
 */

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Turret extends Entity implements EntityConstants { 
	private int goldFromSell;
	private int damage;
	private long attackSpeed;
	private Hitbox rangebox;
	private long timeStartedAttack;
	private Destructible currentTarget;
	private boolean idling;

	private BufferedImage currentSprite;
	private BufferedImage projectileSprite;
	private LinkedList<Projectile> projectiles = new LinkedList<Projectile>();

	public Turret(int teamSide, int turretSpot, int evolution, BufferedImage currentSprite, BufferedImage projectileSprite) {
		super(teamSide, TURRET_TYPE, evolution);
		this.goldFromSell = BASE_GOLD_SELL + (evolution * TURRET_UPGRADE);
		this.attackSpeed = TURRET_ATTACK_SPEED;
		this.currentSprite = currentSprite;
		this.projectileSprite = projectileSprite;
		this.damage = TURRET_ATTACK + (evolution * TURRET_UPGRADE);
		this.attackSpeed = TURRET_ATTACK_SPEED;

		switch(turretSpot) {
		case FIRST_TURRET:
			if(teamSide == LEFT_TEAM) {
				this.setPosition(LEFT_FIRST_TURRET_POS);
				this.rangebox = new Hitbox(new Point(this.getPosition().x + TURRET_WIDTH, this.getPosition().y) ,TURRET_RANGE,TURRET_RANGE);
			} else {
				this.setPosition(RIGHT_FIRST_TURRET_POS);
				this.rangebox = new Hitbox(new Point(this.getPosition().x - TURRET_RANGE, this.getPosition().y) ,TURRET_RANGE,TURRET_RANGE);
			}
			break;

		case SECOND_TURRET:
			if(teamSide == LEFT_TEAM) {
				this.setPosition(LEFT_SECOND_TURRET_POS);
				this.rangebox = new Hitbox(new Point(this.getPosition().x + TURRET_WIDTH, this.getPosition().y) ,TURRET_RANGE,TURRET_RANGE);
			} else {
				this.setPosition(RIGHT_SECOND_TURRET_POS);
				this.rangebox = new Hitbox(new Point(this.getPosition().x - TURRET_RANGE, this.getPosition().y) ,TURRET_RANGE,TURRET_RANGE);
			}
			break;

		case THIRD_TURRET:
			if(teamSide == LEFT_TEAM) {
				this.setPosition(LEFT_THIRD_TURRET_POS);
				this.rangebox = new Hitbox(new Point(this.getPosition().x + TURRET_WIDTH, this.getPosition().y) ,TURRET_RANGE,TURRET_RANGE);
			} else {
				this.setPosition(RIGHT_THIRD_TURRET_POS);
				this.rangebox = new Hitbox(new Point(this.getPosition().x - TURRET_RANGE, this.getPosition().y) ,TURRET_RANGE,TURRET_RANGE);
			}
			break;
		}   
	}

	public void attack(Destructible target) {
		this.currentTarget = target;
		Point projPos;
		if(this.getTeamSide() == LEFT_TEAM) {
			projPos = new Point(this.getPosition().x + TURRET_WIDTH, this.getPosition().y);
		} else {
			projPos = new Point(this.getPosition());
		}
		Projectile projectile = new Projectile(this.getTeamSide(), TURRET_PROJECTILE, this.getDamage(), projPos, projectileSprite);
		this.projectiles.add(projectile);
		this.setTimeStartedAttack(System.currentTimeMillis());    }

	public void draw(Graphics g) {
		g.drawImage(this.currentSprite, this.getPosition().x,this.getPosition().y, null);
		for(int i = 0; i < this.projectiles.size(); i++) {
			this.projectiles.get(i).draw(g);
		}
	}
	//-----------------------------------------/
	public int getGoldFromSell() {
		return this.goldFromSell;
	}

	public long getTimeStartedAttack(){
		return this.timeStartedAttack;
	}

	public void setTimeStartedAttack(long timeStarted){
		this.timeStartedAttack = timeStarted;
	}

	public Destructible getCurrentTarget(){
		return this.currentTarget;
	}
	public void setCurrentTarget(Destructible target){
		this.currentTarget = target;
	}

	public double getAttackSpeed() {
		return this.attackSpeed;
	}

	public Hitbox getRangebox() {
		return this.rangebox;
	}

	public LinkedList<Projectile> getProjectiles() {
		return this.projectiles;
	}

	public int getDamage() {
		return this.damage;
	}

	public boolean getIdling(){
		return this.idling;
	}

	public void setIdling(boolean state){
		this.idling = state;
	}
	//-------------------------------------------/
	@Override
	public BufferedImage getCurrentSprite() {
		return this.currentSprite;
	}


} // Turret class