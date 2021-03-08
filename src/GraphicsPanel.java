import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private Ellipse2D figure;
	private Actions actions;
	private Vector<StateFigure> states;
	
	private boolean isClockWiseMovement;
	private boolean isUpMoreRadiusDownLessRadius;
	private boolean isCircleMotionAndIncreaseInRadius;
	
	private KeyAdapter controller;

	public GraphicsPanel() {
		isClockWiseMovement = false;
		isUpMoreRadiusDownLessRadius = false;
		isCircleMotionAndIncreaseInRadius = false;
		
		figure = new Circle(250, 250, 30, 30);
		actions = new ActionsCircle();
		actions.render();
		states = null;
		
		controller = new NumberKeyListener();
		
		(new Thread(this)).start(); 
	}
	
	public KeyAdapter getController() {
	    return controller;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.green);
		g2.fill(figure);
		g2.draw(figure);
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
	
	public void movie(final int delay) {
		states = actions.getAction();
		
		for (int i = 0; i < states.size(); i++) {
			figure.setFrame(states.get(i).getPoint().getX(), states.get(i).getPoint().getY(), states.get(i).getWidth(), states.get(i).getHeight());
			try {
				super.repaint();
				Thread.sleep(delay);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		while (true) {
			System.out.println("ClockWiseMovement" + isClockWiseMovement);
			if (isClockWiseMovement) {
				actions.clockWiseMovement();
				movie(1);
				isClockWiseMovement = false;
			}
			System.out.println("UpMoreRadiusDownLessRadius" + isUpMoreRadiusDownLessRadius);
			if (isUpMoreRadiusDownLessRadius) {
				actions.upMoreRadiusDownLessRadius();
				movie(1);
				isUpMoreRadiusDownLessRadius = false;
			}
			System.out.println("CircleMotionAndIncreaseInRadius" + isCircleMotionAndIncreaseInRadius);
			if (isCircleMotionAndIncreaseInRadius) {
				actions.circleMotionAndIncreaseInRadius();
				movie(1);
				isCircleMotionAndIncreaseInRadius = false;
			}
		}
		
	}
}
