package util;

public interface IProblem {

	String solve();

	default int getIterations() {
		return 1;
	}

	default String getSolution() {
		return String.valueOf(Integer.MIN_VALUE);
	}
}
