package ver_2.graphics;
import java.awt.*;
import javax.swing.*;

public class Main {
	private static JFrame frame;
	private static GraphicsPanel graphicsPanel;
	
	public static void cofigurui() {
		frame = new JFrame("Template");
		graphicsPanel = new GraphicsPanel(); 
	}
	
	public static void renderWindow() {
		final int width = 640;
		final int height = 480;
		frame.setSize(new Dimension(width, height));
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//******************************************
		
		frame.addKeyListener(graphicsPanel);
		
		frame.add(graphicsPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, 
				new Insets(2, 2, 2, 2), 0, 0));
	
		//*******************************************
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {	
		cofigurui();
		renderWindow();
	}
}