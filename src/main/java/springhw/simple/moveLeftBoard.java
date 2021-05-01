package springhw.simple;

import springhw.Model.Circle;
import springhw.Model.Moving;
import springhw.Model.StateFigure;

public class moveLeftBoard implements Moving {

	@Override
	public StateFigure move(Circle circle) {
		double delta = 0.05;
		double x = circle.getX() - delta;
		double y = circle.getY();
		double width = circle.getWidth();
		double height = circle.getHeight();
		
		circle.setFrame(x, y, width, height);
		
		return circle.getState();
	}

}
