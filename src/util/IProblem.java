package util;

public interface IProblem {

    String solve();

    default int getIterations() {
        return 1;
    }
}
