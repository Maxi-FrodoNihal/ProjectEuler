package p021TOp030.p024;

import java.util.Arrays;
import java.util.List;
import util.IProblem;

public class Problem24 implements IProblem {

    private int count = 0;
    private String result = "";
    private final int oneMio = 1000000;

    @Override
    public String solve() {

        final List<String> testList = Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});

        this.recSolve(testList, 0, "");

        return this.result;
    }

    private void recSolve(final List<String> dataList, final int index, final String dataWord) {

        if (dataWord.length() < dataList.size() && this.count < this.oneMio) {

            for (int i = 0; i < dataList.size() && this.count < this.oneMio; ++i) {
                if (dataWord.contains(dataList.get(i)) == false) {
                    this.recSolve(dataList, i + 1, dataWord + dataList.get(i));
                }
            }

        } else {

            ++this.count;

            if (this.count == this.oneMio) {
                this.result = dataWord;
            }
        }
    }
}
