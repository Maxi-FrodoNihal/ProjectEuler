package p011TOp020.p020;

import java.math.BigInteger;
import util.IProblem;

public class Problem20 implements IProblem {

    @Override
    public String solve() {

        final BigInteger hundert = new BigInteger("100");
        final BigInteger facResult = this.fac(hundert);
        final int querSum = this.quersumme(facResult.toString());

        return String.valueOf(querSum);
    }

    private BigInteger fac(final BigInteger border) {
        if (border.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return border.multiply(this.fac(border.subtract(BigInteger.ONE)));
        }
    }

    private int quersumme(final String number) {

        int sum = 0;

        for (int i = 0; i < number.length() - 1; ++i) {

            sum += Integer.parseInt(number.substring(i, i + 1));
        }

        return sum;
    }
}
