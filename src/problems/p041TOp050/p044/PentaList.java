package problems.p041TOp050.p044;

import java.util.ArrayList;
import java.util.List;

public class PentaList {

	private List<Long> internList = new ArrayList<>();

	public PentaList(Long border) {
		fillList(1l, border);
	}

	private void fillList(Long start, Long border) {
		for (Long i = start; i <= border; ++i) {
			internList.add(function(i));
		}
	}

	private Long function(Long n) {
		return (n * (3l * n - 1l)) / 2l;
	}

	private Double deFunction(Long n) {
		return (1.0 / 6.0) * (Math.sqrt(24l * n + 1l) + 1l);
	}

	public boolean containsMath(Long number) {
		return deFunction(number) % 1 == 0;
	}

	public Long get(Long index) {

		if (index >= internList.size()) {
			fillList(internList.size() + 1l, index + 1l);
		}

		return internList.get(index.intValue());
	}
}
