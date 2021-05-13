package springhw.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import springhw.simple.DownSize;
import springhw.simple.MoveDownBoard;
import springhw.simple.MoveUpBoard;
import springhw.simple.UpSize;

public abstract class ComplexMoving {
	protected Vector<Moving> movings = new Vector<Moving>();
	protected Vector<StateFigure> states;
	
	public abstract void createMoving();
	
	public Vector<StateFigure> executeMovings(Circle circle) {
		states = new Vector<StateFigure>();
		//******************************************************
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable< Vector<StateFigure> >> callables = Arrays.asList(
			callablePart(0, movings.size(), circle)
			//callablePart(movings.size() / 3, 2*movings.size() / 3, circle),
			//callablePart(2 * movings.size() / 3, movings.size(), circle)
		);

		List<Future<Vector<StateFigure>>> result = null;
		try {
			result = executor.invokeAll(callables);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Future<Vector<StateFigure>> i: result) {
			try {
				System.out.println(i.get().size());
				states.addAll(i.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		return states;
	}
	
	private Callable callablePart(int leftBoard, int rightBoard, Circle circle) {
		return () -> {
			Vector<StateFigure> statesPart = new Vector<StateFigure>();
			for (int i = leftBoard; i < rightBoard; ++i) {
				statesPart.add(movings.get(i).move(circle));
			}
	        return statesPart;
	    };
	}
	
}
