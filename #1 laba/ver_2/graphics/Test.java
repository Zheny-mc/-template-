package ver_2.graphics;

import complex.ClockWiseMovement;
import ver_2.Circle;
import ver_2.ComplexMovingCircle;

public class Test {

	public static void main(String[] args) {
		
		Circle circle = new Circle(250, 250, 30, 30);
		ComplexMovingCircle v = new ComplexMovingCircle();
		
		for (int i = 0; i < 3; i++) {
			v.setComplexMoving(new ClockWiseMovement());
			System.out.println(v.executeComplexMoving(circle));
		}
		
		
	}

}
