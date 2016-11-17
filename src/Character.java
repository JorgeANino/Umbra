import java.awt.Rectangle;

public class Character {
	protected int hp;
	protected String name;
	protected int power;
	protected int x;
	protected int y;
	protected int size;
	protected Rectangle hitbox;
	protected int knockback;

	public Character() {
		hp = 0;
		name = "";
		power = 0;
		size = 0;
		x = 0;
		y = 0;
		hitbox = null;
		knockback = 0;
		/*
		 * equipment = null; weapon = null;
		 */
	}

	public Character(
			int hp, String name, int power, int x, int y,
			int size, int knockback) {
		this.hp = hp;
		this.name = name;
		this.power = power;
		this.x = x;
		this.y = y;
		this.size = size;
		Rectangle newHitBox = new Rectangle(x, y, size, size);
		this.hitbox = newHitBox;
		this.knockback = knockback;
		/*
		 * this.weapon = weapon; this.equipment = equipment
		 */
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}

	public int getKnockback() {
		return knockback;
	}

	public void setKnockback(int knockback) {
		this.knockback = knockback;
	}
	

}
