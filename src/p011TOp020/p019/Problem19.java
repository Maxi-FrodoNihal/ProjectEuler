package p011TOp020.p019;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import util.IProblem;

public class Problem19 implements IProblem {

    @Override
    public String solve() {

        final LocalDate start = LocalDate.parse("1901-01-01");
        final LocalDate ende = LocalDate.parse("2000-12-31");

        int sumOfFirstSundays = 0;
        LocalDate tempDay = start;

        while (tempDay.isAfter(ende) == false) {

            if (tempDay.getDayOfMonth() == 1 && DayOfWeek.SUNDAY == tempDay.getDayOfWeek()) {
                sumOfFirstSundays += 1;
            }

            tempDay = tempDay.plus(1, ChronoUnit.DAYS);
        }

        return String.valueOf(sumOfFirstSundays);
    }
}
