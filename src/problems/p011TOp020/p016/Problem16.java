package problems.p011TOp020.p016;

import java.math.BigDecimal;

import util.IProblem;

public class Problem16 implements IProblem {

	@Override
	public String getSolution() {
		return "1366";
	}

	@Override
	public String solve() {

		BigDecimal two = new BigDecimal(2);
		BigDecimal twoPowThousand = two.pow(1000);

		return String.valueOf(quersumme(twoPowThousand.toPlainString()));
	}

	private int quersumme(final String number) {

		int sum = 0;

		for (int i = 0; i < number.length(); ++i) {

			sum += Integer.parseInt(number.substring(i, i + 1));
		}

		return sum;
	}
}
