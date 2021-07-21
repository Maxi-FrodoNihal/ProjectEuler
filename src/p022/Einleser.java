package p022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Einleser {

    private final File readFile = new File("C:\\hsh\\eclipse\\workspace_oxygen2\\ProjectEuler\\src\\p022\\p022_names.txt");

    public List<String> readNames() {

        final List<String> nameList = new ArrayList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader(this.readFile))) {

            String lineString = bfr.readLine();
            lineString = lineString.substring(1, lineString.length() - 1);

            nameList.addAll(Arrays.asList(lineString.split("\",\"", -1)));

        } catch (final IOException e) {
            e.printStackTrace();
        }

        return nameList;
    }
}
