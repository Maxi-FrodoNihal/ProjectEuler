package problems.p051TOp060.p051;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import util.PrimProblem;

public class Problem51 extends PrimProblem {

	@Override
	public String getSolution() {
		return "121313";
	}

	@Override
	public String solve() {

		int controlNumber = 1000000;

		List<String> stringPrimes = getRelevantStringPrimes(controlNumber);
		Set<String> workSet = generateWorkSet(stringPrimes);
		Map<String, List<Integer>> datMap = workSet.stream()
				.collect(Collectors.toMap(tmp -> tmp, tmp -> getXPrimes(tmp)));

		List<String> importantKeys = datMap.keySet().stream().filter(tmp -> datMap.get(tmp).size() == 8)
				.collect(Collectors.toList());

		TreeSet<Integer> importantPrimes = new TreeSet<>();

		for (String key : importantKeys) {
			importantPrimes.addAll(datMap.get(key));
		}

		return String.valueOf(importantPrimes.first());
	}

	private Set<String> generateWorkSet(List<String> stringPrimes) {

		Set<String> internWorkSet = new HashSet<>();

		for (String stringPrime : stringPrimes) {

			List<String> gatheringList = new ArrayList<>();
			swithXes(stringPrime, stringPrime.length() - 1, gatheringList, internWorkSet);

			internWorkSet.addAll(gatheringList);
		}

		return internWorkSet;
	}

	private List<String> getRelevantStringPrimes(int controlNumber) {

		this.isPrim(controlNumber);

		List<Integer> localPrimes = new ArrayList<>(this.primNumbers);
		localPrimes = localPrimes.stream().filter(tmpPrim -> tmpPrim >= controlNumber / 10)
				.collect(Collectors.toList());

		List<String> stringPrimes = localPrimes.stream().map(tmpElement -> tmpElement.toString())
				.collect(Collectors.toList());

		return stringPrimes;
	}

	private void swithXes(String s, int level, List<String> gatheringList, Set<String> workSet) {

		List<String> letterList = stringToLetterList(s);

		long amountOfX = letterList.stream().filter(tmpLetter -> "X".equals(tmpLetter)).count();

		if (amountOfX < level) {

			for (int i = 0; i < letterList.size(); ++i) {

				letterList = stringToLetterList(s);
				String tmpLetter = letterList.get(i);

				if ("X".equals(tmpLetter) == false) {
					letterList.set(i, "X");
					String newString = letterListToString(letterList);
					gatheringList.add(newString);

					if (workSet.contains(newString) == false) {
						swithXes(newString, level, gatheringList, workSet);
					}
				}
			}
		}
	}

	private List<String> stringToLetterList(String s) {

		List<String> letterList = new ArrayList<>();
		String[] sArray = s.split("", -1);

		for (String tmpString : sArray) {
			letterList.add(tmpString);
		}

		return letterList.subList(0, letterList.size() - 1);
	}

	private String letterListToString(List<String> letterList) {

		String s = "";

		for (String letter : letterList) {
			s += letter;
		}

		return s;
	}

	private List<Integer> getXPrimes(String xString) {

		List<Integer> xPrimes = new ArrayList<>();

		for (int i = 0; i < 10; ++i) {
			String evtlPrimeInString = xString.replace("X", String.valueOf(i));
			int evtlPrime = Integer.parseInt(evtlPrimeInString);

			if (this.isPrim(evtlPrime) && String.valueOf(evtlPrime).length() == xString.length()) {
				xPrimes.add(evtlPrime);
			}
		}

		return xPrimes;
	}
}
