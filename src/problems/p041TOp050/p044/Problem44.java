package problems.p041TOp050.p044;

import util.IProblem;

public class Problem44 implements IProblem {

	@Override
	public String getSolution() {
		return "5482660";
	}

	@Override
	public String solve() {

		Integer border = 2167;
		Long D = 0l;

		PentaList pentaList = new PentaList(border);

		for (Long j = 0l; j < border && D == 0l; ++j) {

			Long pj = pentaList.get(j);

			for (Long k = j + 1; k < border && D == 0l; ++k) {

				Long pk = pentaList.get(k);

				if (pentaList.containsMath(pk - pj) && pentaList.containsMath(pj + pk)) {
					D = pk - pj;
				}
			}
		}

		return String.valueOf(D);
	}
}
