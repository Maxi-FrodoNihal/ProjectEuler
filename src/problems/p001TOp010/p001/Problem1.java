package problems.p001TOp010.p001;

import util.IProblem;

public class Problem1 implements IProblem {

	@Override
	public String solve() {

		int summe = 0;

		for (int i = 3; i < 1000; ++i) {

			if (i % 3 == 0 || i % 5 == 0) {

				summe += i;
			}
		}

		return String.valueOf(summe);
	}
}
