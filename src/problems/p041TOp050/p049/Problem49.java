package problems.p041TOp050.p049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;

import util.Permutor;
import util.PrimProblem;

public class Problem49 extends PrimProblem {

	@Override
	public String solve() {

		this.isPrim(9999);

		List<Integer> allPrimes = new ArrayList<>();
		allPrimes.addAll(this.primNumbers);

		List<Integer> allSmallPrimes = new ArrayList<Integer>();

		for (Integer prime : allPrimes) {
			if (prime < 1000) {
				allSmallPrimes.add(prime);
			}
		}

		List<Integer> allRelevantPrimes = ListUtils.subtract(allPrimes, allSmallPrimes);
		Set<Set<Integer>> permuPrimes = new HashSet<Set<Integer>>();

		for (Integer tmpPrime : allRelevantPrimes) {

			List<Integer> permutedInts = getPermutedInts(tmpPrime);
			Set<Integer> primeSet = new TreeSet<Integer>();
			primeSet.add(tmpPrime);

			for (Integer tmpPermuInt : permutedInts) {

				if (Collections.binarySearch(allRelevantPrimes, tmpPermuInt) >= 0) {
					primeSet.add(tmpPermuInt);
				}
			}

			permuPrimes.add(primeSet);

//			System.out.println("Hallo");
		}

		for (Set<Integer> tmpSet : permuPrimes) {

			List<DistanceElement> distances = getDistances(tmpSet);

			Map<Integer, List<DistanceElement>> distancesMap = new HashMap<>();

			for (DistanceElement tmpDE : distances) {

				if (distancesMap.containsKey(tmpDE.getDistance())) {
					distancesMap.get(tmpDE.getDistance()).add(tmpDE);
				} else {
					List<DistanceElement> tmpMapList = new ArrayList<DistanceElement>();
					tmpMapList.add(tmpDE);
					distancesMap.put(tmpDE.getDistance(), tmpMapList);
				}
			}

			Optional<List<DistanceElement>> findFirst = distancesMap.values().stream()
					.filter(tmpList -> tmpList.size() >= 2).findFirst();

			if (findFirst.isPresent()) {

				Set<Integer> poles = new HashSet<Integer>();

				for (DistanceElement pole : findFirst.get()) {
					poles.add(pole.getFrom());
					poles.add(pole.getToo());
				}

				if (poles.size() == 3) {
					System.out.println(poles);
				}
			}
		}

		return null;
	}

	private List<DistanceElement> getDistances(Set<Integer> values) {

		List<Integer> morphList = new ArrayList<Integer>();
		morphList.addAll(values);

		Set<DistanceElement> dSet = new HashSet<DistanceElement>();

		for (int i = 0; i < morphList.size(); ++i) {
			for (int j = 0; j < morphList.size(); ++j) {

				if (i != j) {
					dSet.add(new DistanceElement(morphList.get(i), morphList.get(j),
							morphList.get(i) - morphList.get(j)));
				}
			}
		}

		return dSet.stream().collect(Collectors.toList());
	}

	private List<Integer> getPermutedInts(int number) {

		List<Integer> permuteInts = new ArrayList<Integer>();

		Permutor per = new Permutor();
		List<String> permuElement = Arrays.asList(String.valueOf(number).split("", -1));
		permuElement = permuElement.subList(0, permuElement.size() - 1);
		List<List<String>> permuteStrings = per.permute(permuElement);

		for (List<String> tmpPermuteString : permuteStrings) {

			String listVal = tmpPermuteString.toString().replace(",", "").replace("[", "").replace("]", "").replace(" ",
					"");
			permuteInts.add(Integer.parseInt(listVal));
		}

		return permuteInts;
	}

}
