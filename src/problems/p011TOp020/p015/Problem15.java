package problems.p011TOp020.p015;

import java.math.BigInteger;

import util.IProblem;

public class Problem15 implements IProblem {

	@Override
	public String getSolution() {
		return "137846528820";
	}

	@Override
	public String solve() {

		// Mittlerer Binomialkoeffizient
		long border = 20;

		BigInteger solution = fac(new BigInteger(String.valueOf(2l * border)))
				.divide(fac(new BigInteger(String.valueOf(border))).pow(2));

		return solution.toString();
	}

	private BigInteger fac(final BigInteger border) {
		if (border.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		} else {
			return border.multiply(this.fac(border.subtract(BigInteger.ONE)));
		}
	}
}
