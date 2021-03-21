import java.util.Vector;

public abstract class Actions {
	
	protected SimpleFigure figure;
	protected Vector<StateFigure> action;
	
	public void render() {
		figure = createFigure();
	}
	
	public Vector<StateFigure> getAction() {
		return action;
	}
	
	public abstract SimpleFigure createFigure();
	public abstract void movie(final int numAction);
}
