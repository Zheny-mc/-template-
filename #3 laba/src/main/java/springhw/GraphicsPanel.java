package springhw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Vector;
import javax.swing.JPanel;
import springhw.Model.Circle;
import springhw.Model.ComplexMoving;
import springhw.Model.ComplexMovingCircle;
import springhw.Model.DataGraphicsPanel;
import springhw.Model.InfoComplexMoving;
import springhw.Model.ListColors;
import springhw.Model.ListComplexMoving;
import springhw.Model.StateFigure;
import springhw.complex.CircleMotionAndIncreaseInRadius;
import springhw.complex.ClockWiseMovement;
import springhw.complex.Rosette;
import springhw.complex.UpMoreRadiusDownLessRadius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import akka.actor.ActorSystem;

@Component
public class GraphicsPanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;

	@Autowired
	private DataGraphicsPanel data;
	
	public GraphicsPanel() {}
	
	public void startThread() {
		(new Thread(this)).start();
	}
	
	public DataGraphicsPanel getData() {
		return data;
	}

	//----------------control-------------------
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {		
		int eKey = e.getKeyCode();
		
		try {	
			data.getButtons().get(eKey).setIsMake(true);
			System.out.println((char)eKey + "(" + eKey + ")" + ": " + data.getButtons().get(eKey).getInfo());
		} catch(NullPointerException ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {}
	//------------------------------------------
	
	@Override
	public void paintComponent(Graphics g) {
		if (data.getClearPanel()) {
			super.paintComponent(g);
			data.setClearPanel(false);
		}
			
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(data.getColors().getNext());

		g2.fill(data.getCircle());
		g2.draw(data.getCircle());
	}

	public void movie(final int delay) {
		Vector<StateFigure> states = data.getComplexMovingCircle().executeComplexMoving(data.getCircle());
		
		//------повтор для 100 фигур----------
		for (int i = 0; i < 1000; i++) {
			Circle tmpCircle = new Circle(data.getCircle());
			states = data.getComplexMovingCircle().executeComplexMoving(tmpCircle);
			System.out.println(i + ") circle");
		}
		//------------------------------------
		
		
		for (StateFigure i: states) {
			data.getCircle().setFrame(i.getPoint().getX(), i.getPoint().getY(), i.getWidth(), i.getHeight());
			
			super.repaint();
			try {		
				Thread.sleep(delay);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		
		while (true) {	
			Iterator it = data.getButtons().entrySet().iterator();
			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				InfoComplexMoving info = (InfoComplexMoving) entry.getValue();
				Boolean isMake = info.getIsMake();
				
				if (isMake) {
					data.getComplexMovingCircle().setComplexMoving(info.getComplexMoving());
					movie(1);
					info.setIsMake(false);
					data.setClearPanel(true);
				}
				
			}
		}
	}
	

}