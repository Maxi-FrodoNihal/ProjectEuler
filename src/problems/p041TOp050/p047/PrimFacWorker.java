package problems.p041TOp050.p047;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class PrimFacWorker implements Callable<List<Pair<Integer, Integer>>> {

	private int from;
	private int to;
	private Problem47 primClass;

	public PrimFacWorker(int from, int to, Problem47 primClass) {

		this.from = from;

		if (this.from > 10) {
			this.from = this.from - 3;
		}

		this.to = to;
		this.primClass = primClass;
	}

	@Override
	public List<Pair<Integer, Integer>> call() throws Exception {

		List<Pair<Integer, Integer>> listWithPrimFacts = new ArrayList<Pair<Integer, Integer>>();

		for (int i = from; i <= to; ++i) {
			Set<Integer> distinctPrimFacts = distinctPrimFacts(i);
			listWithPrimFacts.add(new ImmutablePair<Integer, Integer>(i, distinctPrimFacts.size()));
		}

		return listWithPrimFacts;
	}

	private Set<Integer> distinctPrimFacts(int number) {

		Set<Integer> retList = new HashSet<Integer>();
		primFactorsRec(number, retList, 0);
		return retList;
	}

	private void primFactorsRec(int number, Set<Integer> retList, int depth) {

		if (primClass.isPrim(number)) {
			retList.add(number);
		} else if (number > 0) {

			Integer primNum = primClass.getPrimNumbers().get(depth);

			if (number % primNum == 0) {
				retList.add(primNum);
				primFactorsRec((number / primNum), retList, 0);
			} else {
				primFactorsRec(number, retList, ++depth);
			}
		}
	}
}
