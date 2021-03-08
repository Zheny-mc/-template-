import java.awt.*;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {	
		JFrame frame = new JFrame("Template");
		
		final int width = 640;
		final int height = 480;
		frame.setSize(new Dimension(width, height));
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//******************************************
		
		GraphicsPanel graphicsPanel = new GraphicsPanel(); 
		
		frame.addKeyListener(graphicsPanel.getController());
		
		frame.add(graphicsPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, 
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, 
				new Insets(2, 2, 2, 2), 0, 0));
	
		//*******************************************
		frame.setVisible(true);
	}
}