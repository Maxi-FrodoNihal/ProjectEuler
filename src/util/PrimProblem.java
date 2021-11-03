package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public abstract class PrimProblem implements IProblem {

	protected List<Integer> primNumbers = new ArrayList<>();

	protected boolean isPrim(final int number) {

		if (CollectionUtils.isEmpty(this.primNumbers) || this.primNumbers.get(this.primNumbers.size() - 1) < number) {

			primNumbers = eratosthenes(number, primNumbers);
		}

		return Collections.binarySearch(this.primNumbers, number) >= 0;
	}

	private List<Integer> eratosthenes(final int border, List<Integer> primList) {

		int actualNumber = 6;

		if (CollectionUtils.isEmpty(primList)) {
			primList.add(2);
			primList.add(3);
			primList.add(5);
		} else {
			actualNumber = primList.get(primList.size() - 1);
		}

		while (primList.get(primList.size() - 1) < border) {

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

		return primList;
	}
}
