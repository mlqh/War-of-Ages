package Entities;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import Core.Hitbox;
import Core.EntityConstants;
import Core.GameConstants;

public abstract class Entity implements GameConstants, EntityConstants {

    private Point position;
    private Hitbox hitbox;

    private int teamSide;
    private int type;
    private int evolution;

    public Entity(int teamSide, int type, int evolution) {
        this.type = type;
        this.teamSide = teamSide;
        this.evolution = evolution;

        // create a tower
        if (type == TOWER_TYPE) {
            if (teamSide == LEFT_TEAM) {
                this.position = new Point(LEFT_TOWER);
            } else {
                this.position = new Point(RIGHT_TOWER);
            }

            // create a creature
        } else {
            if (teamSide == LEFT_TEAM) {
                this.position = new Point(LEFT_SPAWN);
            } else {
                this.position = new Point(RIGHT_SPAWN);
            }
        }
    }

    // get the closest enemy
    public Destructible getEnemyAhead(Player other) {
        LinkedList<Creature> creatures = other.getCreatures();

        // no creatures, closest enemy is tower
        if (creatures.isEmpty()) {
            return other.getTower();

        } else {
            if (this.teamSide == LEFT_TEAM) {
                if (creatures.getFirst().getPosition().x < other.getTower().getPosition().x) {
                    return creatures.getFirst();
                } else {
                    return other.getTower();
                }

            } else {
                if (creatures.getFirst().getPosition().x > other.getTower().getPosition().x) {
                    return creatures.getFirst();
                } else {
                    return other.getTower();
                }
            }
        }
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public int getTeamSide() {
        return teamSide;
    }

    public int getType() {
        return type;
    }

    public int getEvolution() {
        return evolution;
    }

    public abstract BufferedImage getCurrentSprite();

}