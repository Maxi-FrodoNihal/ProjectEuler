package util;

import java.util.concurrent.Callable;

public interface ICListController<S, T extends Callable<S>> {

    T getNext();

    void callbackValue(S o);

    boolean continueCalculation();
}
