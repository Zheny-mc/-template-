package springhw;

import java.awt.*;
import javax.swing.*;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static JFrame frame;
	private static GraphicsPanel graphicsPanel;
	
	public static void cofigurui() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("mainContext.xml");
		graphicsPanel = ctx.getBean("graphicsPanel", GraphicsPanel.class);
		graphicsPanel.createButtons();
		graphicsPanel.startThread();	 
		
		ctx.close();
		
		frame = new JFrame();
	}
	
	public static void renderWindow() {
		final int width = 640;
		final int height = 480;
		frame.setTitle("MovingCircle");
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