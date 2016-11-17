import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainCharacter extends Character {
	private int lives;
	private boolean gender;
	private Double position;
	private int pressed;
	private boolean attacked, immune;
	private int speed;

	public MainCharacter() {
		super();
		this.lives = 0;
		this.gender = false;
		position = 0.0;
		pressed = 1;
		speed = 0;
		attacked = false;
		immune = false;

	}

	public MainCharacter(int hp, String name, int power, int lives, boolean gender, int x, int y, int size, int speed,
			int knockback) {
		super(hp, name, power, x, y, size, knockback);
		this.lives = lives;
		this.gender = gender;
		this.position = 0.0;
		pressed = 1;
		this.speed = speed;
		attacked = false;
		immune = false;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Double getPosition() {
		return position;
	}

	public void setPosition(Double position) {
		this.position = position;
	}

	public int getPressed() {
		return pressed;
	}

	public void setPressed(int pressed) {
		this.pressed = pressed;
	}

	public int getSpeed() {
		return speed;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isAttacked() {
		return attacked;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isInmune() {
		return immune;
	}

	public void setInmune(boolean inmune) {
		this.immune = inmune;
	}

	public void paint(Graphics g) throws IOException {
		if (position == 0.0 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos0.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 0.1 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos0.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 0.2 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos0.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.0 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.1 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos1.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.2 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos1.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.0 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.1 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos2.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.2 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos2.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.0 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos3.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.1 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos3.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.2 && gender == false && attacked == false) {
			BufferedImage image = ImageIO.read(new File("C:Images\\zeldapos3.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		}
		if (position == 0.0 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos0.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 0.1 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos0.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 0.2 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos0.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.0 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.1 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos1.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.2 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos1.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.0 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.1 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos2.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.2 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos2.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.0 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos3.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.1 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos3.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.2 && gender == false && attacked == true) {
			BufferedImage image = ImageIO.read(new File("C:Images\\Attacked\\zeldapos3.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 6.0 && gender == false) {
			BufferedImage image = ImageIO.read(new File("Images\\zeldapos6.png"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 4.0 && gender == false) {
			BufferedImage image = ImageIO.read(new File("Images\\zeldapos4.png"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 5.0 && gender == false) {
			BufferedImage image = ImageIO.read(new File("Images\\zeldapos5.png"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 7.0 && gender == false) {
			BufferedImage image = ImageIO.read(new File("Images\\zeldapos7.png"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		}

		// hp
		g.setColor(Color.RED);
		g.fillRect(super.getX(), super.getY() - this.getSize() / 6, super.getHp() / 2, 3);
		// name
		g.setColor(Color.WHITE);
		g.drawString(super.getName(), super.getX(), super.getY() + super.getSize() + 10);

	}

}
