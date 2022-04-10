package problems.p041TOp050.p044;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import util.IProblem;

public class Problem44 implements IProblem {

	@Override
	public String solve() {

		int border = 100000;
		List<Pair<Integer, Integer>> resultList = new ArrayList<>();

		PentaList pentaList = new PentaList(border);

		for (int j = 0; j < border; ++j) {

			int pj = pentaList.get(j);

			for (int k = j + 1; k < border; ++k) {

				int pk = pentaList.get(k);

				int sumP = pj + pk;
				int subP = pk - pj;

				if (pentaList.containsMath(subP) && pentaList.containsMath(sumP)) {
					resultList.add(new ImmutablePair<Integer, Integer>(pj, pk));
				}
			}

			if (j % 100 == 0) {
				System.out.println(j + " / " + border + " ( " + resultList.size() + " ) ");
			}
		}

		resultList.stream().forEach(tmpE -> System.out.println(tmpE));

		return "";
	}
}
