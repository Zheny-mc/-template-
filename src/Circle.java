 import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Circle extends Ellipse2D {

	//координаты начальной точки
	private Point point;
	private double width;
	private double height;
	
	private double x0;
	private double y0;
	private double width0;
	private double height0;
	
	private double curDistance;
	
	public double getCurDistance() {
		return curDistance;
	}

	public void setCurDistance(double curDistance) {
		this.curDistance = curDistance;
	}

	private final double delta = 0.005d;
	
	public Circle() {
		point = new Point();
		
		curDistance = 0.d;
		x0 = point.getX();
		y0 = point.getY();
		width0 = width;
		height0 = height;
	}
	
	public Circle(double x, double y, double width, double height) {
		point = new Point(x, y);
	
		curDistance = 0.d;
		this.width = width;
		this.height = height;
		
		x0 = point.getX();
		y0 = point.getY();
		width0 = width;
		height0 = height;
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		return null;
	}

	@Override
	public double getX() {
		return point.getX();
	}

	@Override
	public double getY() {
		return point.getY();
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void setFrame(double x, double y, double width, double height) {
		point.setLocation(x, y);
		this.width = width;
		this.height = height;
		
		x0 = point.getX();
		y0 = point.getY();
		width0 = width;
		height0 = height;
	}

	public Point getCentre() {
		return new Point(point.getX() +  width, point.getY() +  height);
	}
	
	public void upRadius() {
		width0 += delta;
		height0 += delta;
		
		x0 -= delta/2;
		y0 -= delta/2;
		
		this.setFrame(x0, y0, width0, height0);
	}
	
	public void downRadius() {
		width0 -= delta;
		height0 -= delta;
		
		x0 += delta/2;
		y0 += delta/2;
		
		this.setFrame(x0, y0, width0, height0);
	}
	
	public void moveUpBoard() {
		y0 -= delta;
		
		this.setFrame(x0, y0, width, height);
	}
	
	public void moveDownBoard() {
		y0 += delta;
		
		this.setFrame(x0, y0, width, height);
	}
	
	public void moveLeftBoard() {
		x0 -= delta;
		
		this.setFrame(x0, y0, width0, height0);
	}
	
	public void moveRigthBoard() {
		x0 += delta;
		
		this.setFrame(x0, y0, width0, height0);
	}
	
	public void move(double alpha, double length) {
		
		if (curDistance + delta <= length) {
			curDistance += delta;
			x0 += Math.cos(alpha) * curDistance;
			y0 += Math.sin(alpha) * curDistance;
			
			this.setFrame(x0, y0, width0, height0);
		}
	}
}

