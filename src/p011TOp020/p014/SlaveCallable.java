package p011TOp020.p014;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SlaveCallable implements Callable<long[]> {

    private int startIndex = 0;
    private int endIndex = 0;
    private final List<Long> ergebnisListe = new ArrayList<>();
    private final long[] zahlUndStrecke = new long[2];

    public SlaveCallable(final int startIndex, final int endIndex) {

        this.endIndex = endIndex;
        this.startIndex = startIndex;
    }

    @Override
    public long[] call() throws Exception {

        for (int i = this.startIndex; i > this.endIndex; i--) {

            long ergebnis = i;
            this.ergebnisListe.add(ergebnis);

            while (ergebnis != 1) {

                if (this.isGrade(ergebnis)) {

                    ergebnis = this.gradeGoOn(ergebnis);

                } else {

                    ergebnis = this.ungradeGoOn(ergebnis);
                }

                this.ergebnisListe.add(ergebnis);
            }

            if (this.zahlUndStrecke[1] < this.ergebnisListe.size()) {

                this.zahlUndStrecke[0] = i;
                this.zahlUndStrecke[1] = this.ergebnisListe.size();
            }

            this.ergebnisListe.clear();
        }

        return this.zahlUndStrecke;
    }

    private boolean isGrade(final long zahl) {

        if ((zahl & 1) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private long ungradeGoOn(final long ungrade) {
        return 3 * ungrade + 1;
    }

    private long gradeGoOn(final long grade) {
        return grade / 2;
    }
}
