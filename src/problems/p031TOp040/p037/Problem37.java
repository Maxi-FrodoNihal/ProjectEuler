package problems.p031TOp040.p037;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import util.PrimProblem;

public class Problem37 extends PrimProblem {

	@Override
	public String solve() {

		List<Integer> searchedPrims = new ArrayList<>();
		int borderNumber = 740000;

		isPrim(borderNumber);

		for (int tmpPrim : primNumbers) {
			if (isTruncatablePrim(tmpPrim) && tmpPrim > 10) {
				searchedPrims.add(tmpPrim);
			}
		}

//		searchedPrims.stream().forEach(tmpTPrim -> System.out.println(tmpTPrim));

		return String.valueOf(searchedPrims.stream().collect(Collectors.summingInt(Integer::intValue)));
	}

	private boolean isTruncatablePrim(int number) {

		if (recursiveLeftReduce(number) >= 0 && recursiveRightReduce(number) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	private int recursiveLeftReduce(int number) {

		if (Collections.binarySearch(primNumbers, number) >= 0) {

			if (number > 10) {
				return recursiveLeftReduce(reduceLeft(number));
			} else {
				return number;
			}
		}

		return -1;
	}

	private int recursiveRightReduce(int number) {

		if (Collections.binarySearch(primNumbers, number) >= 0) {

			if (number > 10) {
				return recursiveRightReduce(reduceRight(number));
			} else {
				return number;
			}
		}

		return -1;
	}

	private int reduceLeft(int number) {

		String numberString = String.valueOf(number);

		numberString = numberString.substring(1, numberString.length());

		return Integer.valueOf(numberString);
	}

	private int reduceRight(int number) {

		String numberString = String.valueOf(number);

		numberString = numberString.substring(0, numberString.length() - 1);

		return Integer.valueOf(numberString);
	}
}
