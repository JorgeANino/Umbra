import javax.swing.*;
import java.awt.BorderLayout;

public class MyWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	MyCanvas canvas;
	
	public MyWindow(){
		super();
		canvas = new MyCanvas();
		add(canvas,BorderLayout.CENTER);
	}

}
