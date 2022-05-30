package problems.p041TOp050.p048;

import java.math.BigInteger;

import util.IProblem;

public class Problem48 implements IProblem {

	@Override
	public String getSolution() {
		return "9110846700";
	}

	@Override
	public String solve() {

		BigInteger sum = BigInteger.ZERO;

		for (int i = 1; i <= 1000; ++i) {

			BigInteger bigI = new BigInteger(String.valueOf(i));
			bigI = bigI.pow(i);
			sum = sum.add(bigI);
		}

		String bigSolution = sum.toString();

		return bigSolution.substring(bigSolution.length() - 10);
	}
}
