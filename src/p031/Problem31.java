package p031;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import util.IProblem;

public class Problem31 implements IProblem {

    private final Set<Map<Money, Integer>> possibleCollections = new HashSet<>();

    @Override
    public String solve() {

        // this.dynamicForSolution(0, new EnumMap<Money, Integer>(Money.class));
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
                        for (int ten = 0; ten <= 20; ++ten) {

                            final int realTen = Money.TenPennys.getPennys();
                            for (int five = 0; five <= 40; ++five) {

                                final int realFive = Money.FivePennys.getPennys();
                                for (int two = 0; two <= 100; ++two) {

                                    final int realTwo = Money.TwoPennys.getPennys();
                                    for (int one = 0; one <= 200; ++one) {

                                        final int realOne = Money.OnePenny.getPennys();

                                        final int functionValue = realTwoH * twoH + realOneH * oneH + realFifty * fifty + realTwenty * twenty
                                                + realTen * ten + realFive * five + realTwo * two + realOne * one;

                                        if (functionValue == Money.TwoPounds.getPennys()) {

                                            final Map<Money, Integer> targetMap = new EnumMap<>(Money.class);

                                            targetMap.put(Money.TwoPounds, twoH);
                                            targetMap.put(Money.OnePound, oneH);
                                            targetMap.put(Money.FiftyPennys, fifty);
                                            targetMap.put(Money.TwentyPennys, twenty);
                                            targetMap.put(Money.TenPennys, ten);
                                            targetMap.put(Money.FivePennys, five);
                                            targetMap.put(Money.TwoPennys, two);
                                            targetMap.put(Money.OnePenny, one);

                                            this.possibleCollections.add(targetMap);
                                        }
                                    }
                                }
                            }
                        }
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
