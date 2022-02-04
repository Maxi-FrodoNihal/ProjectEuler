package p038;

import util.IProblem;

public class Problem38 implements IProblem {

	@Override
	public String solve() {

		int border = 10000;

		int targetNumber = 0;

		for (int i = 2; i <= border; ++i) {
			for (int j = 2; j <= border; ++j) {

				int panDigiNumber = doPandigi(j, i);

				if (panDigiNumber == 0) {
					break;
				}

				if (panDigiNumber > targetNumber && contains1to9(panDigiNumber)) {
					targetNumber = panDigiNumber;
				}
			}
		}

		return String.valueOf(targetNumber);
	}

	public int doPandigi(int number, int border) {

		String panDigiString = "";

		for (int i = 1; i <= border && panDigiString.length() < 9; ++i) {
			panDigiString += number * i;
		}

		if (panDigiString.length() > 9) {
			return 0;
		} else {
			return Integer.valueOf(panDigiString);
		}
	}

	public boolean contains1to9(int number) {

		String numberString = String.valueOf(number);
		boolean containsAll = true;

		for (int i = 1; i <= 9 && containsAll; ++i) {
			containsAll &= numberString.contains(String.valueOf(i));
		}

		return containsAll;
	}
}
