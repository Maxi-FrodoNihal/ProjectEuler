package p030;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.IProblem;

public class Problem30 implements IProblem {

    @Override
    public String solve() {

        final int border = 5;
        final int borderNumber = (int)Math.pow(9, border) * border;
        final List<Integer> targetNumbers = new ArrayList<>();

        int[] tmpArray = new int[1];
        tmpArray[0] = 1;

        int tmpNumber = this.generateIntFromArray(tmpArray) + 1;

        while (tmpNumber < borderNumber) {

            if (tmpNumber == this.getPowSum(tmpArray, border)) {
                targetNumbers.add(tmpNumber);
            }

            tmpArray = this.generateArrayFromInt(++tmpNumber);
        }

        return String.valueOf(targetNumbers.stream().collect(Collectors.summingInt(Integer::intValue)));
    }

    private int generateIntFromArray(final int[] array) {

        int sum = 0;

        for (int i = 0; i < array.length; ++i) {
            sum += array[i] * Math.pow(10, array.length - 1 - i);
        }

        return sum;
    }

    private int[] generateArrayFromInt(final int number) {

        final String[] numberStringArray = String.valueOf(number).split("");
        final int[] array = new int[numberStringArray.length];

        for (int i = 0; i < numberStringArray.length; ++i) {
            array[i] = Integer.parseInt(numberStringArray[i]);
        }

        return array;
    }

    private int getPowSum(final int[] array, final int power) {

        int sum = 0;

        for (final int tmpInt : array) {
            sum += Math.pow(tmpInt, power);
        }

        return sum;
    }
}
