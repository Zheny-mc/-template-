package springhw.Model;

import java.util.ArrayList;
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
	
	public Vector<StateFigure> executeMovings(Circle circle) {
		states = new Vector<StateFigure>();
		//------------------------------------------------------------
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable< Vector<StateFigure> >> callables = 
				new ArrayList<Callable< Vector<StateFigure> >>();
		
		final int numbPart = 6;
		for (int i = 0; i < numbPart; ++i) {
			callables.add(
					callablePart(
							i * movings.size() / numbPart, 
							(i+1) * movings.size() / numbPart, 
							circle)
			);
		}
							
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
	
	private Callable callablePart(int leftBoard , int rightBoard, Circle circle) {
		return () -> {
			//---------���������� ������� ����� ��� ������� ���� ����� moving-------------
			Circle tmpCircle = new Circle(circle);
			
			for (int i = 0; i < leftBoard; ++i)
				movings.get(i).move(tmpCircle);
			
			//-------------------------------------
			Vector<StateFigure> statesPart = new Vector<StateFigure>();
			for (int i = leftBoard; i < rightBoard; ++i) {
				statesPart.add(movings.get(i).move(tmpCircle));
			}
	        return statesPart;
	    };
	}
}
