package springhw.Model;

import java.awt.geom.Point2D;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("configPanel.properties")
public class Point extends Point2D{
	@Value("${circle.x}")
	private double x;
	@Value("${circle.y}")
	private double y;
	
	public Point() {}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
