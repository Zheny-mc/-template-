package springhw.complex;

import springhw.Model.ComplexMoving;
import springhw.simple.MoveAlpha;

import org.springframework.stereotype.Component;

@Component
public class Rosette extends ComplexMoving {
	
	public Rosette() {
		final int PI_2 = 360;
		int num_half_circle = 9;
		
		for (int i = 0; i < num_half_circle; i++) {
			for (int alpha = i*360/num_half_circle; alpha < i*360/num_half_circle + PI_2/2; alpha+=15) {
				for (double j = 0; j < 1; j+=0.05) {
					movings.add(new MoveAlpha(alpha, j));
				}
			}
		}
		
	}
}
