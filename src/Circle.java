import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Circle extends Ellipse2D implements SimpleFigure{
	String type = "Cirlcle";
	private Point point;
	private double width;
	private double height;
	
	private Point point0;
	private double width0;
	private double height0;

	private final double delta = 0.05d;
	
	public Circle() {
		point = new Point();
		
		point0 = point;
		width0 = width;
		height0 = height;
	}
	
	public Circle(double x, double y, double width, double height) {
		point = new Point(x, y);
		this.width = width;
		this.height = height;
		
		point0 = point;
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

	public StateFigure getState() {
		return new StateFigure(type, new Point(point.getX(), point.getY()), width, height);
	}
	
	@Override
	public void setFrame(double x, double y, double width, double height) {
		point.setLocation(x, y);
		this.width = width;
		this.height = height;
		
		point0 = point;
		width0 = width;
		height0 = height;
	}
	
	public void upRadius() {
		width0 += delta;
		height0 += delta;
		
		point0.setLocation(point0.getX()-delta/2, point0.getY()-delta/2);
		
		this.setFrame(point0.getX(), point0.getY(), width0, height0);
	}
	
	public void downRadius() {
		width0 -= delta;
		height0 -= delta;
		
		point0.setLocation(point0.getX()+delta/2, point0.getY()+delta/2);
		
		this.setFrame(point0.getX(), point0.getY(), width0, height0);
	}
	
	public void moveUpBoard() {
		point0.setLocation(point0.getX(), point0.getY()-delta);
		this.setFrame(point0.getX(), point0.getY(), width, height);
	}
	
	public void moveDownBoard() {
		point0.setLocation(point0.getX(), point0.getY()+delta);
		this.setFrame(point0.getX(), point0.getY(), width, height);
	}
	
	public void moveLeftBoard() {
		point0.setLocation(point0.getX()-delta, point0.getY());
		this.setFrame(point0.getX(), point0.getY(), width, height);
	}
	
	public void moveRigthBoard() {
		point0.setLocation(point0.getX()+delta, point0.getY());
		this.setFrame(point0.getX(), point0.getY(), width, height);
	}
	
	public void move(double alpha, double curDistance, double length) {
		
		if (curDistance + delta <= length) {
			curDistance += delta;
			
			double x0 = Math.cos(alpha) * curDistance;
			double y0 = Math.sin(alpha) * curDistance;
			
			point0.setLocation(point0.getX()+x0, point0.getY()+y0);
			
			this.setFrame(point0.getX(), point0.getY(), width, height);
		}
	}
}

