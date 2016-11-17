import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {

	public Menu() {
	}

	public void paint(Graphics g) throws IOException {
		BufferedImage image = ImageIO.read(new File("C:Images\\YOU DIED.jpg"));
		g.drawImage(image, 0, 0, 490, 470, null);
	}

}
