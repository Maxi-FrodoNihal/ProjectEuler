package problems.p021TOp030.p023;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CalculationCallable implements Callable<List<Integer>> {

	private final List<Integer> mainList;
	private int startIndex = 0;
	private int endIndex = 0;

	public CalculationCallable(final List<Integer> mainList, final int startIndex, final int endIndex) {

		this.mainList = mainList;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	@Override
	public List<Integer> call() throws Exception {

		final List<Integer> returnList = new ArrayList<>();

		for (int i = this.startIndex; i <= this.endIndex; ++i) {

			boolean breakTwo = false;

			for (int j = 0; j < this.mainList.size() && breakTwo == false; ++j) {

				final int number1 = this.mainList.get(j);

				for (int k = 0; k < this.mainList.size() && breakTwo == false; ++k) {

					final int number2 = this.mainList.get(k);

					final int sumNumber = number1 + number2;

					if (i == sumNumber) {
						breakTwo = true;
					} else if (sumNumber > i) {
						break;
					}
				}
			}

			if (breakTwo == false) {
				returnList.add(i);
			}
		}

		System.out.println("Bin fertig. Intervall von " + this.startIndex + " bis " + this.endIndex);

		return returnList;
	}
}