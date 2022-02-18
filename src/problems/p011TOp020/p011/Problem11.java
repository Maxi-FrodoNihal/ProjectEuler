package problems.p011TOp020.p011;

import java.util.Arrays;

import util.IProblem;

public class Problem11 implements IProblem {

	@Override
	public String solve() {

		// Die Lösung die hier ausgerechnet wird ist falsch
		final UsedField[][] matrix = this.generateMatrix();

		final int leftToRight = this.leftToRight(matrix);
		final int upToDown = this.upToDown(matrix);
		final int diagonal = this.diagonal(matrix);
		final int diagonalInvert = this.diagonalInvert(matrix);

		final int[] sortArray = new int[4];
		sortArray[0] = leftToRight;
		sortArray[1] = upToDown;
		sortArray[2] = diagonal;
		sortArray[3] = diagonalInvert;

		Arrays.sort(sortArray);

		return String.valueOf(sortArray[3]);

	}

	private UsedField[][] generateMatrix() {

		final UsedField[] zeile01 = this.generateStringArrayToIntArray(
				"08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08".split(" "));
		final UsedField[] zeile02 = this.generateStringArrayToIntArray(
				"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00".split(" "));
		final UsedField[] zeile03 = this.generateStringArrayToIntArray(
				"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65".split(" "));
		final UsedField[] zeile04 = this.generateStringArrayToIntArray(
				"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91".split(" "));
		final UsedField[] zeile05 = this.generateStringArrayToIntArray(
				"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80".split(" "));
		final UsedField[] zeile06 = this.generateStringArrayToIntArray(
				"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50".split(" "));
		final UsedField[] zeile07 = this.generateStringArrayToIntArray(
				"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70".split(" "));
		final UsedField[] zeile08 = this.generateStringArrayToIntArray(
				"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21".split(" "));
		final UsedField[] zeile09 = this.generateStringArrayToIntArray(
				"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72".split(" "));
		final UsedField[] zeile10 = this.generateStringArrayToIntArray(
				"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95".split(" "));
		final UsedField[] zeile11 = this.generateStringArrayToIntArray(
				"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92".split(" "));
		final UsedField[] zeile12 = this.generateStringArrayToIntArray(
				"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57".split(" "));
		final UsedField[] zeile13 = this.generateStringArrayToIntArray(
				"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58".split(" "));
		final UsedField[] zeile14 = this.generateStringArrayToIntArray(
				"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40".split(" "));
		final UsedField[] zeile15 = this.generateStringArrayToIntArray(
				"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66".split(" "));
		final UsedField[] zeile16 = this.generateStringArrayToIntArray(
				"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69".split(" "));
		final UsedField[] zeile17 = this.generateStringArrayToIntArray(
				"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36".split(" "));
		final UsedField[] zeile18 = this.generateStringArrayToIntArray(
				"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16".split(" "));
		final UsedField[] zeile19 = this.generateStringArrayToIntArray(
				"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54".split(" "));
		final UsedField[] zeile20 = this.generateStringArrayToIntArray(
				"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48".split(" "));

		final UsedField[][] matrix = new UsedField[20][20];
		matrix[0] = zeile01;
		matrix[1] = zeile02;
		matrix[2] = zeile03;
		matrix[3] = zeile04;
		matrix[4] = zeile05;
		matrix[5] = zeile06;
		matrix[6] = zeile07;
		matrix[7] = zeile08;
		matrix[8] = zeile09;
		matrix[9] = zeile10;
		matrix[10] = zeile11;
		matrix[11] = zeile12;
		matrix[12] = zeile13;
		matrix[13] = zeile14;
		matrix[14] = zeile15;
		matrix[15] = zeile16;
		matrix[16] = zeile17;
		matrix[17] = zeile18;
		matrix[18] = zeile19;
		matrix[19] = zeile20;

		return matrix;
	}

	// private void showUsedFields(final UsedField[][] matrix) {
	//
	// for (int i = 0; i < matrix.length; ++i) {
	// for (int j = 0; j < matrix[i].length; ++j) {
	//
	// final int accessAmount = matrix[i][j].getAccessAmount();
	//
	// if (accessAmount < 10) {
	// System.out.print("0" + accessAmount + " ");
	// } else {
	// System.out.print(accessAmount + " ");
	// }
	// }
	//
	// System.out.println();
	// }
	// }

	private UsedField[] generateStringArrayToIntArray(final String[] stringArray) {

		final UsedField[] array = new UsedField[stringArray.length];

		for (int i = 0; i < array.length; ++i) {
			array[i] = new UsedField(Integer.parseInt(stringArray[i]));
		}

		return array;
	}

	private int leftToRight(final UsedField[][] matrix) {

		int biggestValue = 0;

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length - 3; ++j) {

				final int zahl1 = matrix[i][j].getValue();
				final int zahl2 = matrix[i][j + 1].getValue();
				final int zahl3 = matrix[i][j + 2].getValue();
				final int zahl4 = matrix[i][j + 3].getValue();

				final int tmpProduct = zahl1 * zahl2 * zahl3 * zahl4;
				if (tmpProduct > biggestValue) {
					biggestValue = tmpProduct;
				}
			}
		}

		return biggestValue;
	}

	private int upToDown(final UsedField[][] matrix) {

		int biggestValue = 0;

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length - 3; ++j) {

				final int zahl1 = matrix[j][i].getValue();
				final int zahl2 = matrix[j + 1][i].getValue();
				final int zahl3 = matrix[j + 2][i].getValue();
				final int zahl4 = matrix[j + 3][i].getValue();

				final int tmpProduct = zahl1 * zahl2 * zahl3 * zahl4;
				if (tmpProduct > biggestValue) {
					biggestValue = tmpProduct;
				}
			}
		}

		return biggestValue;
	}

	private int diagonal(final UsedField[][] matrix) {

		int biggestValue = 0;

		for (int i = 0; i < matrix.length - 3; ++i) {
			for (int j = 0; j < matrix[i].length - 3; ++j) {

				final int zahl1 = matrix[i][j].getValue();
				final int zahl2 = matrix[i + 1][j + 1].getValue();
				final int zahl3 = matrix[i + 2][j + 2].getValue();
				final int zahl4 = matrix[i + 3][j + 3].getValue();

				final int tmpProduct = zahl1 * zahl2 * zahl3 * zahl4;
				if (tmpProduct > biggestValue) {
					biggestValue = tmpProduct;
				}
			}
		}

		return biggestValue;
	}

	private int diagonalInvert(final UsedField[][] matrix) {

		int biggestValue = 0;

		for (int i = 0; i < matrix.length - 3; ++i) {
			for (int j = matrix[i].length - 1; j >= 3; --j) {

				final int zahl1 = matrix[i][j].getValue();
				final int zahl2 = matrix[i + 1][j - 1].getValue();
				final int zahl3 = matrix[i + 2][j - 2].getValue();
				final int zahl4 = matrix[i + 3][j - 3].getValue();

				final int tmpProduct = zahl1 * zahl2 * zahl3 * zahl4;
				if (tmpProduct > biggestValue) {
					biggestValue = tmpProduct;
				}
			}
		}

		return biggestValue;
	}
}
