package p011TOp020.p017;

import java.util.HashMap;
import java.util.Map;

import util.IProblem;

public class Problem17 implements IProblem {

	private Map<Integer, String> numberToWordMap = initNumberToWordMap();

	@Override
	public String solve() {

		StringBuilder strBu = new StringBuilder();

		for (int i = 1; i <= 1000; ++i) {
			strBu.append(hundredTo900(i).replace(" ", "").replace("-", ""));
		}

		return String.valueOf(strBu.length());
	}

	private String hundredTo900(int number) {

		if (number < 1000) {

			if (number < 100) {
				return teenTo90(number);
			} else {

				String and = (number % 100 != 0) ? " and " : "";
				return teenTo90(number / 100) + " hundred" + and + teenTo90(number % 100);
			}
		} else {
			return "one thousand";
		}
	}

	private String teenTo90(int number) {

		String[] wArray = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		if (number <= 15) {
			return numberToWordMap.get(number);
		} else if (number < 20) {

			if (numberToWordMap.get(number % 10).endsWith("t")) {
				return numberToWordMap.get(number % 10) + "een";
			} else {
				return numberToWordMap.get(number % 10) + "teen";
			}
		} else {

			for (int i = 30; i <= 100; i += 10) {

				if (number < i && number >= i - 10) {
					if (number % 10 == 0) {
						return wArray[(i - 30) / 10];
					} else {
						return wArray[(i - 30) / 10] + "-" + numberToWordMap.get(number % 10);
					}
				}
			}
		}

		return "";
	}

	private Map<Integer, String> initNumberToWordMap() {

		Map<Integer, String> numberToWordMap = new HashMap<>();
		String[] wArray = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen" };

		for (int i = 0; i < wArray.length; ++i) {
			numberToWordMap.put(i, wArray[i]);
		}

		return numberToWordMap;
	}
}
