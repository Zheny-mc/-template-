
public interface SimpleFigure {
	
	StateFigure getState();
	
	void upRadius();
	void downRadius();
	void moveUpBoard();
	void moveDownBoard();
	void moveLeftBoard();
	void moveRigthBoard();
	void move(double alpha, double curDistance, double length);
}
