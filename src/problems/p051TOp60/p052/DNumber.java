package problems.p051TOp60.p052;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DNumber {

	private int number;
	private Set<String> digits;

	public DNumber(int number) {
		this.number = number;
		digits = Arrays.stream(String.valueOf(number).split("")).collect(Collectors.toSet());
	}

	public int getNumber() {
		return number;
	}

	public Set<String> getDigits() {
		return digits;
	}
}
