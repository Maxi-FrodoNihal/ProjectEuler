package p011TOp020.p015;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import util.IProblem;

public class Problem15 implements IProblem {

    private final int border = 20;

    @Override
    public String solve() {

        final ExecutorService exService = Executors.newFixedThreadPool(2);

        final SlaveRunnable run1 = new SlaveRunnable(1, 0, this.border);
        final SlaveRunnable run2 = new SlaveRunnable(0, 1, this.border);

        exService.execute(run1);
        exService.execute(run2);

        exService.shutdown();

        try {
            exService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        long counter = 0l;

        if (exService.isShutdown()) {
            counter = run1.getCounter() + run2.getCounter();
        }

        return String.valueOf(counter);
    }

    private class SlaveRunnable implements Runnable {

        private final int right;
        private final int down;
        private final int border;
        private long counter = 0l;

        public SlaveRunnable(final int right, final int down, final int border) {
            this.right = right;
            this.down = down;
            this.border = border;
        }

        public long getCounter() {
            return this.counter;
        }

        @Override
        public void run() {
            this.path(this.right, this.down);
        }

        private void path(final int right, final int down) {

            if (right == this.border && down == this.border) {
                ++this.counter;
            } else {

                if (right < this.border) {
                    this.path(right + 1, down);
                }

                if (down < this.border) {
                    this.path(right, down + 1);
                }
            }
        }
    }
}
