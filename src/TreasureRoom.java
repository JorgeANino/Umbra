
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TreasureRoom {

	protected BufferedImage img;

	public TreasureRoom() {
		super();
	}

	public void paint(Graphics g) {

		try {
			img = ImageIO.read(new File("Images\\backgroundT.png"));
			g.drawImage(img, 0, 0, 490, 470, null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
