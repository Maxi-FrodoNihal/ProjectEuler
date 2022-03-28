package problems.p041TOp050.p043;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import util.CList;
import util.ICListController;
import util.IProblem;

public class Problem43 implements IProblem, ICListController<List<String>, PandigiCallable> {

	private List<String> bigList = new ArrayList<String>();
	private Iterator<PandigiCallable> workload;
	
	@Override
	public String solve() {
		
		List<PandigiCallable> workloadList = new ArrayList<PandigiCallable>();
		long from = 123456789;
		long to = 9876543214l;
		int parts = Runtime.getRuntime().availableProcessors();
		long partDistance = ((to-from)/parts);
		
		for(long i = from ; i < (to-partDistance) ; i+=partDistance) {
			workloadList.add(new PandigiCallable(i, i+partDistance));
			System.out.println(i+"      "+(i+partDistance));
		}
		
		workload = workloadList.iterator();
		
		CList<List<String>, PandigiCallable> cList = new CList<>(parts, Executors.newCachedThreadPool(), this);

		try {
			cList.run();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		return bigList.size()+"";
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
	
}
