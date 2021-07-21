package p010;

import util.IProblem;

public class Problem10 implements IProblem {

    @Override
    public String solve() {

        final int max = 2000000;
        final boolean[] ausgeschlossen = new boolean[max];
        for (int i = 4; i < max; i += 2) {
            ausgeschlossen[i] = true;
        }
        for (int i = 3; i < max; i += 2) {
            if (ausgeschlossen[i] == false) {
                for (int j = 2 * i; j < max; j += i) {
                    ausgeschlossen[j] = true;
                }
            }
        }
        long sum = 0;
        for (int i = 2; i < ausgeschlossen.length; i++) {
            if (ausgeschlossen[i] == false) {
                sum += i;
            }
        }

        return String.valueOf(sum);
    }
}
