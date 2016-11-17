import java.awt.Graphics;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class EnemyRoom {

	protected static final long serialVersionUID = 1L;
	protected BufferedImage img;

	public EnemyRoom() {
		super();
	}

	public void paint(Graphics g) {
		try {
			img = ImageIO.read(new File("C:Images\\background.png"));
			g.drawImage(img, 0, 0, 490, 470, null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
