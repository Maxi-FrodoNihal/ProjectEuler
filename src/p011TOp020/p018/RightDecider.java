package p011TOp020.p018;

import java.util.concurrent.Callable;

public class RightDecider implements Callable<Double> {

    private double sumVar = 0.0;
    private final int startLevel;
    private final int maxLevel;
    private final BiLeave rootKnot;

    public RightDecider(final BiLeave rootKnot, final int startLevel, final int maxLevel) {
        this.rootKnot = rootKnot;
        this.startLevel = startLevel;
        this.maxLevel = maxLevel;
    }

    @Override
    public Double call() throws Exception {

        this.goForRight(this.rootKnot, this.startLevel, this.maxLevel);

        return this.sumVar;
    }

    private void goForRight(final BiLeave knot, final int level, final int maxLevel) {

        if (level <= maxLevel) {

            this.sumVar += Problem18.pathCalculation(knot, level);

            if (knot.getLeftLeave() != null) {
                this.goForRight(knot.getLeftLeave(), level + 1, maxLevel);
            }

            if (knot.getRightLeave() != null) {
                this.goForRight(knot.getRightLeave(), level + 1, maxLevel);
            }
        }
    }
}
