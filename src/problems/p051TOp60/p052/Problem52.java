package problems.p051TOp60.p052;

import util.IProblem;

public class Problem52 implements IProblem {

	@Override
	public String getSolution() {
		return "142857";
	}

	@Override
	public String solve() {

		String solution = "";
		int[] multiplyers = { 2, 3, 4, 5, 6 };

		for (int i = 1; i < 1000000; ++i) {

			boolean allOk = true;
			DNumber dNumZentral = new DNumber(i);

			for (int multi : multiplyers) {

				DNumber multiNum = new DNumber(i * multi);

				if (dNumZentral.getDigits().containsAll(multiNum.getDigits()) == false) {
					allOk = false;
					break;
				}
			}

			if (allOk) {
				solution = String.valueOf(i);
				break;
			}
		}

		return solution;
	}
}
