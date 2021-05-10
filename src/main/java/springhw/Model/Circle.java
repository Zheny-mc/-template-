package springhw.Model;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("configPanel.properties")
public class Circle extends Ellipse2D {

	@Autowired
	private Point point;
	@Value("${circle.width}")
	private double width;
	@Value("${circle.height}")
	private double height;
	
	public Circle() {
		point = new Point();
	}
	
	public Circle(double x, double y, double width, double height) {	
		point = new Point(x, y);
		this.width = width;
		this.height = height;
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
		return new StateFigure(new Point(getX(), getY()), width, height);
	}
	
	@Override
	public void setFrame(double x, double y, double width, double height) {
		point.setLocation(x, y);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Circle [point=" + point + ", width=" + width + ", height=" + height + "]";
	}
}

