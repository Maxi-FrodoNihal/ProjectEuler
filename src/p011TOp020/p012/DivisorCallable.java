package p011TOp020.p012;

import java.util.concurrent.Callable;

public class DivisorCallable implements Callable<Integer> {

    private final int start;
    private final int ende;

    public DivisorCallable(final int start, final int ende) {
        this.start = start;
        this.ende = ende;
    }

    @Override
    public Integer call() throws Exception {

        int highestDivisor = 0;
        int finalTriangleNumber = 0;

        for (int i = this.start; i <= this.ende; ++i) {

            final int triangleNumber = this.kleinerGauss(i);

            final int divisor = this.getProperDivisorsAmount(triangleNumber);

            if (divisor > highestDivisor) {
                highestDivisor = divisor;
                finalTriangleNumber = triangleNumber;

                if (highestDivisor >= 500) {
                    break;
                }
            }
        }

        System.out.println(finalTriangleNumber + "/" + highestDivisor);

        if (highestDivisor >= 500) {
            return finalTriangleNumber;
        }

        return 0;
    }

    private int kleinerGauss(final int n) {
        return (n * n + n) / 2;
    }

    private int getProperDivisorsAmount(final int number) {

        int divisorAmount = 1;

        for (int i = 1; i <= number / 2; ++i) {

            if (number % i == 0) {
                ++divisorAmount;
            }
        }

        return divisorAmount;
    }
}
