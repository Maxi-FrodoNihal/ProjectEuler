package problems.p041TOp050.p043;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.collections4.ListUtils;

import util.CList;
import util.ICListController;
import util.IProblem;

public class Problem43 implements IProblem, ICListController<List<String>, PandigiCallable> {

	private List<String> bigList = new ArrayList<String>();
	private Iterator<PandigiCallable> workload;

	@Override
	public String getSolution() {
		return "16695334890";
	}

	@Override
	public String solve() {

		int parts = Runtime.getRuntime().availableProcessors();

		this.workload = generateWorkLoad(parts).iterator();

		CList<List<String>, PandigiCallable> cList = new CList<>(parts, Executors.newCachedThreadPool(), this);

		try {
			cList.run();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return String.valueOf(bigList.stream().mapToLong(tmpLong -> Long.parseLong(tmpLong)).sum());
	}

	private List<PandigiCallable> generateWorkLoad(int chunks) {

		List<String> pool = generatePool();

		List<List<String>> workloadData = ListUtils.partition(pool, pool.size() / chunks);
		List<PandigiCallable> localWorkLoad = new ArrayList<PandigiCallable>();

		workloadData.stream().forEach(tmpWList -> localWorkLoad.add(new PandigiCallable(tmpWList)));

		return localWorkLoad;
	}

	private List<String> generatePool() {

		List<String> pList = new ArrayList<String>();

		for (int i = 0; i < 10; ++i) {
			pList.add(String.valueOf(i));
		}

		List<List<String>> permute = new Permutor().permute(pList);
		List<String> pool = new ArrayList<>();

		for (List<String> element : permute) {
			String combinedElement = "";
			for (String letter : element) {
				combinedElement += letter;
			}
			pool.add(combinedElement);
		}

		return pool;
	}

	@Override
	public PandigiCallable getNext() {
		return workload.next();
	}

	@Override
	public void callbackValue(List<String> o) {
		bigList.addAll(o);

	}

	@Override
	public boolean continueCalculation() {
		return workload.hasNext();
	}

	public class Permutor {

		public <T> List<List<T>> permute(List<T> source) {

			List<List<T>> perList = new ArrayList<List<T>>();
			permute(source, 0, perList);
			return perList;
		}

		private <T> void permute(List<T> arr, int k, List<List<T>> perList) {
			for (int i = k; i < arr.size(); i++) {
				java.util.Collections.swap(arr, i, k);
				permute(arr, k + 1, perList);
				java.util.Collections.swap(arr, k, i);
			}
			if (k == arr.size() - 1) {
				perList.add(new ArrayList<T>(arr));
			}
		}
	}
}
