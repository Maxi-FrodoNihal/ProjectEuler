package problems.p041TOp050.p044;

import java.util.ArrayList;
import java.util.List;

public class PentaList {

	private List<Long> internList = new ArrayList<>();

	public PentaList(Integer border) {
		fillListBorder(1, border);
	}

	private void fillListBorder(Integer start, Integer border) {

		Double deFunctionVal = deFunction(border.longValue());
		Integer indexVal = deFunctionVal.intValue() + 1;

		fillListIndex(start.longValue(), indexVal.longValue());
	}

	private void fillListIndex(Long start, Long borderIndex) {
		for (Long i = start; i <= borderIndex; ++i) {
			internList.add(function(i));
		}
	}

	public static Long function(Long n) {
		return (n * (3l * n - 1l)) / 2l;
	}

	public static Double deFunction(Long n) {
		return (1.0 / 6.0) * (Math.sqrt(24l * n + 1l) + 1l);
	}

	public boolean containsMath(Long number) {
		return deFunction(number) % 1 == 0;
	}

	public Long get(Long index) {

		if (index >= internList.size()) {
			fillListIndex(internList.size() + 1l, index + 1l);
		}

		return internList.get(index.intValue());
	}
}
