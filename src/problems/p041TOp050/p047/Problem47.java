package problems.p041TOp050.p047;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.tuple.Pair;

import util.CList;
import util.ICListController;
import util.PrimProblem;

public class Problem47 extends PrimProblem implements ICListController<List<Pair<Integer, Integer>>, PrimFacWorker> {

	private int distance = 300;
	private int counter = -1;
	private int start = 1;
	private boolean found = false;
	private int solution = 0;

	@Override
	public String getSolution() {
		return "134043";
	}

	@Override
	public String solve() {

		int parts = Runtime.getRuntime().availableProcessors();

		CList<List<Pair<Integer, Integer>>, PrimFacWorker> cList = new CList<>(parts, Executors.newCachedThreadPool(),
				this);

		try {
			cList.run();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return String.valueOf(solution);
	}

	@Override
	public synchronized boolean isPrim(int number) {
		return super.isPrim(number);
	}

	public List<Integer> getPrimNumbers() {
		return this.primNumbers;
	}

	@Override
	public PrimFacWorker getNext() {
		++counter;

		int from = start * counter * distance;

		if (from < 3) {
			from = 3;
		}
		++from;

		int to = start * (counter + 1) * distance;

		System.out.println(from + " / " + to);

		return new PrimFacWorker(from, to, this);
	}

	private void setFound(boolean b) {
		if (b && found == false) {
			found = b;
		}
	}

	@Override
	public void callbackValue(List<Pair<Integer, Integer>> o) {

		Integer localSolution = fourFourInARow(o);
		System.out.println(localSolution);
		setFound(localSolution != null);

		if (found && this.solution == 0) {
			this.solution = localSolution;
		}
	}

	@Override
	public boolean continueCalculation() {
		return found == false;
	}

	private Integer fourFourInARow(List<Pair<Integer, Integer>> newDataList) {

		Integer first = null;

		for (int i = 0; i < newDataList.size(); ++i) {

			try {

				if (newDataList.get(i).getRight() == 4 && newDataList.get(i + 1).getRight() == 4
						&& newDataList.get(i + 2).getRight() == 4 && newDataList.get(i + 3).getRight() == 4) {
					first = newDataList.get(i).getLeft();
					break;
				}

			} catch (IndexOutOfBoundsException e) {

			}
		}

		return first;
	}
}
