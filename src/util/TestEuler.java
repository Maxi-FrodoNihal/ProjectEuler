package util;

import p028.Problem28;

public class TestEuler {

    public static void main(final String[] args) {

        final Runtime rt = Runtime.getRuntime();
        final long memory1 = rt.totalMemory() - rt.freeMemory();

        final IProblem problem = new Problem28();

        final long zeit1 = System.currentTimeMillis();

        final String lsg = problem.solve();

        final long zeit2 = System.currentTimeMillis();
        final long memory2 = rt.totalMemory() - rt.freeMemory();

        System.out.println(lsg);
        System.out.println("Time in Millis: " + (zeit2 - zeit1));

        final double usedRam = (memory2 - memory1) / 1000000.0;

        System.out.println("Used RAM: " + usedRam + " MB");
    }
}
