import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends Character {

	private Double position;
	private int direction;
	private int speed;
	private int move;

	public Enemy() {
		super();
		position = 0.0;
		direction = 0;
		speed = 0;
		move = 1;
	}

	public Enemy(int hp, String name, int power, int x, int y, int size, int speed, int knockback) {
		super(hp, name, power, x, y, size, knockback);
		position = 0.0;
		direction = 0;
		this.speed = speed;
		move = 1;
	}

	public Double getPosition() {
		return position;
	}

	public void setPosition(Double position) {
		this.position = position;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}



	public void paint(Graphics g) throws IOException {
		// 0 = abajo
		// 1 = arriba
		// 2 = derecha
		// 3 = izquierda
		if (position == 0.0) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos0.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 0.1) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos0.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 0.2) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos0.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.0) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.1) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos1.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 1.2) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos1.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.0) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.1) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos2.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 2.2) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos2.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.0) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos3.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.1) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos3.1.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		} else if (position == 3.2) {
			BufferedImage image = ImageIO.read(new File(
					"Images\\enemypos3.2.jpg"));
			g.drawImage(image, this.getX(), this.getY(), size, size, null);
		}
		
		// hp
		g.setColor(Color.RED);
		g.fillRect(super.getX(), super.getY() - this.getSize() / 6, super.getHp() / 2, 3);
		// name
		g.setColor(Color.WHITE);
		g.drawString(super.getName(), super.getX() + 10, super.getY() + super.getSize() + 10);
	}
}
