package Entities;
import java.awt.Point;

import Core.Hitbox;

public abstract class Destructible extends Entity {

    private int health;
    private Hitbox hitbox;
    private int width, height;

    public Destructible(int teamSide, int type, int evolution) {
        super(teamSide, type, evolution);
        if (type == TOWER_TYPE) {
            this.health = TOWER_HEALTH;
            this.width = TOWER_WIDTH;
            this.height = TOWER_HEIGHT;

        } else {
            this.width = CREATURE_WIDTH;
            this.height = CREATURE_HEIGHT;

            switch (type) {
                case FIRST_TYPE:
                    this.health = FIRST_HEALTH + (evolution * FIRST_MULTIPLIER);
                    break;

                case SECOND_TYPE:
                    this.health = SECOND_HEALTH + (evolution * SECOND_MULTIPLIER);
                    break;

                case THIRD_TYPE:
                    this.health = THIRD_HEALTH + (evolution * THIRD_MULTIPLIER);
                    break;

                case FOURTH_TYPE:
                    this.health = FOURTH_HEALTH + (evolution * FOURTH_MULTIPLIER);
                    break;
            }
        }
        this.hitbox = new Hitbox(new Point(this.getPosition()), this.width, this.height);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return this.health;
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}