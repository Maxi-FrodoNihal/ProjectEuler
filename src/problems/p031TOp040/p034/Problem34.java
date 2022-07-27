package problems.p031TOp040.p034;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import util.IProblem;

public class Problem34 implements IProblem {

	@Override
	public String getSolution() {
		return "40730";
	}

	@Override
	public String solve() {

		List<Integer> targetList = new ArrayList<>();

		for (int i = 3; i < 100000; ++i) {

			if (i == getDigitFactorialSum(String.valueOf(i))) {
				targetList.add(i);
			}
		}

		return String.valueOf(targetList.stream().collect(Collectors.summingInt(Integer::intValue)));
	}

	private int getDigitFactorialSum(String targetNumber) {

		int facSum = 0;

		for (int i = 0; i <= targetNumber.length() - 1; ++i) {

			String digitString = targetNumber.substring(i, i + 1);
			int digit = Integer.parseInt(digitString);
			facSum += factorial(digit);
		}

		return facSum;
	}

	private int factorial(int n) {
		if (n <= 1)
			return 1;
		else
			return factorial(n - 1) * n;
	}
}
