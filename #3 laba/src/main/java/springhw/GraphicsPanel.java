package springhw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import javax.swing.JPanel;
import springhw.Model.Circle;
import springhw.Model.ComplexMoving;
import springhw.Model.ComplexMovingCircle;
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

@Component
@PropertySource("configPanel.properties")
public class GraphicsPanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	//-------------------------------------------------------
	//for change colors Circle
	@Autowired
	private ListColors colors;
	@Autowired
	private Circle circle;
	@Autowired
	private ComplexMovingCircle complexMovingCircle;
	
	private Map<Integer, InfoComplexMoving> buttons;

	@Value("#{'${moving.keys}'.split(',')}")
	private Integer[] keys;
	@Value("${moving.info}")
	private String[] info_keys;

	@Autowired
	private ListComplexMoving listComplexMoving;
	
	private boolean isClearPanel;
	//------------------------------------------------
	public GraphicsPanel() {}
	
	public void startThread() {
		(new Thread(this)).start();
	}
	
	public void createButtons() {
		List<ComplexMoving> complexMoving = listComplexMoving.getListComplexMoving();
		
		buttons = new HashMap<Integer, InfoComplexMoving>();
		for (int i = 0; i < complexMoving.size(); ++i) {
			buttons.put(
					keys[i], 
					new InfoComplexMoving(info_keys[i], complexMoving.get(i) ));
		}
		
	}
	
	//----------------control-------------------
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {		
		int eKey = e.getKeyCode();
		
		try {	
			buttons.get(eKey).setIsMake(true);
			System.out.println((char)eKey + "(" + eKey + ")" + ": " + buttons.get(eKey).getInfo());
		} catch(NullPointerException ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {}
	//------------------------------------------
	
	@Override
	public void paintComponent(Graphics g) {
		if (isClearPanel) {
			super.paintComponent(g);
			isClearPanel = false;
		}
			
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(colors.getNext());

		g2.fill(circle);
		g2.draw(circle);
	}

	public void movie(final int delay) {
		Vector<StateFigure> states = complexMovingCircle.executeComplexMoving(circle);
		
		for (StateFigure i: states) {
			circle.setFrame(i.getPoint().getX(), i.getPoint().getY(), i.getWidth(), i.getHeight());
			
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
			Iterator it = buttons.entrySet().iterator();
			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				InfoComplexMoving info = (InfoComplexMoving) entry.getValue();
				Boolean isMake = info.getIsMake();
				
				if (isMake) {
					complexMovingCircle.setComplexMoving(info.getComplexMoving());
					movie(1);
					info.setIsMake(false);
					isClearPanel = true;
				}
				
			}
		}
	}
	
	@Override
	public String toString() {
		return "GraphicsPanel [circle=" + circle + ", complexMovingCircle=" + complexMovingCircle
				+ ", buttons=" + buttons + "]";
	}

}