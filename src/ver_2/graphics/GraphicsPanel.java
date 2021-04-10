package ver_2.graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JPanel;

import complex.CircleMotionAndIncreaseInRadius;
import complex.ClockWiseMovement;
import complex.UpMoreRadiusDownLessRadius;
import ver_2.Circle;
import ver_2.ComplexMoving;
import ver_2.ComplexMovingCircle;
import ver_2.InfoComplexMoving;
import ver_2.StateFigure;


public class GraphicsPanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	
	
	private Circle circle;
	private ComplexMovingCircle complexMovingCircle;
	private Vector<StateFigure> states;

	private HashMap<Integer, InfoComplexMoving> buttons;
	
	public GraphicsPanel() {
		circle = new Circle(250, 250, 30, 30);
		
		complexMovingCircle = new ComplexMovingCircle();
		
		createButtons();
		
		(new Thread(this)).start(); 
	}
	
	public void createButtons() {
		buttons = new HashMap<Integer, InfoComplexMoving>();
		
		InfoComplexMoving[] obj = {
				new InfoComplexMoving(), 
				new InfoComplexMoving(), 
				new InfoComplexMoving()
		};
		
		obj[0].setInfo("CircleMotionAndIncreaseInRadius");
		obj[0].setComplexMoving(new CircleMotionAndIncreaseInRadius());
		buttons.put((int)'Q', obj[0]);
		
		obj[1].setInfo("ClockWiseMovement");
		obj[1].setComplexMoving(new ClockWiseMovement());
		buttons.put((int)'W', obj[1]);
		
		obj[2].setInfo("UpMoreRadiusDownLessRadius");
		obj[2].setComplexMoving(new UpMoreRadiusDownLessRadius());
		buttons.put((int)'E', obj[2]);
	}
	
	//************Панель управления*******************
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		int eKey = e.getKeyCode();
		buttons.get(eKey).setIsMake(true);
		System.out.println( (char)eKey );
	}

	@Override
	public void keyPressed(KeyEvent e) {}
	//*********************************************
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.red);
		g2.fill(circle);
		g2.draw(circle);
	}

	public void movie(final int delay) {
		states = complexMovingCircle.executeComplexMoving(circle);
		
		for (StateFigure i: states) {
			circle.setFrame(i.getPoint().getX(), i.getPoint().getY(), i.getWidth(), i.getHeight());
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
			
			Iterator it = buttons.entrySet().iterator();
			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				InfoComplexMoving info = (InfoComplexMoving) entry.getValue();
				Boolean isMake = info.getIsMake();
				
				if (isMake) {
					complexMovingCircle.setComplexMoving(info.getComplexMoving());
					movie(1);
					info.setIsMake(false);
				}
				
			}
			
		}
	}
}
