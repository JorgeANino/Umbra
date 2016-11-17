
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BossRoom {
	public BufferedImage img;

	public BossRoom() {
		img = null;
	}

	public void paint(Graphics g) throws IOException {

		BufferedImage img = ImageIO.read(new File("Images\\backgrundORIGINAL.png"));
		g.drawImage(img, 0, 0, 490, 470, null);
	}
}
