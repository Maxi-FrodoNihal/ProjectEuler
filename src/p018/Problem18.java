package p018;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import util.IProblem;

public class Problem18 implements IProblem {

    // Level: 9 Summe: 7148

    private final List<BiLeave> pathToWalk = new ArrayList<>();

    public static double pathCalculation(final BiLeave knot, final int level) {
        // Math.pow(2, level);

        double value = knot.getValue();

        if (knot.getValue() > 80) {
            value *= 2.5;
        } else if (knot.getValue() > 70) {
            value *= 2;
        } else if (knot.getValue() > 60) {
            value *= 1.5;
        }

        if (knot.getValue() < 10) {
            value /= 2.5;
        } else if (knot.getValue() < 20) {
            value /= 2.0;
        } else if (knot.getValue() < 30) {
            value /= 1.5;
        }

        if (level > 9) {
            return value / 1024;
        } else {

            return value / Math.pow(2, level);
        }
    }

    @Override
    public String solve() {

        final Einleser reader = new Einleser();
        final BiLeave root = reader.readDatStuff();

        final ExecutorService exService = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 40; ++i) {

            this.goToTree(root, i, exService);

            final int sumWay = this.pathToWalk.stream().mapToInt(tmpBiLeave -> tmpBiLeave.getValue()).sum();

            final String[] array = new String[]{i + "", sumWay + ""};
            System.out.println("Level: " + array[0] + " Summe: " + array[1]);

            this.pathToWalk.clear();
        }

        return String.valueOf("");
    }

    private void goToTree(final BiLeave root, final int maxLevel, final ExecutorService exService) {

        this.pathToWalk.add(root);

        final List<Future<Double>> deciderList = this.decider(root, maxLevel, exService);

        double rightTendency = 0.0;
        double leftTendency = 0.0;

        try {
            if (deciderList.get(0) != null) {
                rightTendency = deciderList.get(0).get();
            }
            if (deciderList.get(1) != null) {
                leftTendency = deciderList.get(1).get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        if (root.getRightLeave() != null && rightTendency > leftTendency) {
            this.goToTree(root.getRightLeave(), maxLevel, exService);
        }

        if (root.getLeftLeave() != null && leftTendency > rightTendency) {
            this.goToTree(root.getLeftLeave(), maxLevel, exService);
        }
    }

    private List<Future<Double>> decider(final BiLeave knot, final int maxLevel, final ExecutorService exService) {

        final List<Future<Double>> fList = new ArrayList<>();
        Future<Double> rightFuture = null;
        Future<Double> leftFuture = null;

        if (knot.getRightLeave() != null) {
            rightFuture = exService.submit(new RightDecider(knot.getRightLeave(), 1, maxLevel));
        }

        if (knot.getLeftLeave() != null) {
            leftFuture = exService.submit(new LeftDecider(knot.getLeftLeave(), 1, maxLevel));
        }

        fList.add(rightFuture);
        fList.add(leftFuture);

        return fList;
    }
}
