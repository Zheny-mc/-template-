import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private Circle circle;
	
	public GraphicsPanel() {
		circle = new Circle(0, 0, 75, 75);
		
		(new Thread(this)).start(); 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.draw(circle);
	}
	
	public void run() {
		while (true) {
			try {
				circle.movie();
				super.repaint();
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
