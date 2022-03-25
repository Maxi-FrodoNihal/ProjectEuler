package problems.p041TOp050.p042;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import util.IProblem;

public class Problem42 implements IProblem {

	@Override
	public String getSolution() {
		return "162";
	}

	@Override
	public String solve() {

		List<Integer> triaglePool = getTriangleNumbers(1000);
		Map<String, Integer> dict = getDict();
		List<String> allWords = getAllWordsFromFile();
		int triagleSumCounter = 0;

		for (String word : allWords) {
			int wordSum = getSumFromWord(word, dict);
			if (containsNumber(triaglePool, wordSum)) {
				triagleSumCounter++;
			}
		}

		return String.valueOf(triagleSumCounter);
	}

	private int getSumFromWord(String word, Map<String, Integer> dict) {

		int sum = 0;

		for (int i = 0; i < word.length(); ++i) {
			String letter = word.substring(i, i + 1);
			sum += dict.get(letter.toUpperCase());
		}

		return sum;
	}

	private Map<String, Integer> getDict() {

		Map<String, Integer> dict = new HashMap<String, Integer>();
		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };

		for (int i = 0; i < letters.length; ++i) {
			dict.put(letters[i], i + 1);
		}

		return dict;
	}

	private boolean containsNumber(List<Integer> pool, int number) {
		return Collections.binarySearch(pool, number) >= 0;
	}

	private List<Integer> getTriangleNumbers(int border) {

		List<Integer> returnSet = new ArrayList<Integer>();

		for (int i = 1; i <= border; ++i) {
			returnSet.add(function(i));
		}

		return returnSet;
	}

	private int function(int n) {

		double dn = n;
		Double solution = ((dn / 2) * (dn + 1));
		return solution.intValue();
	}

	private List<String> getAllWordsFromFile() {

		List<String> allWords = new ArrayList<String>();

		try (BufferedReader bfr = new BufferedReader(
				new FileReader(new File(getClass().getResource("p042_words.txt").getFile())))) {

			while (bfr.ready()) {
				String oneLine = bfr.readLine();

				if (StringUtils.isNotBlank(oneLine)) {
					String[] someWords = oneLine.split(",", -1);
					Arrays.stream(someWords).forEach(tmpWord -> allWords.add(tmpWord.replace("\"", "")));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return allWords;
	}
}
