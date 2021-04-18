package springhw.complex;

import springhw.Model.ComplexMoving;
import springhw.simple.DownSize;
import springhw.simple.MoveDownBoard;
import springhw.simple.MoveUpBoard;
import springhw.simple.UpSize;

public class UpMoreRadiusDownLessRadius extends ComplexMoving {

	public UpMoreRadiusDownLessRadius() {
		double delta = 0.05d;
		
		for (double j = 0.d; j <= 10; j+=delta) {
			for (int k = 0; k < 10; k++) {
				movings.add(new UpSize());
				movings.add(new MoveUpBoard());
			}		
		}
		
		for (double j = 0.d; j <= 10; j+=delta) {
			for (int k = 0; k < 10; k++) {
				movings.add(new DownSize());
				movings.add(new MoveDownBoard());
			}
		}
	
	}
	
}
