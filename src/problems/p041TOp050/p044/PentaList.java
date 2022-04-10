package problems.p041TOp050.p044;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PentaList {

	private List<Integer> internList = new ArrayList<>();

	public PentaList() {
		fillList(1, 1000);
	}

	public PentaList(int border) {
		fillList(1, border);
	}

	private void fillList(int start, int border) {
		for (int i = start; i <= border; ++i) {
			internList.add(function(i));
		}
	}

	private int function(int n) {
		return (n * (3 * n - 1)) / 2;
	}

	private Double deFunction(int n) {
		return (1.0 / 6.0) * (Math.sqrt(24 * n + 1) + 1);
	}

	public boolean containsMath(int number) {
		return deFunction(number) % 1 == 0;
	}

	public boolean containsList(int number) {
		return Collections.binarySearch(internList, number) >= 0;
	}

	public boolean containsFill(int number) {

		if (containsMath(number) && containsList(number) == false) {
			fillList(internList.size() + 1, deFunction(number).intValue());
			return true;
		} else {
			return false;
		}
	}

	public Integer get(int index) {

		if (index >= internList.size()) {
			fillList(internList.size() + 1, index + 1);
		}

		return internList.get(index);
	}

	public List<Integer> getInternList() {
		return internList;
	}
}
