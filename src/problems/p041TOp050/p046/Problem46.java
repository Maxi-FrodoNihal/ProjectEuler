package problems.p041TOp050.p046;

import util.prime.PrimProblem;

public class Problem46 extends PrimProblem {

	@Override
	public String getSolution() {
		return "5777";
	}

	@Override
	public String solve() {

		int nextOddCompo = 9;

		while (isBuildable(nextOddCompo)) {
			nextOddCompo = getNextOddCompoNumber(nextOddCompo);
		}

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

	private boolean isBuildable(int compoNum) {

		for (int i = 0; this.getOrCalculate(i) < compoNum; ++i) {

			int prim = this.getOrCalculate(i);

			for (int j = 1; j < compoNum; ++j) {

				int summe = prim + 2 * j * j;

				if (summe == compoNum) {
					return true;
				} else if (summe > compoNum) {
					break;
				}
			}
		}

		return false;
	}
}
