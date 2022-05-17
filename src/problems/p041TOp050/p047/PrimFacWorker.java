package problems.p041TOp050.p047;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class PrimFacWorker implements Callable<List<Pair<Integer, Integer>>> {

	private int from;
	private int to;
	private Problem47 primClass;

	public PrimFacWorker(int from, int to, Problem47 primClass) {
		this.from = from;
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

		List<Integer> retList = new ArrayList<Integer>();
		primFactorsRec(number, retList, 0);
		return retList.stream().collect(Collectors.toSet());
	}

	private void primFactorsRec(int number, List<Integer> retList, int depth) {

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
