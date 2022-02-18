package problems.p031TOp040.p035;

import java.util.HashSet;
import java.util.Set;

import util.PrimProblem;

public class Problem35 extends PrimProblem {

	@Override
	public String solve() {

		int max = 1000000;

		// Prim Liste bis max erstellen.
		this.isPrim(max);
		Set<Integer> rotatePrimNumbers = new HashSet<Integer>();

		for (int i = 0; primNumbers.get(i) <= max; ++i) {

			int tmpPrim = primNumbers.get(i);

			boolean allArePrim = true;
			Set<Integer> rotatedNumbers = rotateAll(tmpPrim);

			for (Integer tmpRotateNumber : rotatedNumbers) {

				if (isPrim(tmpRotateNumber) == false) {
					allArePrim = false;
					break;
				}
			}

			if (allArePrim) {
				rotatePrimNumbers.add(tmpPrim);
			}
		}

		return String.valueOf(rotatePrimNumbers.size());
	}

	private Set<Integer> rotateAll(int number) {

		Set<Integer> rotateSet = new HashSet<Integer>();
		rotateSet.add(number);

		if (number > 9) {
			String rotateNumber = String.valueOf(number);

			do {
				rotateNumber = rotate(rotateNumber);
				rotateSet.add(Integer.parseInt(rotateNumber));
			} while (rotateNumber.equals(String.valueOf(number)) == false);
		}

		return rotateSet;
	}

	private String rotate(String number) {

		String numberAsString = String.valueOf(number);
		String firstDigit = numberAsString.substring(0, 1);
		numberAsString = numberAsString.substring(1, numberAsString.length()) + firstDigit;

		return numberAsString;
	}
}
