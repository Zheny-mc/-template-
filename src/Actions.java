import java.util.Vector;

public abstract class Actions {
	
	protected Vector<StateFigure> action;
	protected SimpleFigure figure;
	
	public void render() {
		figure = createFigure();
	}
	
	public abstract SimpleFigure createFigure();
	
	public abstract Vector<StateFigure> getAction();
	
	public abstract void clockWiseMovement();
	public abstract void upMoreRadiusDownLessRadius();
	public abstract void circleMotionAndIncreaseInRadius();
}
