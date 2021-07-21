package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CList<S, T extends Callable<S>> {

    private final int space;
    private final ExecutorService eService;
    private final ICListController<S, T> controller;

    public CList(final int space, final ExecutorService eService, final ICListController<S, T> controller) {
        this.space = space;
        this.eService = eService;
        this.controller = controller;
    }

    public void run() throws InterruptedException, ExecutionException {

        try {

            final List<Future<S>> futureList = this.kaltStart(this.space);

            while (this.listIsWorking(futureList) || this.listIsWorking(futureList) == false && this.controller.continueCalculation()) {

                final Future<S> doneFuture = this.findOneWhoIsDone(futureList);

                if (doneFuture != null) {

                    this.controller.callbackValue(doneFuture.get());

                    futureList.remove(doneFuture);
                    if (this.controller.continueCalculation()) {
                        this.getNextCallableToListAndStart(futureList);
                    }
                }
            }

        } catch (final Exception e) {

            if (e instanceof InterruptedException || e instanceof ExecutionException) {
                throw e;
            } else {
                e.printStackTrace();
            }

        } finally {
            if (this.eService != null) {
                this.eService.shutdown();
            }
        }
    }

    private void getNextCallableToListAndStart(final List<Future<S>> futureList) {

        final T nextCallable = this.controller.getNext();

        if (nextCallable != null) {
            futureList.add(this.eService.submit(nextCallable));
        }
    }

    private List<Future<S>> kaltStart(final int space) {

        final List<Future<S>> futureList = new ArrayList<>(space);

        for (int i = 0; i < space; ++i) {

            this.getNextCallableToListAndStart(futureList);
        }

        return futureList;
    }

    private Future<S> findOneWhoIsDone(final List<Future<S>> list) {

        final Optional<Future<S>> doneFutureOptional = list.stream().filter(tmpFuture -> tmpFuture.isDone()).findFirst();

        if (doneFutureOptional.isPresent()) {
            return doneFutureOptional.get();
        } else {
            return null;
        }
    }

    private boolean listIsWorking(final List<Future<S>> list) {

        final long workingFutures = list.stream().filter(tmpFuture -> tmpFuture.isDone() == false).count();

        return workingFutures > 0;
    }
}
