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
	
	private final double delta = 0.05d;
	public UpMoreRadiusDownLessRadius() {}
	
	@Override
	public void createMoving() {
		
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable< Vector<Moving> >> callables = Arrays.asList(
			callableLeft(),
			callableRight()
		);

		List<Future<Vector<Moving>>> result = null;
		try {
			result = executor.invokeAll(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Future<Vector<Moving>> i: result)
			try {
				System.out.println(i.get().size());
				movings.addAll(i.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	private Callable callableLeft() {
		return () -> {
			Vector<Moving> movingsLeft = new Vector<Moving>();
			for (double j = 0.d; j <= 10; j+=delta) {
				for (int k = 0; k < 10; k++) {
					movingsLeft.add(new UpSize());
					movingsLeft.add(new MoveUpBoard());
				}		
			}
	        return movingsLeft;
	    };
	}
	
	private Callable callableRight() {
		return () -> {
			Vector<Moving> movingsRight = new Vector<Moving>();
			for (double j = 0.d; j <= 10; j+=delta) {
				for (int k = 0; k < 10; k++) {
					movingsRight.add(new DownSize());
					movingsRight.add(new MoveDownBoard());
				}
			}
	        return movingsRight;
	    };
	}

}
