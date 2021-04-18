package springhw;

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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import springhw.Model.Circle;
import springhw.Model.ComplexMovingCircle;
import springhw.Model.InfoComplexMoving;
import springhw.Model.StateFigure;
import springhw.complex.CircleMotionAndIncreaseInRadius;
import springhw.complex.ClockWiseMovement;
import springhw.complex.UpMoreRadiusDownLessRadius;

public class GraphicsPanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	
	private Circle circle;
	private ComplexMovingCircle complexMovingCircle;
	private Vector<StateFigure> states;

	private HashMap<Integer, InfoComplexMoving> buttons;
	
	public GraphicsPanel() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("graphicsPanelContext.xml");
		circle = ctx.getBean("circle", Circle.class);
		complexMovingCircle = ctx.getBean("complexMovingCircle", ComplexMovingCircle.class);
		ctx.close();
		
		createButtons();
		
		(new Thread(this)).start(); 
	}
	
	
	public void createButtons() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("graphicsPanelContext.xml");
		
		Vector<Character> keys = new Vector<Character>();
		/*
		 * spring
		keys.add( ctx.getBean("keyQ", Character.class) );
		keys.add( ctx.getBean("keyW", Character.class) );
		keys.add( ctx.getBean("keyE", Character.class) );
		*/
		
		keys.add('Q');
		keys.add('W');
		keys.add('E');
		
		Vector<InfoComplexMoving> obj = new Vector<InfoComplexMoving>();
		
		obj.add( ctx.getBean("info1", InfoComplexMoving.class) );
		obj.add( ctx.getBean("info2", InfoComplexMoving.class) );
		obj.add( ctx.getBean("info3", InfoComplexMoving.class) );
		
		ctx.close();
		
		final int n = obj.size();
		buttons = new HashMap<Integer, InfoComplexMoving>();
		
		for (int i = 0; i < n; i++) {
			buttons.put((int)keys.get(i), obj.get(i));
		}
	}
	
	//************Панель управления*******************
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		int eKey = e.getKeyCode();
		buttons.get(eKey).setIsMake(true);
		
		System.out.println((char)eKey + ": " + buttons.get(eKey).getInfo());
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