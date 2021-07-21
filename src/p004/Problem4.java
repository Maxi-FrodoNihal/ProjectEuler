package p004;

import util.IProblem;

public class Problem4 implements IProblem {

    @Override
    public String solve() {

        int bossPalindrome = 0;

        for (int i = 100; i <= 999; ++i) {
            for (int j = 100; j <= 999; ++j) {

                final int evtlPalindrom = i * j;

                if (this.isPalindrom(evtlPalindrom) && evtlPalindrom > bossPalindrome) {

                    bossPalindrome = evtlPalindrom;
                }
            }
        }

        return String.valueOf(bossPalindrome);
    }

    private boolean isPalindrom(final int number) {

        boolean isPalindrom = false;
        final String numberAsString = String.valueOf(number);

        final StringBuffer strBuff = new StringBuffer(numberAsString);

        if (numberAsString.equals(strBuff.reverse().toString())) {
            isPalindrom = true;
        }

        return isPalindrom;
    }
}
