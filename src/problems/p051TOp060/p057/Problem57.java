package problems.p051TOp060.p057;

import org.apache.commons.math3.fraction.BigFraction;
import util.IProblem;

public class Problem57 implements IProblem {

    private final BigFraction oneDivideByTwoPointFiveFrac = BigFraction.ONE.divide(BigFraction.TWO.add(BigFraction.ONE_HALF));
    private final BigFraction twoFrac = new BigFraction(2.0);
    private int counter = 0;

    @Override
    public String getSolution() {
        return "153";
    }

    @Override
    public String solve() {
        counter = 0;
        recursiveSqrtTwoFraction(0);
        return String.valueOf(counter);
    }

    private BigFraction recursiveSqrtTwoFraction(int depth) {
        if (depth == 999) {
            return checkFraction(oneDivideByTwoPointFiveFrac);
        } else {
            return checkFraction(BigFraction.ONE.divide(twoFrac.add(recursiveSqrtTwoFraction(++depth))));
        }
    }

    private BigFraction checkFraction(BigFraction fraction) {
        BigFraction tmpFraction = BigFraction.ONE.add(fraction).reduce();

        if (tmpFraction.getNumerator()
                .toString()
                .length() >
                tmpFraction.getDenominator()
                        .toString()
                        .length()) {
            ++counter;
        }
        return fraction;
    }
}
