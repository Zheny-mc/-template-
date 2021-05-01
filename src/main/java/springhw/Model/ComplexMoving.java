package springhw.Model;

import java.util.Vector;

public abstract class ComplexMoving {
	protected Vector<Moving> movings = new Vector<Moving>();
	protected Vector<StateFigure> states = new Vector<StateFigure>();
	
	public Vector<StateFigure> executeMovings(Circle circle) {
		states.clear();
		
		for (Moving i: movings) {
			states.add(i.move(circle));
		}
		
		return states;
	}
	
}
