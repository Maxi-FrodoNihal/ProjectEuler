package problems.p041TOp050.p046;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import util.PrimProblem;

public class Problem46 extends PrimProblem {

	@Override
	public String getSolution() {
		return "5777";
	}

	@Override
	public String solve() {

		int oldOddCompo = 9;
		int nextOddCompo = -1;

		Pair<Integer, Integer> solution = null;

		do {

			nextOddCompo = getNextOddCompoNumber(oldOddCompo);
			solution = isBuildable(nextOddCompo);
			oldOddCompo = nextOddCompo;

		} while (solution != null);

		return String.valueOf(nextOddCompo);
	}

	private int getNextOddCompoNumber(int lastCompo) {

		Integer nextOddCompo = null;

		for (int i = lastCompo + 1; nextOddCompo == null; ++i) {

			if (i % 2 == 1 && this.isPrim(i) == false) {
				nextOddCompo = i;
			}
		}

		return nextOddCompo;
	}

	private Pair<Integer, Integer> isBuildable(int compoNum) {

		for (int i = 0; this.getOrCalculate(i) < compoNum; ++i) {

			int prim = this.getOrCalculate(i);

			for (int j = 1; j < compoNum; ++j) {

				int summe = prim + 2 * j * j;

				if (summe == compoNum) {
					return new ImmutablePair<Integer, Integer>(prim, j);
				} else if (summe > compoNum) {
					break;
				}
			}
		}

		return null;
	}
}
