package springhw.complex;

import springhw.Model.ComplexMoving;
import springhw.Model.Moving;
import springhw.simple.DownSize;
import springhw.simple.MoveAlpha;
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

import org.springframework.stereotype.Component;

@Component
public class Rosette extends ComplexMoving {
	
	private final int PI_2 = 360;
	private int num_half_circle = 9;
	private final double delta = 0.05d;
	
	public Rosette() {}
	
	@Override
	public void createMoving() {
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable< Vector<Moving> >> callables = Arrays.asList(
			callable(0, num_half_circle / 2),
			callable(num_half_circle / 2, num_half_circle)
		);

		List<Future<Vector<Moving>>> result = null;
		try {
			result = executor.invokeAll(callables);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Future<Vector<Moving>> i: result)
			try {
				System.out.println(i.get().size());
				movings.addAll(i.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
	}
	
	private Callable callable(int leftBoard, int rightBoard) {
		return () -> {
			Vector<Moving> movingsPart = new Vector<Moving>();
			for (int i = leftBoard; i < rightBoard; i++) {
				for (int alpha = i*PI_2/num_half_circle; alpha < i*PI_2/num_half_circle + PI_2/2; alpha+=15) {
					for (double j = 0; j < 1; j+=delta) {
						movingsPart.add(new MoveAlpha(alpha, j));
					}
				}
			}
	        return movingsPart;
	    };
	}
	
	
}
