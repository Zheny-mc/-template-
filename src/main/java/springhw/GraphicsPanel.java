package springhw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import javax.swing.JPanel;
import springhw.Model.Circle;
import springhw.Model.ComplexMovingCircle;
import springhw.Model.InfoComplexMoving;
import springhw.Model.StateFigure;

public class GraphicsPanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	
	private Circle circle;
	private ComplexMovingCircle complexMovingCircle;
	private Vector<StateFigure> states;
	private Map<Integer, InfoComplexMoving> buttons;
	
	public GraphicsPanel() {}
	
	public void startThread() {
		(new Thread(this)).start();
	}
	
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public void setComplexMovingCircle(ComplexMovingCircle complexMovingCircle) {
		this.complexMovingCircle = complexMovingCircle;
	}

	public void setStates(Vector<StateFigure> states) {
		this.states = states;
	}
	
	public void setButtons(Map<Integer, InfoComplexMoving> buttons) {
		this.buttons = buttons;
	}	
	
	//************Панель управления*******************
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {		
		int eKey = e.getKeyCode();
		
		try {	
			buttons.get(eKey).setIsMake(true);
			System.out.println((char)eKey + ": " + buttons.get(eKey).getInfo());
		} catch(NullPointerException ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {}
	//*********************************************
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.green);
		
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