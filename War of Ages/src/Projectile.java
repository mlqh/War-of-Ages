import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Projectile implements GameConstants, EntityConstants {

    private Hitbox hitbox;
    private Point position;
    private int damage;
    private int speed;
    private BufferedImage currentSprite;
    private Point initialPos;

    public Projectile(int teamSide, int type, int damage, Point position, BufferedImage sprite) {
        this.position = position;
        this.initialPos = new Point(this.position);
        this.currentSprite = sprite;
        this.damage = damage;
        this.speed = PROJECTILE_SPEED * teamSide;

        if (type == TURRET_PROJECTILE) {
            this.hitbox = new Hitbox(this.position, MISSILE_WIDTH, MISSILE_HEIGHT);

        } else if (type == SECOND_PROJECTILE) {
            this.hitbox = new Hitbox(this.position, ARROW_WIDTH, ARROW_HEIGHT);

        } else {
            this.hitbox = new Hitbox(this.position, FRUIT_WIDTH, FRUIT_WIDTH);
        }
    }

    public void move() {
        this.position.x += this.speed;
        this.hitbox.update(this.position);
    }

    public boolean checkCollide(Destructible enemy) {
        return this.hitbox.checkCollide(enemy.getHitbox());
    }

    public void draw(Graphics g) {
        g.drawImage(this.currentSprite, this.position.x, this.position.y, null);
    }

    // ---------------------------------
    public Hitbox getHitbox() {
        return hitbox;
    }

    public Point getPosition() {
        return this.position;
    }

    public Point getInitialPos() {
        return this.initialPos;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public BufferedImage getCurrentSprite() {
        return this.currentSprite;
    }

}
