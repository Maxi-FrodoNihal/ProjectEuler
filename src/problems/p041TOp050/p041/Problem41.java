package problems.p041TOp050.p041;

import util.PrimProblem;

public class Problem41 extends PrimProblem {

	@Override
	public String getSolution() {
		return "7652413";
	}

	@Override
	public String solve() {

		this.isPrim(10000000);

		int biggestPrim = 0;

		for (int tmpPrim : this.primNumbers) {
			if (tmpPrim > 10 && contains1toX(tmpPrim) && biggestPrim < tmpPrim) {
				biggestPrim = tmpPrim;
			}
		}

		return String.valueOf(biggestPrim);
	}

	private boolean contains1toX(int number) {

		String numberString = String.valueOf(number);
		boolean containsAll = true;

		for (int i = 1; i <= numberString.length() && containsAll; ++i) {
			containsAll &= numberString.contains(String.valueOf(i));
		}

		return containsAll;
	}
}
