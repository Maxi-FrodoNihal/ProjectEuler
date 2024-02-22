package problems.p031TOp040.p031;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import util.IProblem;

public class Problem31 implements IProblem {

	private final Set<Map<Money, Integer>> possibleCollections = new HashSet<>();

	@Override
	public String getSolution() {
		return "73682";
	}

	@Override
	public String solve() {

//		this.dynamicForSolution(0, new EnumMap<Money, Integer>(Money.class));
		this.forSoultion();

		return String.valueOf(this.possibleCollections.size());
	}

	private void forSoultion() {
		for (int twoH = 0; twoH <= 1; ++twoH) {

			final int realTwoH = Money.TwoPounds.getPennys();
			for (int oneH = 0; oneH <= 2; ++oneH) {

				final int realOneH = Money.OnePound.getPennys();
				for (int fifty = 0; fifty <= 4; ++fifty) {

					final int realFifty = Money.FiftyPennys.getPennys();
					for (int twenty = 0; twenty <= 10; ++twenty) {

						final int realTwenty = Money.TwentyPennys.getPennys();
						int finalTwoH = twoH;
						int finalOneH = oneH;
						int finalFifty = fifty;
						int finalTwenty = twenty;
						IntStream.rangeClosed(0, 20).forEach(ten -> {
							int realTen = Money.TenPennys.getPennys();
							for (int five = 0; five <= 40; five++) {
								int realFive = Money.FivePennys.getPennys();
								for (int two = 0; two <= 100; two++) {
									int realTwo = Money.TwoPennys.getPennys();
									for (int one = 0; one <= 200; one++) {
										int realOne = Money.OnePenny.getPennys();

										int functionValue = realTwoH * finalTwoH + realOneH * finalOneH + realFifty * finalFifty + realTwenty * finalTwenty + realTen * ten + realFive * five + realTwo * two + realOne * one;

										if (functionValue == Money.TwoPounds.getPennys()) {
											Map<Money, Integer> targetMap = new EnumMap<>(Money.class);

											targetMap.put(Money.TwoPounds, finalTwoH);
											targetMap.put(Money.OnePound, finalOneH);
											targetMap.put(Money.FiftyPennys, finalFifty);
											targetMap.put(Money.TwentyPennys, finalTwenty);
											targetMap.put(Money.TenPennys, ten);
											targetMap.put(Money.FivePennys, five);
											targetMap.put(Money.TwoPennys, two);
											targetMap.put(Money.OnePenny, one);

											possibleCollections.add(targetMap);
										}
									}
								}
							}
						});
					}
				}
			}
		}
	}

	private void dynamicForSolution(int depth, final Map<Money, Integer> valueMap) {

		if (depth < Money.values().length) {

			final Money actualValue = Money.values()[depth];
			++depth;

			for (int i = 0; i <= Money.TwoPounds.getPennys() / actualValue.getPennys(); ++i) {

				valueMap.put(actualValue, i);
				this.dynamicForSolution(depth, valueMap);
			}

		} else {

			int functionValue = 0;

			for (final Money tmpMoney : Money.values()) {

				functionValue += tmpMoney.getPennys() * valueMap.get(tmpMoney);
			}

			if (functionValue == Money.TwoPounds.getPennys()) {

				this.possibleCollections.add(new EnumMap<>(valueMap));
			}
		}
	}
}
