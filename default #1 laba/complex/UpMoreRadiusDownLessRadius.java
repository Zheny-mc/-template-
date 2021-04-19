package complex;

import simple.DownSize;
import simple.MoveDownBoard;
import simple.MoveUpBoard;
import simple.UpSize;
import ver_2.ComplexMoving;

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
