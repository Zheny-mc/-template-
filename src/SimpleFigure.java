
public interface SimpleFigure {
	
	StateFigure getState();
	
	void upSize();
	void downSize();
	void moveUpBoard();
	void moveDownBoard();
	void moveLeftBoard();
	void moveRigthBoard();
	void move(double alpha, double Distance);
}
