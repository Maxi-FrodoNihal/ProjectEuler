package util;

import java.util.ArrayList;
import java.util.List;

public class Permutor {

	public <T> List<List<T>> permute(List<T> source) {

		List<List<T>> perList = new ArrayList<List<T>>();
		permute(source, 0, perList);
		return perList;
	}

	private <T> void permute(List<T> arr, int k, List<List<T>> perList) {
		for (int i = k; i < arr.size(); i++) {
			java.util.Collections.swap(arr, i, k);
			permute(arr, k + 1, perList);
			java.util.Collections.swap(arr, k, i);
		}
		if (k == arr.size() - 1) {
			perList.add(new ArrayList<T>(arr));
		}
	}
}
