package springhw.Model;

//шаболон стратегия: для простого движения
public class MovementCircle {
	private Moving moving;
	
	public void setMoving(Moving moving) {
		this.moving = moving;
	}
	
	public StateFigure executeMoving(Circle circle) {
		return moving.move(circle);
	}
}
