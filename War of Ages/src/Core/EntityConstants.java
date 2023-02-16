package Core;

public interface EntityConstants {
    // Tower and turret constants
    public static final int TOWER_WIDTH = 108;
    public static final int TOWER_HEIGHT = 185;
    public static final int TOWER_HEALTH = 500;
    public static final int TURRET_WIDTH = 28;
    public static final int TURRET_HEIGHT = 15;
    public static final int TURRET_MULTIPLIER = 5;

    // Turret stats
    public static final int TURRET_HEALTH = 10;
    public static final int TURRET_ATTACK = 10;
    public static final int TURRET_RANGE = 150;
    public static final long TURRET_ATTACK_SPEED = 600;
    public static final int BASE_GOLD_BUY = 1000;
    public static final int BASE_GOLD_SELL = 500;
    public static final int TURRET_UPGRADE = 3;
    public static final int MAX_TURRET_SPOTS = 3;

    public static final int FIRST_TURRET = 0;
    public static final int SECOND_TURRET = 1;
    public static final int THIRD_TURRET = 2;

    // Creature constants
    public static final int CREATURE_HEIGHT = 44;
    public static final int CREATURE_WIDTH = 19;
    public static final double KILL_REWARD = 0.5;
    public static final int INITIAL_SPRITE_INDEX = 0;
    public static final int IDLE_ACTIVITY = 0;
    public static final int MOVE_ACTIVITY = 1;
    public static final int ATTACK_ACTIVITY = 2;
    public static final int FIRST_SPRITE = 0;
    public static final int LAST_MOVE_SPRITE = 7;
    public static final int LAST_ATTACK_SPRITE = 2;
    public static final int IDLE_SPRITE = 0;
    public static final int ARM_HEIGHT = 13;
    public static final int[] CREATURE_HEALTHS = { 100, 50, 200, 70 };
    public static final int[] CREATURE_DAMAGES = { 7, 5, 10, 15 };
    public static final int[] CREATURE_RANGES = { 7, 120, 4, 100 };
    public static final int[] STAT_MULTIPLIERS = { 2, 2, 3, 3 };

    // First creature base stats
    public static final int FIRST_COST = 200;
    public static final double FIRST_KILL_GOLD = FIRST_COST * KILL_REWARD;
    public static final int FIRST_HEALTH = 100;
    public static final int FIRST_ATTACK = 7;
    public static final int FIRST_RANGE = 7;
    public static final int FIRST_SPEED = 4;
    public static final long FIRST_ATTACK_SPEED = 600;
    public static final int FIRST_MULTIPLIER = 2;

    // Second creature base stats
    public static final int SECOND_COST = 300;
    public static final double SECOND_KILL_GOLD = SECOND_COST * KILL_REWARD;
    public static final int SECOND_HEALTH = 50;
    public static final int SECOND_ATTACK = 5;
    public static final int SECOND_RANGE = 120;
    public static final int SECOND_SPEED = 4;
    public static final long SECOND_ATTACK_SPEED = 600;
    public static final int SECOND_MULTIPLIER = 2;

    // Third creature base stats
    public static final int THIRD_COST = 500;
    public static final double THIRD_KILL_GOLD = THIRD_COST * KILL_REWARD;
    public static final int THIRD_HEALTH = 200;
    public static final int THIRD_ATTACK = 10;
    public static final int THIRD_RANGE = 5;
    public static final int THIRD_SPEED = 4;
    public static final long THIRD_ATTACK_SPEED = 800;
    public static final int THIRD_MULTIPLIER = 3;

    // Fourth creature base stats
    public static final int FOURTH_COST = 600;
    public static final double FOURTH_KILL_GOLD = FOURTH_COST * KILL_REWARD;
    public static final int FOURTH_HEALTH = 100;
    public static final int FOURTH_ATTACK = 20;
    public static final int FOURTH_RANGE = 100;
    public static final int FOURTH_SPEED = 4;
    public static final long FOURTH_ATTACK_SPEED = 700;
    public static final int FOURTH_MULTIPLIER = 3;

    // Projectile
    public static final int PROJECTILE_SPEED = 5;
    public static final int TURRET_PROJECTILE = 1;
    public static final int SECOND_PROJECTILE = 2;
    public static final int FOURTH_PROJECTILE = 3;

    public static final int MISSILE_WIDTH = 25;
    public static final int MISSILE_HEIGHT = 11;
    public static final int ARROW_WIDTH = 30;
    public static final int ARROW_HEIGHT = 10;
    public static final int FRUIT_WIDTH = 12;
    public static final int FRUIT_HEIGHT = 12;

}
