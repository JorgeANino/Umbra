
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Door {

	private boolean open;
	private int position;
	private int x;
	private int y;
	private int height;
	private int width;
	private Rectangle hitbox;
	private BufferedImage img;

	public Door() {
		this.open = false;
		this.x = 0;
		this.y = 0;
		this.height = 0;
		this.width = 0;
	}

	public Door(boolean open, int x, int y, int height, int width, int position) {
		super();
		this.open = open;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.position = position;
	}

	public Door(int x, int y, int pos) {
		this.open = false;
		this.x = x;
		this.y = y;
		this.height = 40;
		this.width = 40;
		this.position = pos;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void paint(Graphics g) throws IOException {
		hitbox = new Rectangle(x, y, width, height);
		if (open == false) {
			switch (this.position) {
			case 0:
				img = ImageIO.read(new File("C:Images\\door0.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			case 1:
				img = ImageIO.read(new File("Images\\door1.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			case 2:
				img = ImageIO.read(new File("Images\\door2.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			case 3:
				img = ImageIO.read(new File("Images\\door3.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			}
		} else {
			switch (this.position) {
			case 0:
				img = ImageIO.read(new File("Images\\Opened\\door0.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			case 1:
				img = ImageIO.read(new File("Images\\Opened\\door1.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			case 2:
				img = ImageIO.read(new File("Images\\Opened\\door2.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			case 3:
				img = ImageIO.read(new File("Images\\Opened\\door3.png"));
				g.drawImage(img, x, y, width, height, null);
				break;
			}

		}
	}
}
