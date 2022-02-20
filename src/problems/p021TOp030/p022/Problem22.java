package problems.p021TOp030.p022;

import java.util.Collections;
import java.util.List;

import util.IProblem;

public class Problem22 implements IProblem {

	@Override
	public String getSolution() {
		return "871198282";
	}

	@Override
	public String solve() {

		int resultSum = 0;
		final Einleser einleser = new Einleser();
		final List<String> readNames = einleser.readNames();

		Collections.sort(readNames);

		for (int i = 0; i < readNames.size(); ++i) {
			resultSum += this.getNameScore(readNames.get(i)) * (i + 1);
		}

		return String.valueOf(resultSum);
	}

	private int getNameScore(final String name) {

		int score = 0;
		final String[] letters = name.split("");

		for (final String letter : letters) {
			score += this.getLetterScore(letter);
		}

		return score;
	}

	private int getLetterScore(final String letter) {

		int score = 0;

		switch (letter) {
		case "A":
			score = 1;
			break;
		case "B":
			score = 2;
			break;
		case "C":
			score = 3;
			break;
		case "D":
			score = 4;
			break;
		case "E":
			score = 5;
			break;
		case "F":
			score = 6;
			break;
		case "G":
			score = 7;
			break;
		case "H":
			score = 8;
			break;
		case "I":
			score = 9;
			break;
		case "J":
			score = 10;
			break;
		case "K":
			score = 11;
			break;
		case "L":
			score = 12;
			break;
		case "M":
			score = 13;
			break;
		case "N":
			score = 14;
			break;
		case "O":
			score = 15;
			break;
		case "P":
			score = 16;
			break;
		case "Q":
			score = 17;
			break;
		case "R":
			score = 18;
			break;
		case "S":
			score = 19;
			break;
		case "T":
			score = 20;
			break;
		case "U":
			score = 21;
			break;
		case "V":
			score = 22;
			break;
		case "W":
			score = 23;
			break;
		case "X":
			score = 24;
			break;
		case "Y":
			score = 25;
			break;
		case "Z":
			score = 26;
			break;
		default:
			score = -1;
			break;
		}

		return score;
	}
}
