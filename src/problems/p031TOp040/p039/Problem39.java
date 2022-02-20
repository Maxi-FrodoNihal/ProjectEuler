package problems.p031TOp040.p039;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import util.IProblem;

public class Problem39 implements IProblem {

	@Override
	public String getSolution() {
		return "840";
	}

	@Override
	public String solve() {

		int border = 1000;
		int u = 0;
		Map<Integer, Set<Set<Integer>>> targetMap = new HashMap<>();

		for (int a = 1; a <= border; ++a) {
			for (int b = 1; b <= border; ++b) {

				int c = pyhtagoras(a, b);

				if (c != 0) {

					u = a + b + c;

					if (u <= 1000) {

						if (targetMap.containsKey(u)) {
							targetMap.get(u).add(getABCSet(a, b, c));
						} else {
							Set<Set<Integer>> newSet = new HashSet<>();
							newSet.add(getABCSet(a, b, c));
							targetMap.put(u, newSet);
						}
					} else {
						break;
					}
				}
			}
		}

		u = 0;
		int biggestSize = 0;

		for (Integer keyU : targetMap.keySet()) {

			if (biggestSize <= targetMap.get(keyU).size()) {
				biggestSize = targetMap.get(keyU).size();
				u = keyU;
			}
		}

		return String.valueOf(u);
	}

	private Set<Integer> getABCSet(int a, int b, int c) {
		Set<Integer> threeDigits = new HashSet<>();
		threeDigits.add(a);
		threeDigits.add(b);
		threeDigits.add(c);
		return threeDigits;
	}

	private int pyhtagoras(int a, int b) {

		int aSquare = (a * a);
		int bSquare = (b * b);
		Double cDouble = Math.sqrt(aSquare + bSquare);

		if (cDouble % 1 == 0) {
			return cDouble.intValue();
		} else {
			return 0;
		}
	}
}
