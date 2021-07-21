package p009;

import util.IProblem;

public class Problem9 implements IProblem {

    @Override
    public String solve() {

        int nb1 = 0;
        int nb2 = 0;
        final int oneT = 1000;

        for (int i = 1; i < 1000; ++i) {

            for (int j = 1; j < 1000 - i; ++j) {

                if (this.probe(i, j, oneT - i - j)) {
                    nb1 = i;
                    nb2 = j;
                    break;
                }
            }
        }

        System.out.println(nb1 + " + " + nb2 + " + " + (oneT - nb1 - nb2) + " = 1000");
        System.out.println("und");
        System.out.println(nb1 + "² + " + nb2 + "² = " + (oneT - nb1 - nb2) + "²");

        return String.valueOf(nb1 * nb2 * (oneT - nb1 - nb2));
    }

    public boolean probe(final double a, final double b, final double c) {

        final double realC = Math.sqrt(a * a + b * b);

        if (realC == c) {
            return true;
        } else {
            return false;
        }
    }
}
