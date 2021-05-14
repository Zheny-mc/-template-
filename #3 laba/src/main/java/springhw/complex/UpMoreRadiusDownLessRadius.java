package springhw.complex;

import springhw.Model.ComplexMoving;
import springhw.Model.Moving;
import springhw.simple.DownSize;
import springhw.simple.MoveDownBoard;
import springhw.simple.MoveUpBoard;
import springhw.simple.UpSize;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
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
