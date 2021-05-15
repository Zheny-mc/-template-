package springhw.complex;

import org.springframework.stereotype.Component;

import springhw.Model.ComplexMoving;
import springhw.simple.MoveAlpha;

@Component
public class PathThroughTheMaze extends ComplexMoving{
	
	public PathThroughTheMaze() {
		
		final int PI_2 = 360;
		
		for (int alpha = 0, k = 0; alpha < PI_2*2; alpha+=15, k++) {
			for (double j = 0; j < 0.3; j+=0.05) {
				movings.add(new MoveAlpha(alpha+k, j*k));
			}
		}

	}
}
