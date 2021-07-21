package p027;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import util.IProblem;

public class Problem27 implements IProblem {

    private final List<Integer> primNumbers = new ArrayList<>();

    @Override
    public String solve() {

        int globalPrimSequenceNumber = 0;
        Formula globalFormular = null;

        for (int a = -999; a < 1000; ++a) {
            for (int b = -1000; b <= 1000; ++b) {

                final Formula tmpFormular = new Formula(a, b);

                final int sequenceNumber = this.getSequenceOfPrim(tmpFormular);
                if (globalPrimSequenceNumber < sequenceNumber) {
                    globalFormular = tmpFormular;
                    globalPrimSequenceNumber = sequenceNumber;
                }
            }
        }

        return String.valueOf(globalFormular.getA() * globalFormular.getB());
    }

    private int getSequenceOfPrim(final Formula f) {

        int mayBePrim = 0;
        int counter = -1;

        do {
            ++counter;
            mayBePrim = f.calculateNext();

        } while (this.isPrim(mayBePrim));

        return counter;
    }

    private boolean isPrim(final int number) {

        if (CollectionUtils.isEmpty(this.primNumbers) || this.primNumbers.get(this.primNumbers.size() - 1) < number) {

            int i = CollectionUtils.isEmpty(this.primNumbers) ? 1 : this.primNumbers.size() + 1;
            int actualPrimNumber = 0;

            do {
                actualPrimNumber = this.eratosthenes(i);
                this.primNumbers.add(actualPrimNumber);
                ++i;
            } while (actualPrimNumber < number);

            return this.primNumbers.get(this.primNumbers.size() - 1) == number;
        } else {
            return this.primNumbers.contains(number);
        }
    }

    private int eratosthenes(final int indexOfPrim) {

        final List<Integer> primList = new ArrayList<>();
        primList.add(2);
        primList.add(3);
        primList.add(5);

        if (indexOfPrim > 3) {

            int actualNumber = 6;

            while (primList.size() < indexOfPrim) {

                int counter = 0;

                for (final Integer primNumber : primList) {

                    if (actualNumber % primNumber != 0) {
                        counter++;
                    } else {
                        break;
                    }
                }

                if (counter == primList.size()) {
                    primList.add(actualNumber);
                }

                actualNumber++;
            }
        }

        return primList.get(indexOfPrim - 1);
    }
}
