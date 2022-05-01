package problems.p041TOp050.p045;

import java.util.concurrent.Callable;

public class IsTPHCallable implements Callable<Long> {

	private Long from;
	private Long to;

	public IsTPHCallable(Long from, Long to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public Long call() throws Exception {

		Long solution = -1l;

		for (Long i = from; i <= to; ++i) {

			if (isTriangular(i) && isPentagonal(i) && isHexagonal(i)) {
				solution = i;
				break;
			}
		}

		return solution;
	}

	private boolean isTriangular(long number) {

		double solution = 0.5 * (Math.sqrt((8 * number) + 1) - 1);

		return solution % 1 == 0;
	}

	private boolean isPentagonal(long number) {

		double solution = (1.0 / 6.0) * (Math.sqrt((24 * number) + 1) + 1);

		return solution % 1 == 0;
	}

	private boolean isHexagonal(long number) {

		double solution = 0.25 * (Math.sqrt((8 * number) + 1) + 1);

		return solution % 1 == 0;
	}

}
