package problems.p051TOp60.p053;

import java.math.BigInteger;

import util.IProblem;

public class Problem53 implements IProblem {

	@Override
	public String getSolution() {
		return "4075";
	}

	@Override
	public String solve() {

		BigInteger oneMillion = new BigInteger("1000000");
		int counter = 0;

		for (int i = 23; i <= 100; ++i) {
			for (int j = 1; j <= i; ++j) {
				if (xOverY(i, j).compareTo(oneMillion) == 1) {
					++counter;
				}
			}
		}

		return String.valueOf(counter);
	}

	private BigInteger xOverY(int x, int y) {

		BigInteger bigX = new BigInteger(String.valueOf(x));
		BigInteger bigY = new BigInteger(String.valueOf(y));

		return factIt(bigX).divide(factIt(bigY).multiply(factIt(bigX.subtract(bigY))));
	}

	private BigInteger factIt(final BigInteger border) {

		BigInteger sol = BigInteger.ONE;

		for (int i = 1; i <= border.intValue(); ++i) {
			sol = sol.multiply(new BigInteger(String.valueOf(i)));
		}

		return sol;
	}
}
