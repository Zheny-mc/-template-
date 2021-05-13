package springhw.complex;

import springhw.Model.ComplexMoving;
import springhw.simple.MoveAlpha;

import org.springframework.stereotype.Component;

@Component
public class ClockWiseMovement extends ComplexMoving {
	
	public ClockWiseMovement() {
		final int PI_2 = 360;
	
		for (int alpha = 0; alpha < PI_2; alpha+=15) {
			for (double j = 0; j < 1; j+=0.05) {
				movings.add(new MoveAlpha(alpha, j));
			}
		}
	}
	
	@Override
	public void createMoving() {}
}
