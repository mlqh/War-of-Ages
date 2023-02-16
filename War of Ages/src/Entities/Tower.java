package Entities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.awt.Color;

public class Tower extends Destructible {
    private LinkedList<Turret> turrets = new LinkedList<Turret>();
    private BufferedImage[] towerSprites;
    private BufferedImage[] turretSprites;
    private BufferedImage[] projectileSprites;
    private BufferedImage currentSprite;

    public Tower(int teamSide, int type, int evolution, BufferedImage[] towerSprites, BufferedImage[] turretSprites,
            BufferedImage[] projectileSprites) {
        super(teamSide, type, evolution);
        this.towerSprites = towerSprites;
        this.turretSprites = turretSprites;
        this.currentSprite = this.towerSprites[evolution];
        this.projectileSprites = projectileSprites;

        // make turret spots null initially so you can add to non-head nodes
        for (int i = 0; i < MAX_TURRET_SPOTS; i++) {
            this.turrets.add(null);
        }
    }

    public void addTurret(int turretSpot) {
        this.turrets.set(turretSpot, new Turret(getTeamSide(), turretSpot, getEvolution(),
                turretSprites[this.getEvolution()], projectileSprites[this.getEvolution()]));
    }

    public void removeTurret(int turretSpot) {
        this.turrets.remove(turretSpot);
    }

    public void draw(Graphics g) {
        int healthBar;
        int percentage;
        int healthBarX;
        double fullBar = (double) TOWER_WIDTH;
        if (this.getTeamSide() == LEFT_TEAM) {
            percentage = (int) ((this.getHealth() * 100.0f) / TOWER_HEALTH);
            healthBar = (int) (fullBar * percentage / 100.0);
            g.setColor(Color.RED);
            g.fillRect(this.getPosition().x, this.getPosition().y - 30, healthBar, 25);
        } else {
            percentage = (int) ((this.getHealth() * 100.0f) / TOWER_HEALTH);
            healthBar = (int) (fullBar * percentage / 100.0);
            healthBarX = this.getPosition().x + TOWER_WIDTH - healthBar - 2;
            g.setColor(Color.RED);
            g.fillRect(healthBarX, this.getPosition().y - 30, healthBar - 2, 25);
        }
        g.drawImage(this.currentSprite, this.getPosition().x, this.getPosition().y, null);
        if (this.turrets.size() > 0) {
            for (Turret turret : this.turrets) {
                if (turret != null) {
                    turret.draw(g);
                }
            }
        }
    }

    public BufferedImage getCurrentSprite() {
        return this.currentSprite;
    }

    public void setCurrentSprite(BufferedImage currentSprite) {
        this.currentSprite = currentSprite;
    }

    public LinkedList<Turret> getTurrets() {
        return turrets;
    }

}
