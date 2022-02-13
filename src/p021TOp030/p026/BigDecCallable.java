package p021TOp030.p026;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

public class BigDecCallable implements Callable<Triple<Integer, Integer, BigDecimal>> {

    private final BigDecimal checkNumber;

    public BigDecCallable(final BigDecimal checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public Triple<Integer, Integer, BigDecimal> call() throws Exception {

        final String checkString = this.checkNumber.toString().substring(2);
        int biggestMusterLenght = 0;
        final Set<String> foundMusters = new HashSet<>();

        for (int i = 1; i <= checkString.length() / 2; ++i) {

            final List<String> musterListe = this.getMusterListe(i, checkString);

            if (i > biggestMusterLenght && this.allTheSameValue(musterListe) && this.isUnterMuster(foundMusters, musterListe.get(0)) == false) {

                foundMusters.add(musterListe.get(0));
                biggestMusterLenght = i;
            }
        }

        final int d = BigDecimal.ONE.divide(this.checkNumber, RoundingMode.HALF_UP).intValue();

        return new ImmutableTriple<>(biggestMusterLenght, d, this.checkNumber);
    }

    private List<String> getMusterListe(final int lenght, final String musterData) {

        final List<String> musterListe = new ArrayList<>();
        int globalLenght = 0;

        while (musterData.length() - lenght > globalLenght) {
            final String muster = musterData.substring(globalLenght, globalLenght + lenght);
            musterListe.add(muster);
            globalLenght += lenght;
        }

        return musterListe;
    }

    public <T> boolean allTheSameValue(final List<T> checkList) {

        boolean allTheSame = true;

        if (checkList.size() > 1) {

            final Optional<T> firstValueOptional = checkList.stream().filter(tmpInt -> tmpInt != null).findFirst();

            if (firstValueOptional.isPresent()) {

                final T firstValue = firstValueOptional.get();

                final long countAllTheSameValues = checkList.stream().filter(tmpValue -> firstValue.equals(tmpValue)).count();

                if (countAllTheSameValues == checkList.size()) {

                } else {
                    allTheSame = false;
                }
            }
        } else {
            return false;
        }

        return allTheSame;
    }

    private boolean isUnterMuster(final Set<String> foundMuster, final String actualMuster) {

        for (final String tmpMuster : foundMuster) {

            final String[] splittedMuster = actualMuster.split(tmpMuster);

            final long count = Arrays.stream(splittedMuster).filter(tmpSplitString -> foundMuster.contains(tmpSplitString)).count();

            if (count > 0 || actualMuster.contains(tmpMuster) && splittedMuster != null && splittedMuster.length == 0) {
                return true;
            }
        }

        return false;
    }
}
