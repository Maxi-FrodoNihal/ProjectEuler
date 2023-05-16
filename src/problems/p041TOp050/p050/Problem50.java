package problems.p041TOp050.p050;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import util.CList;
import util.ICListController;
import util.prime.PrimProblem;

public class Problem50 extends PrimProblem implements ICListController<Pair<Integer, List<Integer>>, PrimSumCallable> {

	private Iterator<List<Integer>> nextWork = null;
	private MutablePair<Integer, List<Integer>> solutionPair = new MutablePair<>();

	@Override
	public String getSolution() {
		return "997651";
	}

	@Override
	public String solve() {

		int partLoad = 100;
		int primBorder = 1000000;

		this.isPrim(primBorder);

		List<List<Integer>> workList = ListUtils.partition(this.primNumbers, partLoad);
		nextWork = workList.iterator();

		int parts = Runtime.getRuntime().availableProcessors();

		CList<Pair<Integer, List<Integer>>, PrimSumCallable> cList = new CList<>(parts, Executors.newCachedThreadPool(),
				this);

		try {
			cList.run();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return String.valueOf(solutionPair.getLeft());
	}

	@Override
	public PrimSumCallable getNext() {
		return new PrimSumCallable(nextWork.next(), this.primNumbers);
	}

	@Override
	public void callbackValue(Pair<Integer, List<Integer>> o) {

		List<Integer> newList = o.getRight();
		List<Integer> oldList = solutionPair.right;

		if (oldList == null && newList != null
				|| oldList != null && newList != null && oldList.size() < newList.size()) {
			solutionPair.setLeft(o.getLeft());
			solutionPair.setRight(newList);
		}
	}

	@Override
	public boolean continueCalculation() {
		return nextWork.hasNext();
	}
}
