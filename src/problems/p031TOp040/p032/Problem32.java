package problems.p031TOp040.p032;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import util.IProblem;

public class Problem32 implements IProblem {

	@Override
	public String getSolution() {
		return "45228";
	}

	@Override
	public String solve() {

		final String[] digitArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		final Set<Integer> resultSet = new HashSet<>();

		for (int i = 1; i <= 9999; ++i) {
			for (int j = 1; j <= 9999; ++j) {

				final int result = i * j;

				final String combinedDigits = String.valueOf(i) + String.valueOf(j) + String.valueOf(result);

				if (combinedDigits.length() == digitArray.length) {

					boolean allIsOK = true;

					for (final String digit : digitArray) {

						if (StringUtils.countMatches(combinedDigits, digit) != 1) {
							allIsOK = false;
							break;
						}
					}

					if (allIsOK) {
						resultSet.add(result);
					}
				}
			}
		}

		return String.valueOf(resultSet.stream().collect(Collectors.summingInt(Integer::intValue)));
	}
}
