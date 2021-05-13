package simple;

import ver_2.Circle;
import ver_2.Moving;
import ver_2.StateFigure;

public class MoveAlpha implements Moving {

	private double alpha;
	private double distance;

	public MoveAlpha(double alpha, double distance) {
		this.alpha = alpha;
		this.distance = distance;
	}

	@Override
	public StateFigure move(Circle circle) {
		final double TO_RADIAN = 0.0174533;
		
		double x0 = Math.cos(alpha * TO_RADIAN) * distance;
		double y0 = Math.sin(alpha * TO_RADIAN) * distance;
		
		double x = circle.getX() + x0;
		double y = circle.getY() + y0;
		double width = circle.getWidth();
		double height = circle.getHeight();
		
		circle.setFrame(x, y, width, height);
		
		return circle.getState();
	}
	
}
