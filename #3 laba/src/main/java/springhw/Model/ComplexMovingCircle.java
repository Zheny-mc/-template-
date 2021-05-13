package springhw.Model;

import java.util.Vector;

import org.springframework.stereotype.Component;

@Component
public class ComplexMovingCircle {
	ComplexMoving complexMoving;
	
	public void setComplexMoving(ComplexMoving complexMoving) {
		this.complexMoving = complexMoving;
	}
	
	public Vector<StateFigure> executeComplexMoving(Circle circle) {
		return complexMoving.executeMovings(circle);
	}
}
