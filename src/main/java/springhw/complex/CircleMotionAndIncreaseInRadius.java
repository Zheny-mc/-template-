package springhw.complex;

import org.springframework.stereotype.Component;

import springhw.Model.ComplexMoving;
import springhw.simple.MoveAlpha;
import springhw.simple.UpSize;

@Component
public class CircleMotionAndIncreaseInRadius extends ComplexMoving {
	
	public CircleMotionAndIncreaseInRadius() {
		
		final int PI_2 = 360;
		
		for (int alpha = 0; alpha < PI_2; alpha+=15) {
			for (double j = 0; j < 1; j+=0.05) {
				movings.add(new MoveAlpha(alpha, j));
			}
		}
		
		for (int k = 0; k < 500; k++) {
			movings.add(new UpSize());
		}
		
	}
}
