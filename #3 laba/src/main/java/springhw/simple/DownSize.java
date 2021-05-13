package springhw.simple;

import springhw.Model.Circle;
import springhw.Model.Moving;
import springhw.Model.StateFigure;


public class DownSize implements Moving {

	@Override
	public StateFigure move(Circle circle) {
		double delta = 0.05;
		double x = circle.getX() + delta/2;
		double y = circle.getY() + delta/2;
		double width = circle.getWidth() - delta;
		double height = circle.getHeight() - delta;
		
		circle.setFrame(x, y, width, height);
		
		return circle.getState();
	}

}
