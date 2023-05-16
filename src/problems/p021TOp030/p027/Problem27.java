package problems.p021TOp030.p027;

import util.prime.PrimProblem;

public class Problem27 extends PrimProblem {

	@Override
	public String getSolution() {
		return "-59231";
	}

	@Override
	public String solve() {

		int globalPrimSequenceNumber = 0;
		Formula globalFormular = null;

		for (int a = -999; a < 1000; ++a) {
			for (int b = -1000; b <= 1000; ++b) {

				final Formula tmpFormular = new Formula(a, b);

				final int sequenceNumber = this.getSequenceOfPrim(tmpFormular);
				if (globalPrimSequenceNumber < sequenceNumber) {
					globalFormular = tmpFormular;
					globalPrimSequenceNumber = sequenceNumber;
				}
			}
		}

		return String.valueOf(globalFormular.getA() * globalFormular.getB());
	}

	private int getSequenceOfPrim(final Formula f) {

		int mayBePrim = 0;
		int counter = -1;

		do {
			++counter;
			mayBePrim = f.calculateNext();

		} while (this.isPrim(mayBePrim));

		return counter;
	}
}
