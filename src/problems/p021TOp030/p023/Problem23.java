package problems.p021TOp030.p023;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import util.IProblem;

public class Problem23 implements IProblem {

	@Override
	public String getSolution() {
		return "4179871";
	}

	private Integer properDivisorsSum(final int number) {

		int sum = 0;
		int border = 0;

		if (number % 2 != 0) {
			border = (number + 1) / 2;
		} else {
			border = number / 2;
		}

		for (int i = 1; i <= border; ++i) {

			if (number % i == 0) {
				sum += i;
			}
		}

		return sum;
	}

	private List<Integer> getAbundantNumbersToLimit(final int limit) {

		final List<Integer> abundantNumbers = new ArrayList<>();

		for (int i = 12; i <= limit; ++i) {

			final int divisorSum = this.properDivisorsSum(i);

			if (divisorSum > i) {
				abundantNumbers.add(i);
			}
		}

		return abundantNumbers;
	}

	private List<Integer> generateCalculationIntervalls(final int threads, final int border) {

		final List<Integer> intervallList = new ArrayList<>();
		final int faktor = border / threads;

		for (int i = 0; i < threads; ++i) {

			intervallList.add(i * faktor + 1);
			intervallList.add((i + 1) * faktor);
		}

		intervallList.set(intervallList.size() - 1, border);

		return intervallList;
	}

	@Override
	public String solve() {

		final int borderNumber = 28123;
		final int threadNumber = 20;

		int finalSumNumber = 0;
		final List<Integer> mainList = new ArrayList<>();

		final List<Integer> abundantNumbersToLimit = this.getAbundantNumbersToLimit(borderNumber);
		final ExecutorService threadPool = Executors.newCachedThreadPool();
		final List<Integer> intervalls = this.generateCalculationIntervalls(threadNumber, borderNumber);

		final List<CalculationCallable> callables = new ArrayList<>();
		final List<Future<List<Integer>>> futures = new ArrayList<>();

		for (int i = 0; i < intervalls.size(); i = i + 2) {

			final int start = intervalls.get(i);
			final int end = intervalls.get(i + 1);

			callables.add(new CalculationCallable(abundantNumbersToLimit, start, end));
		}

		callables.stream().forEach(tmpCallable -> futures.add(threadPool.submit(tmpCallable)));

		for (final Future<List<Integer>> tmpFuture : futures) {
			try {
				mainList.addAll(tmpFuture.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		finalSumNumber = mainList.stream().collect(Collectors.summingInt(Integer::intValue));
		threadPool.shutdown();

		return String.valueOf(finalSumNumber);
	}
}
