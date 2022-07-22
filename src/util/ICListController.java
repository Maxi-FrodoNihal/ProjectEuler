package util;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

public interface ICListController<S, T extends Callable<S>> {

	T getNext() throws NoSuchElementException;

	void callbackValue(S o);

	boolean continueCalculation();
}
