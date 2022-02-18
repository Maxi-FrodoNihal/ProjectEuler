package problems.p011TOp020.p012;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import util.CList;
import util.ICListController;
import util.IProblem;

public class Problem12 implements ICListController<Integer, DivisorCallable>, IProblem {

	private final int pace = 100;
	private int callCounter = 0;
	private Integer foundValue = null;

	@Override
	public DivisorCallable getNext() {

		final int start = this.callCounter * this.pace + 1;
		final int ende = (this.callCounter + 1) * this.pace;

		this.callCounter++;

		final DivisorCallable dCallable = new DivisorCallable(start, ende);

		return dCallable;
	}

	@Override
	public void callbackValue(final Integer o) {

		if (o != null && o.intValue() > 0) {
			this.foundValue = o;
		}
	}

	@Override
	public boolean continueCalculation() {
		return this.foundValue == null;
	}

	@Override
	public String solve() {

		final int listSpace = Runtime.getRuntime().availableProcessors();

		final CList<Integer, DivisorCallable> cList = new CList<>(listSpace, Executors.newCachedThreadPool(), this);

		try {
			cList.run();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return String.valueOf(this.foundValue);
	}
}
