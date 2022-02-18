package problems.p021TOp030.p025;

import java.math.BigInteger;

import util.IProblem;

public class Problem25 implements IProblem {

	private Integer fiboIter(final int digitLenght) {

		int i = 2;
		BigInteger first = BigInteger.ZERO;
		BigInteger second = BigInteger.ONE;
		BigInteger third = BigInteger.ONE;

		while (third.toString().length() < digitLenght) {

			first = second;
			second = third;

			third = second.add(first);
			++i;
		}

		return i;
	}

	@Override
	public String solve() {
		return String.valueOf(this.fiboIter(1000));
	}
}
