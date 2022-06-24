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

import org.apache.commons.lang3.StringUtils;

import util.Permutor;
import util.PrimProblem;

public class Problem49 extends PrimProblem {

	@Override
	public String getSolution() {
		return "296962999629";
	}

	@Override
	public String solve() {

		String solution = "";
		List<Integer> allRelevantPrimes = getRelevantPrimes();
		Set<Set<Integer>> permuPrimes = getPermuPrimes(allRelevantPrimes);

		for (Set<Integer> tmpSet : permuPrimes) {

			Map<Integer, List<DistanceElement>> distancesMap = mapByDistance(tmpSet);

			Optional<List<DistanceElement>> findFirst = distancesMap.values().stream()
					.filter(tmpList -> tmpList.size() >= 2).findFirst();

			if (findFirst.isPresent()) {

				Set<String> poles = new TreeSet<>();

				for (DistanceElement pole : findFirst.get()) {
					poles.add(String.valueOf(pole.getFrom()));
					poles.add(String.valueOf(pole.getToo()));
				}

				if (poles.size() == 3 && StringUtils.isBlank(solution)) {
					solution = String.join("", poles);
				}
			}
		}

		return solution;
	}

	private Map<Integer, List<DistanceElement>> mapByDistance(Set<Integer> permuPrimeSet) {

		List<DistanceElement> distances = getDistances(permuPrimeSet);

		Map<Integer, List<DistanceElement>> distancesMap = new HashMap<>();

		for (DistanceElement tmpDE : distances) {

			Integer distance = tmpDE.getDistance();

			if (distancesMap.containsKey(distance)) {
				distancesMap.get(distance).add(tmpDE);
			} else {
				List<DistanceElement> tmpMapList = new ArrayList<DistanceElement>();
				tmpMapList.add(tmpDE);
				distancesMap.put(distance, tmpMapList);
			}
		}

		return distancesMap;
	}

	private Set<Set<Integer>> getPermuPrimes(List<Integer> allRelevantPrimes) {

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
		}

		return permuPrimes;
	}

	private List<Integer> getRelevantPrimes() {

		this.isPrim(9999);

		return this.primNumbers.stream().filter(tmpPrim -> tmpPrim >= 1000).collect(Collectors.toList());
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
			permuteInts.add(Integer.parseInt(String.join("", tmpPermuteString)));
		}

		return permuteInts;
	}
}
