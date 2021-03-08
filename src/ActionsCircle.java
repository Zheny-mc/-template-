import java.util.Vector;

public class ActionsCircle extends Actions {
	
	public ActionsCircle() {
		super();
		action = new Vector<StateFigure>();		
	}

	@Override
	public SimpleFigure createFigure() {
		return new Circle(250, 250, 30, 30);
	}

	@Override
	public Vector<StateFigure> getAction() {
		return action;
	}
	
	@Override
	public void clockWiseMovement() {
		action.clear();
		for (int alpha = 0; alpha <= 360; alpha+=15) {
			for (double j = 0.d; j < 1; j+=0.05) {
				action.add(figure.getState());
				figure.move((alpha*0.0174533), j, 1);
			}
		}
	}

	@Override
	public void upMoreRadiusDownLessRadius() {
		action.clear();
		for (int i = 0; i < 3; i++) {
			for (double j = 0.d; j <= 10; j+=0.05) {
				for (int k = 0; k < 10; k++) {
					
					action.add(figure.getState());
					figure.upRadius();
					action.add(figure.getState());
					figure.moveUpBoard();
				}		
			}
			
			for (double j = 0.d; j <= 10; j+=0.05) {
				for (int k = 0; k < 10; k++) {
					action.add(figure.getState());
					figure.downRadius();
					action.add(figure.getState());
					figure.moveDownBoard();
				}
			}
		
		}
		
	}

	@Override
	public void circleMotionAndIncreaseInRadius() {
		action.clear();
		
		final double DELTA = 0.005d;
		final int DELTA_ALPHA = 3;
		final double DISTANCE = 0.15;
		
		for (int num = 0; num <= 3; num++) {
			for (int alpha = 0; alpha < 360; alpha+=DELTA_ALPHA) {
				for (double i = 0; i <= DISTANCE; i+=DELTA) {
					action.add(figure.getState());
					figure.move((-alpha*0.0174533), i, DISTANCE);
				}
			}
			for (int k = 0; k < 500; k++) {
				action.add(figure.getState());
				figure.upRadius();
			}
	
		}
	}

}
