
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class AdventuringStuff {
	private String name;
	private int atk, x, y, height, width, stuff, knockback;
	private Rectangle r;
	private BufferedImage img;
	private ArrayList<String> preAdj;
	private ArrayList<String> postAdj;

	public AdventuringStuff(int stuff, int kb, int atk, int x, int y) {

		this.preAdj = new ArrayList<String>(10);
		this.postAdj = new ArrayList<String>(10);
		this.addRandomNames();
		this.stuff = stuff;// random pero en el canvas
		this.knockback = kb;// random pero en el canvas
		this.atk = atk; // random pero en el canvas
		this.name = this.stuffNameRPG(); // random pero local
		this.x = x;
		this.y = y;
		this.height = 35;
		this.width = 60;
		this.r = new Rectangle(x, y, width, height);
	}

	public int getStuff() {
		return stuff;
	}

	public void setStuff(int stuff) {
		this.stuff = stuff;
	}

	public int getKnockback() {
		return knockback;
	}

	public void setKnockback(int knockback) {
		this.knockback = knockback;
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}

	public ArrayList<String> getPreAdj() {
		return preAdj;
	}

	public void setPreAdj(ArrayList<String> preAdj) {
		this.preAdj = preAdj;
	}

	public ArrayList<String> getPostAdj() {
		return postAdj;
	}

	public void setPostAdj(ArrayList<String> postAdj) {
		this.postAdj = postAdj;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public void paint(Graphics g) throws IOException {
		switch (this.stuff) {
		case 0:
			img = ImageIO.read(new File("Images\\sword.png"));
			break;
		case 1:
			img = ImageIO.read(new File("Images\\axe.png"));
			break;
		case 2:
			img = ImageIO.read(new File("Images\\ring.png"));
			break;
		}
		g.drawImage(img, x, y, width, height, null);

	}
	
	public BufferedImage stuffImg() throws IOException {
		switch (this.stuff) {
		case 0:
			img = ImageIO.read(new File("Images\\sword.png"));
			break;
		case 1:
			img = ImageIO.read(new File("Images\\axe.png"));
			break;
		case 2:
			img = ImageIO.read(new File("Images\\ring.png"));
			break;
		}
		return img;
	}

	public void addRandomNames() {
		// Pre Adjectives
		String name0 = "Holy";
		preAdj.add(0, name0);
		String name1 = "Iron";
		preAdj.add(1, name1);
		String name2 = "Steel";
		preAdj.add(2, name2);
		String name3 = "Lost";
		preAdj.add(3, name3);
		String name4 = "Cursed";
		preAdj.add(4, name4);
		String name5 = "Profane";
		preAdj.add(5, name5);
		// Post Adjectives
		String name6 = "Loen Divad";
		postAdj.add(0, name6);
		String name7 = "The Fallen One";
		postAdj.add(1, name7);
		String name8 = "The High Lord";
		postAdj.add(2, name8);
		String name9 = "Elite Knight";
		postAdj.add(3, name9);
		String name10 = "Courage";
		postAdj.add(4, name10);
	}

	public String stuffNameRPG() {
		String stuffName = "";
		Random r = new Random();
		switch (this.stuff) {
		case 0:
			stuffName = preAdj.get(r.nextInt(6)) + " Sword of " + postAdj.get(r.nextInt(5));
			break;
		case 1:
			stuffName = preAdj.get(r.nextInt(6)) + " Axe of " + postAdj.get(r.nextInt(5));
			break;
		case 2:
			stuffName = preAdj.get(r.nextInt(6)) + " Ring of " + postAdj.get(r.nextInt(5));
			break;
		}
		return stuffName;
	}

}
