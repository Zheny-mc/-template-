package ver_2;

import java.util.Vector;

public class ComplexMovingCircle {
	ComplexMoving complexMoving;
	
	public void setComplexMoving(ComplexMoving complexMoving) {
		this.complexMoving = complexMoving;
	}
	
	public Vector<StateFigure> executeComplexMoving(Circle circle) {
		return complexMoving.executeMovings(circle);
	}
}
