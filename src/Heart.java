import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Heart {

	private int x;
	private int y;
	private int size;
	private Rectangle hitbox;

	public Heart() {
		x = 0;
		y = 0;
		size = 0;
		hitbox = null;
	}

	public Heart(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		Rectangle newhitbox = new Rectangle(x,y,size, size);
		hitbox = newhitbox;
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

	public void paint(Graphics g) throws IOException {
		BufferedImage image = ImageIO.read(new File("C:Images\\heart.png"));
		g.drawImage(image, x, y, size, size, null);
	}

}
