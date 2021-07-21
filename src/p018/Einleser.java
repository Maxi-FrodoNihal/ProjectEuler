package p018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Einleser {

    public BiLeave readDatStuff() {

        final String path = "C:\\hsh\\eclipse\\workspace_oxygen2\\ProjectEuler\\src\\p018\\maxPyramid.txt";
        final BiLeave root = new BiLeave();

        try (BufferedReader bfr = new BufferedReader(new FileReader(new File(path)))) {

            final String firstLine = bfr.readLine();
            final String[] firstNumber = firstLine.split(" ");
            int level = 0;

            root.setValue(Integer.valueOf(firstNumber[0]));
            root.setLevel(level);

            final List<BiLeave> lastList = new ArrayList<>();
            lastList.add(root);

            while (bfr.ready()) {

                final String oneLine = bfr.readLine();
                final String[] numberArray = oneLine.split(" ");
                final List<BiLeave> tmpList = new ArrayList<>();
                ++level;

                for (int i = 0; i < numberArray.length; ++i) {

                    final BiLeave tmpNewLeave = new BiLeave();
                    tmpNewLeave.setLevel(level);
                    tmpNewLeave.setValue(Integer.valueOf(numberArray[i]));

                    if (i == 0) {
                        lastList.get(0).setRightLeave(tmpNewLeave);
                    }

                    if (i > 0 && i < numberArray.length - 1) {
                        lastList.get(i).setRightLeave(tmpNewLeave);
                        lastList.get(i - 1).setLeftLeave(tmpNewLeave);
                    }

                    if (i >= numberArray.length - 1) {
                        lastList.get(lastList.size() - 1).setLeftLeave(tmpNewLeave);
                    }

                    tmpList.add(tmpNewLeave);
                }

                lastList.clear();
                lastList.addAll(tmpList);
            }

        } catch (final IOException e) {
            e.printStackTrace();
        }

        return root;
    }
}
