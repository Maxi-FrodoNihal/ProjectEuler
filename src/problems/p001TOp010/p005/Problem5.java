package problems.p001TOp010.p005;

import util.IProblem;

public class Problem5 implements IProblem {

	@Override
	public String getSolution() {
		return "232792560";
	}

	@Override
	public String solve() {

		int searchNumber = 0;
		boolean all20ModulosAreZero = false;

		for (int i = 20; all20ModulosAreZero == false; i += 20) {

			all20ModulosAreZero = true;

			searchNumber = i;
			for (int j = 2; j <= 20; ++j) {

				if (i % j != 0) {
					all20ModulosAreZero = false;
					break;
				}
			}
		}

		return String.valueOf(searchNumber);
	}
}
