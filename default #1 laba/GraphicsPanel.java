import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements Runnable, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	private final int KEY_CLOCK_WISE_MOVEMENT = (int)'Q';
	private final int KEY_UP_MORE_RADIUS_DOWN_LESS_RADIUS = (int)'W';
	private final int KEY_CIRCLE_MOTION_AND_INCREASE_IN_RADIUS = (int)'E';
	private final int KEY_FOUR_CIRCLE = (int)'R';
	
	private final Point BIGIN_POINT = new Point(250, 250);
	private final int RADIUS = 30;
	private int indexMovement;
	//******************************************************************
	private Ellipse2D figure;
	private Actions actions;
	private Vector<StateFigure> states;
	
	private boolean isClockWiseMovement;
	private boolean isUpMoreRadiusDownLessRadius;
	private boolean isCircleMotionAndIncreaseInRadius;
	private boolean isFourCircle;

	public GraphicsPanel() {
		isClockWiseMovement = false;
		isUpMoreRadiusDownLessRadius = false;
		isCircleMotionAndIncreaseInRadius = false;
		isFourCircle = false;
		
		figure = new Circle(BIGIN_POINT.getX(), BIGIN_POINT.getY(), RADIUS, RADIUS);
		actions = new ActionsCircle();
		actions.render();
		states = null;
		
		(new Thread(this)).start(); 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.green);
		g2.fill(figure);
		g2.draw(figure);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KEY_CLOCK_WISE_MOVEMENT) {
			isClockWiseMovement = true;
			indexMovement = 0;
		} else if (e.getKeyCode() == KEY_UP_MORE_RADIUS_DOWN_LESS_RADIUS) {
			isUpMoreRadiusDownLessRadius = true;
			indexMovement = 1;
		} else if (e.getKeyCode() == KEY_CIRCLE_MOTION_AND_INCREASE_IN_RADIUS) {
			isCircleMotionAndIncreaseInRadius = true;
			indexMovement = 2;
		} else if (e.getKeyCode() == KEY_FOUR_CIRCLE) {
			isFourCircle = true;
			indexMovement = 3;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}
	
	public void movie(final int delay) {
		states = actions.getAction();
		
		for (int i = 0; i < states.size(); i++) {
			figure.setFrame(
				states.get(i).getPoint().getX(), 
				states.get(i).getPoint().getY(), 
				states.get(i).getWidth(), 
				states.get(i).getHeight()
			);
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
			System.out.println("ClockWiseMovement: " + isClockWiseMovement);
			if (isClockWiseMovement) {
				actions.movie(indexMovement);
				movie(1);
				isClockWiseMovement = false;
			}
			System.out.println("UpMoreRadiusDownLessRadius: " + isUpMoreRadiusDownLessRadius);
			if (isUpMoreRadiusDownLessRadius) {
				actions.movie(indexMovement);
				movie(1);
				isUpMoreRadiusDownLessRadius = false;
			}
			System.out.println("CircleMotionAndIncreaseInRadius: " + isCircleMotionAndIncreaseInRadius);
			if (isCircleMotionAndIncreaseInRadius) {
				actions.movie(indexMovement);
				movie(1);
				isCircleMotionAndIncreaseInRadius = false;
			}
			System.out.println("isFourCircle: " + isFourCircle);
			if (isFourCircle) {
				actions.movie(indexMovement);
				movie(1);
				isFourCircle = false;
			}
		}
		
	}
}
