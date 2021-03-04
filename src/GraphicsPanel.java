import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private Circle circle;
	
	private int widthMap; 
	private int heightMap;
	
	private boolean isClockWiseMovement;
	private boolean isUpMoreRadiusDownLessRadius;
	private boolean isCircleMotionAndIncreaseInRadius;
	
	private KeyAdapter controller;

	public GraphicsPanel() {
		isClockWiseMovement = false;
		isUpMoreRadiusDownLessRadius = false;
		isCircleMotionAndIncreaseInRadius = false;
		
		circle = new Circle(250, 250, 30, 30);
		
		controller = new NumberKeyListener();
		
		(new Thread(this)).start(); 
	}
	
	public GraphicsPanel(int widthMap, int heightMap) {
		this();
		this.widthMap = widthMap; 
		this.heightMap = heightMap;
	}
	
	public KeyAdapter getController() {
	    return controller;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.green);
		g2.fill(circle);
		g2.draw(circle);
	}

	private class NumberKeyListener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == (int)'Q') {
				isClockWiseMovement = true;
				//System.out.println("ClockWiseMovement");
			} else if (e.getKeyCode() == (int)'W') {
				isUpMoreRadiusDownLessRadius = true;
				//System.out.println("UpMoreRadiusDownLessRadius");
			} else if (e.getKeyCode() == (int)'E') {
				isCircleMotionAndIncreaseInRadius = true;
				//System.out.println("CircleMotionAndIncreaseInRadius");
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}
	
	public void run() {
		while (true) {
			System.out.println("ClockWiseMovement" + isClockWiseMovement);
			if (isClockWiseMovement) {
				clockWiseMovement();
				isClockWiseMovement = false;
			}
			System.out.println("UpMoreRadiusDownLessRadius" + isUpMoreRadiusDownLessRadius);
			if (isUpMoreRadiusDownLessRadius) {
				upMoreRadiusDownLessRadius();
				isUpMoreRadiusDownLessRadius = false;
			}
			System.out.println("CircleMotionAndIncreaseInRadius" + isCircleMotionAndIncreaseInRadius);
			if (isCircleMotionAndIncreaseInRadius) {
				circleMotionAndIncreaseInRadius();
				isCircleMotionAndIncreaseInRadius = false;
			}
		}
		
	}
	
	public void clockWiseMovement() {
		
		 for (int i = 0; i <= 360; i+=15) {
			for (double j = 0.d; j < 1; j+=0.005) {
				try {
					circle.move((i*0.0174533), 1);
					super.repaint();
					Thread.sleep(1);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			circle.setCurDistance(0);
			circle.setFrame(250, 250, 30, 30);
		}
	}
	
	public void upMoreRadiusDownLessRadius() {
		
		for (int i = 0; i < 3; i++) {
			for (double j = 0.d; j <= 10; j+=0.005) {
				try {
					for (int k = 0; k < 10; k++) {
						circle.upRadius();
						circle.moveUpBoard();
					}
						
					super.repaint();
					Thread.sleep(1);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for (double j = 0.d; j <= 10; j+=0.005) {
				try {
					for (int k = 0; k < 10; k++) {
						circle.downRadius();
						circle.moveDownBoard();
					}
					
					super.repaint();
					Thread.sleep(1);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void circleMotionAndIncreaseInRadius() {
		final double DELTA = 0.005d;
		final int DELTA_ALPHA = 3;
		final double DISTANCE = 0.15;
		
		for (int num = 0; num <= 3; num++) {
			for (int alpha = 0; alpha < 360; alpha+=DELTA_ALPHA) {
				for (double i = 0; i <= DISTANCE; i+=DELTA) {
					try {
						circle.move((-alpha*0.0174533), DISTANCE);
						super.repaint();
						Thread.sleep(1);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				circle.setCurDistance(0);
			}
			for (int k = 0; k < 5000; k++)
				circle.upRadius();
	
		}
	}
}
