import java.util.Vector;

public class ActionsCircle extends Actions {
	private final Point BIGIN_POINT = new Point(250, 250);
	private final int RADIUS = 30;
	private final double TO_RADIAN = 0.0174533;
	
	public ActionsCircle() {
		super();
		action = new Vector<StateFigure>();		
	}

	@Override
	public SimpleFigure createFigure() {
		return new Circle(BIGIN_POINT.getX(), BIGIN_POINT.getY(), RADIUS, RADIUS);
	}
	
	public void clockWiseMovement() {
		final int PI_2 = 360;
		for (int alpha = 15; alpha <= PI_2; alpha+=15) {
			for (double j = 0; j < 1; j+=0.05) {
				action.add(figure.getState());
				figure.move((alpha*TO_RADIAN), j);
			}
		}
	}

	
	public void upMoreRadiusDownLessRadius() {
		for (int i = 0; i < 1; i++) {
			for (double j = 0.d; j <= 10; j+=0.05) {
				for (int k = 0; k < 10; k++) {
					
					action.add(figure.getState());
					figure.upSize();
					action.add(figure.getState());
					figure.moveUpBoard();
				}		
			}
			
			for (double j = 0.d; j <= 10; j+=0.05) {
				for (int k = 0; k < 10; k++) {
					action.add(figure.getState());
					figure.downSize();
					action.add(figure.getState());
					figure.moveDownBoard();
				}
			}
		
		}
		
	}

	public void circleMotionAndIncreaseInRadius() {
		final double DELTA = 0.005d;
		final int DELTA_ALPHA = 3;
		final double DISTANCE = 0.15;
		final int PI_2 = 360;
		
		for (int num = 0; num < 1; num++) {
			for (int alpha = 0; alpha < PI_2; alpha+=DELTA_ALPHA) {
				for (double i = 0; i <= DISTANCE; i+=DELTA) {
					action.add(figure.getState());
					figure.move((-alpha*0.0174533), i);
				}
			}
			for (int k = 0; k < 500; k++) {
				action.add(figure.getState());
				figure.upSize();
			}
	
		}
	}
	
	private void fourCircle() {
		clockWiseMovement();
		
		for (int i = 0; i < 3000; i++) {
			figure.moveLeftBoard();
		}
		
		clockWiseMovement();
		
		for (int i = 0; i < 3000; i++) {
			figure.moveUpBoard();
		}
		
		clockWiseMovement();
		
		for (int i = 0; i < 3000; i++) {
			figure.moveRigthBoard();
		}
		
		clockWiseMovement();
	}

	@Override
	public void movie(final int numAction) {
		action.clear();
		
		switch(numAction) {
		case 0:
			clockWiseMovement();
			break;
		
		case 1:
			upMoreRadiusDownLessRadius();
			break;
			
		case 2:
			circleMotionAndIncreaseInRadius();
			break;

		case 3:
			fourCircle();
			break;
		}
	}

}
