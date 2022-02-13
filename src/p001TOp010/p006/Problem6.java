package p001TOp010.p006;

import java.math.BigDecimal;
import util.IProblem;

public class Problem6 implements IProblem {

    @Override
    public String solve() {

        final double border = 100.0;

        final double smallGauss = (border * border + border) / 2;

        final double squareGauss = Math.pow(smallGauss, 2);

        final double pyramidNumber = (2 * Math.pow(border, 3) + 3 * Math.pow(border, 2) + border) / 6;

        final BigDecimal number = new BigDecimal(squareGauss - pyramidNumber);

        return number.toString();
    }
}
