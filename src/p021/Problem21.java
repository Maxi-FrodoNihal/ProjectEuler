package p021;

import util.IProblem;

public class Problem21 implements IProblem {

    private static Integer properDivisors(final int number) {

        int sum = 0;
        int border = 0;

        if (number % 2 != 0) {
            border = (number + 1) / 2;
        } else {
            border = number / 2;
        }

        for (int i = 1; i <= border; ++i) {

            if (number % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    @Override
    public String solve() {

        int mainSum = 0;

        for (int i = 1; i < 10000; ++i) {

            final int sumOne = Problem21.properDivisors(i);
            final int sumTwo = Problem21.properDivisors(sumOne);

            if (i == sumTwo && sumOne != i) {
                // System.out.println(sumOne + ", " + sumTwo);
                mainSum += i + sumOne;
            }
        }

        return String.valueOf(mainSum / 2);
    }
}
