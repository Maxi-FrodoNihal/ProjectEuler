package problems.p041TOp050.p047;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.tuple.Pair;

import util.CList;
import util.ICListController;
import util.prime.PrimProblem;

public class Problem47 extends PrimProblem implements ICListController<List<Pair<Integer, Integer>>, PrimFacWorker> {

	private int distance = 400;
	private int counter = -1;
	private int start = 1;
	private Integer solution = null;

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
	public boolean isPrim(int number) {
		// Falls in diesem Problem mal etwas schief gehen sollte. Schreib in dieser
		// Methode synchronized rein.
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

		int to = start * (counter + 1) * distance;

		return new PrimFacWorker(from, to, this);
	}

	@Override
	public void callbackValue(List<Pair<Integer, Integer>> o) {

		Integer localSolution = getFirstFourInARow(o);

		if (localSolution != null && solution == null) {
			this.solution = localSolution;
		}
	}

	@Override
	public boolean continueCalculation() {
		return solution == null;
	}

	private Integer getFirstFourInARow(List<Pair<Integer, Integer>> newDataList) {

		Integer first = null;

		for (int i = 0; i < newDataList.size() && first == null; ++i) {

			try {

				boolean fourInARow = true;

				for (int j = 0; j < 4 && fourInARow; ++j) {
					fourInARow &= newDataList.get(i + j).getRight() == 4;
				}

				if (fourInARow) {
					first = newDataList.get(i).getLeft();
				}

			} catch (IndexOutOfBoundsException e) {

			}
		}

		return first;
	}
}
