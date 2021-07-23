package p029;

import java.util.HashSet;
import java.util.Set;
import util.IProblem;

public class Problem29 implements IProblem {

    @Override
    public String solve() {

        final int border = 100;
        final Set<Double> doubleSet = new HashSet<>();

        for (int a = 2; a <= border; ++a) {
            for (int b = 2; b <= border; ++b) {
                doubleSet.add(Math.pow(a, b));
            }
        }

        return String.valueOf(doubleSet.size());
    }
}
