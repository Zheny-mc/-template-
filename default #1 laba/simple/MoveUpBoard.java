package simple;

import ver_2.Circle;
import ver_2.Moving;
import ver_2.StateFigure;

public class MoveUpBoard implements Moving {
	
	@Override
	public StateFigure move(Circle circle) {
		double delta = 0.05;
		double x = circle.getX();
		double y = circle.getY() - delta;
		double width = circle.getWidth();
		double height = circle.getHeight();
		
		circle.setFrame(x, y, width, height);
		
		return circle.getState();
	}

}
