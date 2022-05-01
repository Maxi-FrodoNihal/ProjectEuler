package problems.p041TOp050.p045;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import util.CList;
import util.ICListController;
import util.IProblem;

public class Problem45 implements IProblem, ICListController<Long, IsTPHCallable> {

	private long chunks = 100000;
	private long counter = 0;
	private List<Long> targetNumbers = new ArrayList<>();

	@Override
	public String getSolution() {
		return "1533776805";
	}

	@Override
	public String solve() {

		targetNumbers.clear();

		int parts = Runtime.getRuntime().availableProcessors();

		CList<Long, IsTPHCallable> cList = new CList<>(parts, Executors.newCachedThreadPool(), this);

		try {
			cList.run();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return String.valueOf(targetNumbers.get(targetNumbers.size() - 1));
	}

	@Override
	public IsTPHCallable getNext() {

		long from = chunks * counter;
		++counter;
		long to = chunks * counter;

		if (from == 0) {
			from = 2;
		}

		return new IsTPHCallable(from, to);
	}

	@Override
	public void callbackValue(Long o) {

		if (o != -1) {
			targetNumbers.add(o);
		}
	}

	@Override
	public boolean continueCalculation() {
		return targetNumbers.size() < 2;
	}
}
