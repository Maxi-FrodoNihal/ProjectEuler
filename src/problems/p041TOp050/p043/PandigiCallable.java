package problems.p041TOp050.p043;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PandigiCallable implements Callable<List<String>> {

	private List<String> work;

	public PandigiCallable(List<String> work) {
		this.work = work;
	}

	@Override
	public List<String> call() throws Exception {

		List<String> pandigiNumbers = new ArrayList<String>();

		for (String workElement : work) {
			if (isPartialDivisible(workElement)) {
				pandigiNumbers.add(workElement);
			}
		}

		return pandigiNumbers;
	}

	public static boolean isPartialDivisible(String number) {

		boolean allIsDivisible = true;

		allIsDivisible &= Integer.parseInt(number.substring(1, 4)) % 2 == 0;
		allIsDivisible &= Integer.parseInt(number.substring(2, 5)) % 3 == 0;
		allIsDivisible &= Integer.parseInt(number.substring(3, 6)) % 5 == 0;
		allIsDivisible &= Integer.parseInt(number.substring(4, 7)) % 7 == 0;
		allIsDivisible &= Integer.parseInt(number.substring(5, 8)) % 11 == 0;
		allIsDivisible &= Integer.parseInt(number.substring(6, 9)) % 13 == 0;
		allIsDivisible &= Integer.parseInt(number.substring(7, 10)) % 17 == 0;

		return allIsDivisible;
	}
}
