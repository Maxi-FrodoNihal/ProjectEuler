package problems.p031TOp040.p033;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.Fraction;

import util.IProblem;

public class Problem33 implements IProblem {

	@Override
	public String getSolution() {
		return "100";
	}

	@Override
	public String solve() {

		final Set<Fraction> lsgSet = new HashSet<>();

		final String[] digitArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		for (int i = 10; i <= 99; ++i) {
			for (int j = 10; j <= 99; ++j) {

				if (i != j && i < j) {

					final Fraction tmpF = Fraction.getFraction(i, j);

					for (final String tmpDigit : digitArray) {

						String z = String.valueOf(i);
						String n = String.valueOf(j);

						if (z.contains(tmpDigit) && n.contains(tmpDigit)) {

							z = z.replace(tmpDigit, "");
							n = n.replace(tmpDigit, "");

							if (StringUtils.isNotBlank(z) && StringUtils.isNotBlank(n) && "0".equals(z) == false
									&& "0".equals(n) == false) {

								final Fraction shorterF = Fraction.getFraction(z + "/" + n);

								if (shorterF.compareTo(tmpF) == 0) {
									lsgSet.add(tmpF);
								}
							}
						}
					}
				}
			}
		}

		// lsgSet.stream().forEach(tmpFrac -> System.out.println(tmpFrac + " | " +
		// tmpFrac.reduce()));

		Fraction multiplyFrac = Fraction.ONE;

		for (final Fraction tmpFrac : lsgSet) {
			multiplyFrac = multiplyFrac.multiplyBy(tmpFrac);
		}

		return String.valueOf(multiplyFrac.reduce().getDenominator());
	}
}
