package problems.p031TOp040.p036;

import util.IProblem;

public class Problem36 implements IProblem {

	private StringBuilder strBuild = new StringBuilder();

	@Override
	public String solve() {

		int sumVar = 0;

		for (int i = 0; i < 1000000; ++i) {

			if (isPalindromNoLeadingZeros(String.valueOf(i)) && isPalindromNoLeadingZeros(Integer.toBinaryString(i))) {
				sumVar += i;
			}
		}

		return String.valueOf(sumVar);
	}

	private boolean isPalindromNoLeadingZeros(String number) {

		boolean isPalindrom = false;

		strBuild.append(number);

		if (number.equals(strBuild.reverse().toString()) && number.startsWith("0") == false) {
			isPalindrom = true;
		}

		strBuild = strBuild.delete(0, strBuild.length());

		return isPalindrom;
	}
}
