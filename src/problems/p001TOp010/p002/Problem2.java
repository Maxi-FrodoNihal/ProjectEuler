package problems.p001TOp010.p002;

import util.IProblem;

public class Problem2 implements IProblem {

	@Override
	public String getSolution() {
		return "4613732";
	}

	@Override
	public String solve() {

		int step = 1;
		int fiboNumber = 0;
		int sum = 0;

		do {

			fiboNumber = this.fibo(step++);

			if (fiboNumber % 2 == 0) {
				sum += fiboNumber;
			}

		} while (fiboNumber < 4000000);

		return String.valueOf(sum);
	}

	private int fibo(final int step) {
		if (step < 3) {
			return step;
		} else {
			return this.fibo(step - 1) + this.fibo(step - 2);
		}
	}
}
