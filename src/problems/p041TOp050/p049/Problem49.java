package problems.p041TOp050.p049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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

		List<Set<Integer>> threeElements = permuPrimes.stream().filter(tmpSet -> tmpSet.size() == 3)
				.collect(Collectors.toList());

		return null;
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
