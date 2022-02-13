package p011TOp020.p014;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import util.IProblem;

public class Problem14 implements IProblem {

    private int result = 0;
    private final int startZahl = 1000000;
    private final int threadAnzahl = 8;
    private final List<Future<long[]>> ergebnisListe = new ArrayList<>();

    @Override
    public String solve() {

        final ExecutorService executor = Executors.newFixedThreadPool(this.threadAnzahl);

        for (int i = 0; i < this.threadAnzahl; ++i) {

            final int start = this.startZahl - this.startZahl / this.threadAnzahl * i;
            final int ende = this.startZahl - this.startZahl / this.threadAnzahl * (i + 1);

            final Future<long[]> tmpErgebnis = executor.submit(new SlaveCallable(start, ende));
            this.ergebnisListe.add(tmpErgebnis);
        }

        try {

            int biggestLenght = 0;

            for (int i = 0; i < this.ergebnisListe.size(); ++i) {

                if (this.ergebnisListe.get(i).get()[1] > biggestLenght) {

                    biggestLenght = (int)this.ergebnisListe.get(i).get()[1];
                    this.result = (int)this.ergebnisListe.get(i).get()[0];
                }
            }

        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        return String.valueOf(this.result);
    }
}
