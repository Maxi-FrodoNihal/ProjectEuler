package p001TOp010.p003;

import java.math.BigInteger;
import java.util.ArrayList;
import util.IProblem;

public class Problem3 implements IProblem {

    private long result = 0;

    /**
     * Größter Primfaktor bei der Primfaktorzerlegung der Zahl 600851475143
     */
    @Override
    public String solve() {

        final long zielZahl = 600851475143L;

        this.solveLong(zielZahl);

        return String.valueOf(this.result);
    }

    public static BigInteger sqrt(final BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while (b.compareTo(a) >= 0) {
            final BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }

    private ArrayList<Long> primZahlenListeErstellenLong(final long grenze) {

        final ArrayList<Long> primzahlenListe = new ArrayList<>();

        for (long i = 0; i < grenze; ++i) {

            if (i < 17) {

                switch (i + "") {
                    case "2":
                        primzahlenListe.add((long)2);
                        continue;
                    case "3":
                        primzahlenListe.add((long)3);
                        continue;
                    case "5":
                        primzahlenListe.add((long)5);
                        continue;
                    case "7":
                        primzahlenListe.add((long)7);
                        continue;
                    case "11":
                        primzahlenListe.add((long)11);
                        continue;
                    case "13":
                        primzahlenListe.add((long)13);
                        continue;
                }
            }

            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0 || i == 1) {
                continue;
            }

            for (long j = 10; j * j <= i; j += 10) {
                if (i % (j + 1) == 0) { // 11, 21, 31, 41, 51, ...
                    continue;
                }
                if (i % (j + 3) == 0) { // 13, 23, 33, 43, 53, ...
                    continue;
                }
                if (i % (j + 7) == 0) { // 17, 27, 37, 47, 57, ...
                    continue;
                }
                if (i % (j + 9) == 0) { // 19, 29, 39, 49, 59, ...
                    continue;
                }
            }
            primzahlenListe.add(i);
        }

        return primzahlenListe;
    }

    private void solveLong(final long zielZahl) {

        final ArrayList<Long> primZahlenListe = this.primZahlenListeErstellenLong((long)Math.sqrt(zielZahl));

        long primZahlErgebnis = zielZahl;
        int count = 0;
        boolean primzahlErgebnisIstPrim;

        do {

            final long tmpPrimzahl = primZahlenListe.get(count);

            if (primZahlErgebnis % tmpPrimzahl == 0) {

                primZahlErgebnis = primZahlErgebnis / tmpPrimzahl;

                System.out.print(primZahlenListe.get(count) + " * ");
                count = 0;

            } else {

                count++;
            }

            primzahlErgebnisIstPrim = new BigInteger(primZahlErgebnis + "").isProbablePrime(Integer.MAX_VALUE);

        } while (primzahlErgebnisIstPrim == false);

        this.result = primZahlErgebnis;
    }
}
