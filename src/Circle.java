 import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Circle extends Ellipse2D{

	//координаты начальной точки
	private Point point;
	private double width;
	private double height;
	
	private double x0;
	private double y0;
	
	public Circle() {
		point = new Point();
		
		x0 = point.getX();
		y0 = point.getY();
	}
	
	public Circle(double x, double y, double width, double height) {
		point = new Point(x, y);
		this.width = width;
		this.height = height;
		
		x0 = point.getX();
		y0 = point.getY();
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
	}
	
	public void movie() {
		x0 += 0.9;
		y0 += 0.09;
		
		this.setFrame(x0, y0, width, height);
	}
}
