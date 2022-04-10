package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import problems.p041TOp050.p044.Problem44;

public class TestEuler {

	public static void main(final String[] args) {

		final Runtime rt = Runtime.getRuntime();

		final IProblem problem = new Problem44();

		final int iterations = problem.getIterations();
		final String averageString = iterations > 1 ? "Average " : "";

		final List<Long> timeList = new ArrayList<>(iterations);
		final List<Double> ramList = new ArrayList<>(iterations);
		final Set<String> lsgSet = new HashSet<>();

		for (int i = 0; i < iterations; ++i) {
			final Triple<Long, Double, String> metrics = TestEuler.solveProblemWithMetrics(problem, rt);
			timeList.add(metrics.getLeft());
			ramList.add(metrics.getMiddle());
			lsgSet.add(metrics.getRight());
		}

		final List<String> oneEntry = new ArrayList<>();
		oneEntry.addAll(lsgSet);

		if (oneEntry.size() == 1) {
			System.out.println(oneEntry.get(0));
		} else if (oneEntry.size() > 1) {
			System.out.println(oneEntry.get(0) + " Es gab mehrere Ergebnisse");
		} else {
			System.out.println("Es gab kein Ergebnis");
		}

		System.out.println(averageString + "Time in Millis: "
				+ timeList.stream().collect(Collectors.averagingLong(Long::longValue)));
		System.out.println(averageString + "Used RAM: "
				+ ramList.stream().collect(Collectors.averagingDouble(Double::doubleValue)) + " MB");
	}

	public static Triple<Long, Double, String> solveProblemWithMetrics(final IProblem problem, final Runtime rt) {

		final long memory1 = rt.totalMemory() - rt.freeMemory();

		final long zeit1 = System.currentTimeMillis();

		final String lsg = problem.solve();

		final long zeit2 = System.currentTimeMillis();
		final long memory2 = rt.totalMemory() - rt.freeMemory();

		final double usedRam = (memory2 - memory1) / 1000000.0;

		return new ImmutableTriple<>(zeit2 - zeit1, usedRam, lsg);
	}
}
