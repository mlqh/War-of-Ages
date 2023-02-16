package Core;
import java.awt.Point;

public interface GameConstants {
    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 714;

    public static final int BACKGROUND_WIDTH = 1200;
    public static final int BACKGROUND_HEIGHT = 675;

    // Image paths
    public static final String PNG_EXT = ".png";
    public static final String BACKGROUND_PATH = "../Assets/Backgrounds/";

    public static final String LEFT_MOVE_PATH = "../Assets/Sprites/Left/Move/";
    public static final String LEFT_ATTACK_PATH = "../Assets/Sprites/Left/Attack/";
    public static final String LEFT_TOWER_PATH = "../Assets/Sprites/Left/Tower/";
    public static final String LEFT_TURRET_PATH = "../Assets/Sprites/Left/Turret/";
    public static final String LEFT_PROJECTILE_PATH = "../Assets/Sprites/Left/Projectiles/";

    public static final String RIGHT_MOVE_PATH = "../Assets/Sprites/Right/Move/";
    public static final String RIGHT_ATTACK_PATH = "../Assets/Sprites/Right/Attack/";
    public static final String RIGHT_TOWER_PATH = "../Assets/Sprites/Right/Tower/";
    public static final String RIGHT_TURRET_PATH = "../Assets/Sprites/Right/Turret/";
    public static final String RIGHT_PROJECTILE_PATH = "../Assets/Sprites/Right/Projectiles/";

    // Menu
    public static final String PAUSE_STRING = "SPACE";
    public static final String EVOLUTION = "EVO.";
    public static final String VOLUME_STRING = "G";
    public static final String LEFT_EVOLVE_STRING = "Press A To Evolve!";
    public static final String RIGHT_EVOLVE_STRING = "Press L to Evolve!";
    public static final String CREATURE_CREATION_ICONS_PATH = "../Assets/Menu/CreatureCreationIcons/";
    public static final String TURRET_CREATION_ICONS_PATH = "../Assets/Menu/TurretCreationIcons/";
    public static final String MAIN_ICONS_PATH = "../Assets/Menu/MainIcons/";
    public static final int ICON_WIDTH = 25;
    public static final int ICON_HEIGHT = 25;
    public static final int ICON_SEPARATOR = 20;
    public static final int NUMBER_SEPARATOR = 22;
    public static final int NUM_CC_ICONS = 4;
    public static final int NUM_CC_INFO = 5;
    public static final int NUM_MENU_ICONS = 9;
    public static final int HEALTH = 1;
    public static final int DAMAGE = 2;
    public static final int RANGE = 3;
    public static final int GOLD = 5;
    public static final int PAUSE = 6;
    public static final int VOLUME_OFF = 7;
    public static final int VOLUME_ON = 8;

    public static final Point LEFT_FIRST_ICON_POS = new Point(8, 50);
    public static final Point LEFT_FIRST_CC_POS = new Point(65, 50);

    public static final Point RIGHT_FIRST_ICON_POS = new Point(SCREEN_WIDTH - ICON_WIDTH - 30, 50);
    public static final Point RIGHT_FIRST_CC_POS = new Point(945, 50);

    // Misc
    public static final int MAX_IN_QUEUE = 4;
    public static final int STARTING_TURRETS = 0;
    public static final int STARTING_EVOLUTION = 0;
    public static final int NUM_EVOLUTIONS = 3;
    public static final int EVOLUTION_ONE = 1;
    public static final int EVOLUTION_TWO = 2;
    public static final int EVOLUTION_THREE = 3;
    public static final int EVOLVE_COST = 1000;
    public static final int EVOLVE_MULTIPLIER = 3;

    public static final int NUM_DIFFERENT_PROJECTILES = 3;
    public static final int NUM_DIFFERENT_CREATURES = 4;
    public static final int NUM_MOVE_SPRITES = 8;
    public static final int NUM_ATTACK_SPRITES = 3;
    public static final int NUM_TOWER_TURRET_SPRITES = 3;
    public static final int FLOOR_HEIGHT = 525;
    public static final int PAINT_DELAY = 50;
    public static final int SUMMON_DELAY = 1000;
    public static final int GOLD_DELAY = 1000;
    public static final int START_GOLD = 200;
    public static final int MAX_CREATURES_IN_QUEUE = 4;

    public static final int SECOND_PROJECTILES = 0;
    public static final int FOURTH_PROJECTILES = 1;
    public static final int TURRET_PROJECTILES = 2;
    public static final int GOLD_GAINED = 50;
    public static final Point[] LEFT_TURRET_POS = { new Point(50, FLOOR_HEIGHT - 10),
            new Point(80, FLOOR_HEIGHT - 10), new Point(110, FLOOR_HEIGHT - 10) };
    public static final Point[] RIGHT_TURRET_POS = { new Point(SCREEN_WIDTH - 90, FLOOR_HEIGHT - 10),
            new Point(SCREEN_WIDTH - 120, FLOOR_HEIGHT - 10),
            new Point((SCREEN_WIDTH - 150), FLOOR_HEIGHT - 10) };

    // Evolution constants
    public static final int HEAD = 0;

    // Left Team
    public static final int LEFT_TEAM = 1;
    public static final Point LEFT_TOWER = new Point(40, FLOOR_HEIGHT - 158);
    public static final Point LEFT_FIRST_TURRET_POS = new Point(50, FLOOR_HEIGHT - 10);
    public static final Point LEFT_SECOND_TURRET_POS = new Point(80, FLOOR_HEIGHT - 10);
    public static final Point LEFT_THIRD_TURRET_POS = new Point(110, FLOOR_HEIGHT - 10);
    public static final Point LEFT_SPAWN = new Point(0, FLOOR_HEIGHT - 18);
    public static final String[] LEFT_CREATURE_KEYS = { "1", "2", "3", "4" };
    public static final String[] LEFT_TURRET_KEYS = { "Z", "X", "C" };
    public static final String LEFT_EVOLVE_KEY = "A";

    // Right Team
    public static final int RIGHT_TEAM = -1;
    public static final Point RIGHT_TOWER = new Point(SCREEN_WIDTH - 160, FLOOR_HEIGHT - 158);
    public static final Point RIGHT_FIRST_TURRET_POS = new Point(SCREEN_WIDTH - 90, FLOOR_HEIGHT - 10);
    public static final Point RIGHT_SECOND_TURRET_POS = new Point(SCREEN_WIDTH - 120, FLOOR_HEIGHT - 10);
    public static final Point RIGHT_THIRD_TURRET_POS = new Point(SCREEN_WIDTH - 150, FLOOR_HEIGHT - 10);
    public static final Point RIGHT_SPAWN = new Point(SCREEN_WIDTH - 50, FLOOR_HEIGHT - 18);
    public static final String[] RIGHT_CREATURE_KEYS = { "7", "8", "9", "0" };
    public static final String[] RIGHT_TURRET_KEYS = { "M", "N", "B" };
    public static final String RIGHT_EVOLVE_KEY = "L";

    // Constants for type of entity to create
    public static final int FIRST_TYPE = 0;
    public static final int SECOND_TYPE = 1;
    public static final int THIRD_TYPE = 2;
    public static final int FOURTH_TYPE = 3;
    public static final int TOWER_TYPE = 4;
    public static final int TURRET_TYPE = 5;
    public static final int PROJECTILE_TYPE = 6;
}
