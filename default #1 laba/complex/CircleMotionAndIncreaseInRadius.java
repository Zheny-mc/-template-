package complex;

import simple.MoveAlpha;
import simple.UpSize;
import ver_2.ComplexMoving;

public class CircleMotionAndIncreaseInRadius extends ComplexMoving {
	
	public CircleMotionAndIncreaseInRadius() {
		int PI_2 = 360;
		
		for (int alpha = -15; alpha < PI_2; alpha+=15) {
			for (double j = 0; j < 1; j+=0.05) {
				movings.add(new MoveAlpha(alpha, j));
			}
		}
		
		for (int k = 0; k < 500; k++) {
			movings.add(new UpSize());
		}
	
	}
}
