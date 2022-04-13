package problems.p041TOp050.p044;

import util.IProblem;

public class Problem44 implements IProblem {

	@Override
	public String solve() {

		boolean breakVal = true;
		Long border = 2200l;
		Long D = 0l;

		PentaList pentaList = new PentaList(border);

		for (Long j = 0l; j < border && breakVal; ++j) {

			Long pj = pentaList.get(j);

			for (Long k = j + 1; k < border && breakVal; ++k) {

				Long pk = pentaList.get(k);

				Long sumP = pj + pk;
				Long subP = pk - pj;

				if (pentaList.containsMath(subP) && pentaList.containsMath(sumP)) {
					D = pk - pj;
					breakVal = false;
				}
			}
		}

		return String.valueOf(D);
	}
}
