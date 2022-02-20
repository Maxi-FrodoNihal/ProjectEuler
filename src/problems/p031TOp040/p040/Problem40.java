package problems.p031TOp040.p040;

import util.IProblem;

public class Problem40 implements IProblem {

	@Override
	public String getSolution() {
		return "210";
	}

	@Override
	public String solve() {

		int[] stellen = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
		String numberString = getNumber(1000000);

		int multi = 1;

		for (int tmpStelle : stellen) {
			multi *= Integer.valueOf(String.valueOf(numberString.charAt(tmpStelle - 1)));
		}

		return String.valueOf(multi);
	}

	private String getNumber(int border) {

		StringBuilder strBu = new StringBuilder();

		for (int i = 1; strBu.length() < border; ++i) {
			strBu.append(i);
		}

		return strBu.toString();
	}
}
