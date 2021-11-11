import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Creature extends Destructible {

	private int speed;
	private Hitbox rangebox;
	private int damage;
	private double goldFromKill;
	private long attackSpeed;
	private int currentActivity = IDLE_ACTIVITY;
	private long timeStartedAttack;
	private Destructible currentTarget;

	private BufferedImage[] moveSprites;
	private BufferedImage[] attackSprites;
	private BufferedImage currentSprite;
	private int currentMoveIndex;
	private int currentAttackIndex;
	private boolean idling = false;

	public Creature(int teamSide, int type, int evolution, BufferedImage[] move, BufferedImage[] attack) {
		super(teamSide, type, evolution);
		this.moveSprites = move;
		this.attackSprites = attack;
		this.currentSprite = this.moveSprites[INITIAL_SPRITE_INDEX];
		this.currentMoveIndex = INITIAL_SPRITE_INDEX;
		int range = 0;

		switch (type) {
		case FIRST_TYPE:
			this.damage = FIRST_ATTACK + (evolution * FIRST_MULTIPLIER);
			this.speed = FIRST_SPEED * this.getTeamSide();
			this.attackSpeed = FIRST_ATTACK_SPEED;
			this.goldFromKill = FIRST_KILL_GOLD;
			range = FIRST_RANGE;
			break;

		case SECOND_TYPE:
			this.damage = SECOND_ATTACK + (evolution * SECOND_MULTIPLIER);
			this.speed = SECOND_SPEED * this.getTeamSide();
			this.attackSpeed = SECOND_ATTACK_SPEED;
			this.goldFromKill = SECOND_KILL_GOLD;
			range = SECOND_RANGE;
			break;

		case THIRD_TYPE:
			this.damage = THIRD_ATTACK + (evolution * THIRD_MULTIPLIER);
			this.speed = THIRD_SPEED * this.getTeamSide();
			this.attackSpeed = THIRD_ATTACK_SPEED;
			this.goldFromKill = THIRD_KILL_GOLD;
			range = THIRD_RANGE;
			break;

		case FOURTH_TYPE:
			this.damage = FOURTH_ATTACK + (evolution * FOURTH_MULTIPLIER);
			this.speed = FOURTH_SPEED * this.getTeamSide();
			this.attackSpeed = FOURTH_ATTACK_SPEED;
			this.goldFromKill = FOURTH_KILL_GOLD;
			range = FOURTH_RANGE;
			break;
		}

		if (teamSide == LEFT_TEAM) {
			Point point = new Point(this.getPosition().x + this.getWidth(), this.getPosition().y);
			this.rangebox = new Hitbox(point, range, range);
		} else {
			Point point = new Point(this.getPosition().x - range, this.getPosition().y);
			this.rangebox = new Hitbox(point, range, range);
		}
	}

	public void attack(Destructible target) {
		this.currentTarget = target;
		if (this.currentAttackIndex == LAST_ATTACK_SPRITE) {
			this.currentAttackIndex = FIRST_SPRITE;
		} else {
			this.currentAttackIndex++;
		}
		this.currentSprite = attackSprites[currentAttackIndex];

		target.takeDamage(this.damage);
		// update attack time
		this.timeStartedAttack = System.currentTimeMillis();
	}

	public void move() {
		if (this.currentMoveIndex == LAST_MOVE_SPRITE) {
			this.currentMoveIndex = FIRST_SPRITE;
		} else {
			this.currentMoveIndex++;
		}
		this.currentSprite = moveSprites[currentMoveIndex];
		this.updatePositions();
	}

	// update positions of this creature's hitbox, rangebox, itself
	public void updatePositions() {
		Point creaturePos = this.getPosition();
		Point hitboxPos = this.getHitbox().getPosition();
		Point rangeboxPos = this.rangebox.getPosition();

		creaturePos.setLocation(creaturePos.x + this.speed, creaturePos.y);
		hitboxPos.setLocation(hitboxPos.x + this.speed, hitboxPos.y);
		rangeboxPos.setLocation(rangeboxPos.x + this.speed, rangeboxPos.y);

		this.setPosition(creaturePos);
		this.getHitbox().update(hitboxPos);
		this.getRangebox().update(rangeboxPos);
	}

	// get the friendly creature directly ahead
	public Creature getFriendlyAhead(Player self) {
		LinkedList<Creature> creatures = self.getCreatures();
		int thisIndex = creatures.indexOf(this);
		return creatures.get(thisIndex - 1);
	}

	public void draw(Graphics g) {
		if (this.idling) {
			this.currentSprite = this.moveSprites[IDLE_SPRITE];
		}
		g.drawImage(this.currentSprite, this.getPosition().x, this.getPosition().y, null);
	}

	// ------------------------------------
	public int getDamage() {
		return this.damage;
	}

	public Destructible getCurrentTarget() {
		return this.currentTarget;
	}

	public void setCurrentTarget(Destructible target) {
		this.currentTarget = target;
	}

	public long getTimeStartedAttack() {
		return this.timeStartedAttack;
	}

	public void setTimeStartedAttack(long startTime) {
		this.timeStartedAttack = startTime;
	}

	public int getSpeed() {
		return this.speed;
	}

	public Hitbox getRangebox() {
		return this.rangebox;
	}

	public BufferedImage[] getMoveSprites() {
		return this.moveSprites;
	}

	public BufferedImage[] getAttackSprites() {
		return this.attackSprites;
	}

	public BufferedImage getCurrentSprite() {
		return this.currentSprite;
	}

	public void setCurrentSprite(BufferedImage currentSprite) {
		this.currentSprite = currentSprite;
	}

	public void setCurrentSpriteIndex(int currentSpriteIndex) {
		this.currentMoveIndex = currentSpriteIndex;
	}

	public double getGoldFromKill() {
		return goldFromKill;
	}

	public long getAttackSpeed() {
		return attackSpeed;
	}

	public int getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(int currentActivity) {
		this.currentActivity = currentActivity;
	}

	public int getCurrentMoveIndex() {
		return currentMoveIndex;
	}

	public void setCurrentMoveIndex(int currentMoveIndex) {
		this.currentMoveIndex = currentMoveIndex;
	}

	public int getCurrentAttackIndex() {
		return currentAttackIndex;
	}

	public void setCurrentAttackIndex(int currentAttackIndex) {
		this.currentAttackIndex = currentAttackIndex;
	}

	public boolean getIdling() {
		return idling;
	}

	public void setIdling(boolean idling) {
		this.idling = idling;
		if (idling) {
			this.setCurrentSprite(this.getMoveSprites()[HEAD]);
		}
	}

}