import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Slash {
	private int x, y, vel, size, pos, sizeAtk;
	private Rectangle hitBox;
	private BufferedImage image;

	public Slash(int x, int y) {
		this.pos = 0;
		this.x = x;
		this.y = y;
		this.size = 20;
		this.vel = 10;
		this.sizeAtk = 50;
		this.hitBox = new Rectangle(x, y, size, size);
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

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public Rectangle getHitBox() {
		return hitBox;
	}

	public void setHitBox(Rectangle hitBox) {
		this.hitBox = hitBox;
	}

	public void paint(Graphics g) throws IOException {
		switch (pos) {
		case 8:
			image = ImageIO.read(new File("Images\\atak8.png"));
			g.drawImage(image, this.getX(), this.getY(), sizeAtk, sizeAtk, null);
			break;
		case 6:
			image = ImageIO.read(new File("Images\\atak6.png"));
			g.drawImage(image, this.getX(), this.getY(), sizeAtk, sizeAtk, null);
			break;
		case 2:
			image = ImageIO.read(new File("Images\\atak2.png"));
			g.drawImage(image, this.getX(), this.getY(), sizeAtk, sizeAtk, null);
			break;
		case 4:
			image = ImageIO.read(new File("Images\\atak4.png"));
			g.drawImage(image, this.getX(), this.getY(), sizeAtk, sizeAtk, null);
			break;
		}
		//g.setColor(Color.MAGENTA);
		//g.fillRect(x, y, size, size);
	}
}
