package problems.p021TOp030.p028;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import util.IProblem;

public class Problem28 implements IProblem {

	@Override
	public String getSolution() {
		return "669171001";
	}

	@Override
	public String solve() {

		final int matrixSize = 1001;
		final List<Integer> matrixList = new ArrayList<>();

		int secondCounter = 2;

		for (int i = 1; i <= matrixSize * matrixSize; i += secondCounter) {

			matrixList.add(i);

			if (matrixList.size() > 1 && (matrixList.size() - 1) % 4 == 0) {
				secondCounter += 2;
			}
		}

		return String.valueOf(matrixList.stream().collect(Collectors.summingInt(Integer::intValue)));
	}
}
