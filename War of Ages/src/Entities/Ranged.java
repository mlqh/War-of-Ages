package Entities;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Ranged extends Creature {

    private LinkedList<Projectile> projectiles = new LinkedList<Projectile>();
    private BufferedImage projectileSprite;
    private int projectileType;

    public Ranged(int team, int type, int evolution, BufferedImage[] move, BufferedImage[] attack,
            BufferedImage projectileSprite) {
        super(team, type, evolution, move, attack);
        this.projectileSprite = projectileSprite;
        if (type == SECOND_TYPE) {
            this.projectileType = SECOND_PROJECTILES;
        } else {
            this.projectileType = FOURTH_PROJECTILES;
        }
    }

    public void attack(Destructible target) {
        this.setCurrentTarget(target);
        Point projPos;
        if (this.getCurrentAttackIndex() == LAST_ATTACK_SPRITE) {
            this.setCurrentAttackIndex(FIRST_SPRITE);
        } else {
            this.setCurrentAttackIndex(this.getCurrentAttackIndex() + 1);
        }
        this.setCurrentSprite(this.getAttackSprites()[this.getCurrentAttackIndex()]);

        if (this.getTeamSide() == LEFT_TEAM) {
            projPos = new Point(this.getPosition().x + CREATURE_WIDTH, this.getPosition().y + ARM_HEIGHT);
            Projectile projectile = new Projectile(this.getTeamSide(), this.projectileType, this.getDamage(), projPos,
                    projectileSprite);
            this.projectiles.add(projectile);
            this.setTimeStartedAttack(System.currentTimeMillis());
        } else {
            projPos = new Point(this.getPosition().x, this.getPosition().y + ARM_HEIGHT);
            Projectile projectile = new Projectile(this.getTeamSide(), this.projectileType, this.getDamage(), projPos,
                    projectileSprite);
            this.projectiles.add(projectile);
            this.setTimeStartedAttack(System.currentTimeMillis());
        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.getCurrentSprite(), this.getPosition().x, this.getPosition().y, null);
        for (int i = 0; i < this.projectiles.size(); i++) {
            this.projectiles.get(i).draw(g);
        }
    }

    public LinkedList<Projectile> getProjectiles() {
        return this.projectiles;
    }

}
