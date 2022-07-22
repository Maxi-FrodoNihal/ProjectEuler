package problems.p041TOp050.p050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class PrimSumCallable implements Callable<Pair<Integer, List<Integer>>> {

	private static List<Integer> primNumbers = null;
	private List<Integer> workNumbers;

	public PrimSumCallable(List<Integer> workNumbers, List<Integer> primNumbers) {

		if (PrimSumCallable.primNumbers == null) {
			PrimSumCallable.primNumbers = new ArrayList<>(primNumbers);
		}

		this.workNumbers = workNumbers;
	}

	@Override
	public Pair<Integer, List<Integer>> call() throws Exception {
		return getPrimeWithLagrestAmountOfSummands(generateSumMap(workNumbers));
	}

	private Map<Integer, List<Integer>> generateSumMap(List<Integer> workNumbers) {

		Map<Integer, List<Integer>> sumMap = new HashMap<>();
		List<Integer> tmpList = new ArrayList<>();

		for (int i = 0; i < workNumbers.size(); ++i) {

			int actualPrime = workNumbers.get(i);

			// Optimierungs Part ist hier das j < 10. Diese For Schleife ist dafür da, den
			// Anfang der fortführenden Summandenreihe zu finden. Die Idee ist hierbei, dass
			// eine Primzahlen mit maximaler Summanden anzahl die ersten 10 Primzahlen
			// definitiv nicht verschmähen würde. Diese bringen am meisten Anzahl und am
			// wenigsten Aufsummierung, daher kann abgebrochen werden wenn die
			// Summandenreihenfolge die ersten 10 Primzahlen nicht mitnimmt.
			for (int j = 0; j < 10 && sumMap.containsKey(actualPrime) == false; ++j) {

				int sum = 0;
				tmpList.clear();

				for (int k = 0 + j; k < primNumbers.size() && sum < actualPrime; ++k) {

					sum += primNumbers.get(k);
					tmpList.add(primNumbers.get(k));

					if (sum == actualPrime && tmpList.size() > 1) {
						sumMap.put(actualPrime, new ArrayList<>(tmpList));
					}
				}
			}
		}

		return sumMap;
	}

	private Pair<Integer, List<Integer>> getPrimeWithLagrestAmountOfSummands(Map<Integer, List<Integer>> sumMap) {

		int size = 0;
		int sizePrime = 0;

		for (Integer keyPrime : sumMap.keySet()) {

			List<Integer> actualList = sumMap.get(keyPrime);

			if (actualList.size() > size) {
				size = actualList.size();
				sizePrime = keyPrime;
			}
		}

		return new ImmutablePair<Integer, List<Integer>>(sizePrime, sumMap.get(sizePrime));
	}
}
