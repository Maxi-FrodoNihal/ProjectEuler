package problems.p001TOp010.p007;

import java.util.ArrayList;
import java.util.List;

import util.IProblem;

public class Problem7 implements IProblem {

	@Override
	public String getSolution() {
		return "104743";
	}

	@Override
	public String solve() {
		return String.valueOf(this.eratosthenes(10001));
	}

	private int eratosthenes(final int indexOfPrim) {

		final List<Integer> primList = new ArrayList<>();
		primList.add(2);
		primList.add(3);
		primList.add(5);

		if (indexOfPrim > 3) {

			int actualNumber = 6;

			while (primList.size() < indexOfPrim) {

				int counter = 0;

				for (final Integer primNumber : primList) {

					if (actualNumber % primNumber != 0) {
						counter++;
					} else {
						break;
					}
				}

				if (counter == primList.size()) {
					primList.add(actualNumber);
				}

				actualNumber++;
			}
		}

		return primList.get(indexOfPrim - 1);
	}
}
