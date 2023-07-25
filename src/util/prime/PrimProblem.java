package util.prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import util.IProblem;

public abstract class PrimProblem implements IProblem {

	protected List<Integer> primNumbers = new ArrayList<>();
	private int jumpRange = 100;


	protected boolean isPrim(int number) {

		number = Math.abs(number);

		if (CollectionUtils.isEmpty(this.primNumbers) || this.primNumbers.get(this.primNumbers.size() - 1) < number) {
			primNumbers = this.sieveOfAtkin(number);
		}

		return Collections.binarySearch(this.primNumbers, number) >= 0;
	}

	protected int getOrCalculate(int index) {

		if (index < primNumbers.size()) {
			return primNumbers.get(index);
		} else {

			if (CollectionUtils.isEmpty(primNumbers)) {
				isPrim(jumpRange);
				return getOrCalculate(index);
			} else {

				int pNumberSizeBefore = primNumbers.size();
				isPrim(primNumbers.get(primNumbers.size() - 1) + jumpRange);
				int pNumberSizeAfter = primNumbers.size();

				if (pNumberSizeBefore == pNumberSizeAfter) {
					jumpRange = jumpRange * 2;
				}

				return getOrCalculate(index);
			}
		}
	}

	public List<Integer> sieveOfAtkin(int limit) {

		List<Integer> primList = new ArrayList<>();
		boolean[] sieve = new boolean[limit + 1];
		int limitSqrt = (int) Math.sqrt(limit);

		Arrays.fill(sieve, false);

		sieve[0] = false;
		sieve[1] = false;
		sieve[2] = true;
		sieve[3] = true;

		for (int x = 1; x <= limitSqrt; x++) {
			for (int y = 1; y <= limitSqrt; y++) {
				int n = (4 * x * x) + (y * y);
				if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
					sieve[n] = !sieve[n];
				}
				n = (3 * x * x) + (y * y);
				if (n <= limit && (n % 12 == 7)) {
					sieve[n] = !sieve[n];
				}
				n = (3 * x * x) - (y * y);
				if (x > y && n <= limit && (n % 12 == 11)) {
					sieve[n] = !sieve[n];
				}
			}
		}

		for (int n = 5; n <= limitSqrt; n++) {
			if (sieve[n]) {
				int x = n * n;
				for (int i = x; i <= limit; i += x) {
					sieve[i] = false;
				}
			}
		}

		for (int i = 0; i <= limit; i++) {
			if (sieve[i]) {
				primList.add(i);
			}
		}

		return primList;
	}

	public boolean simpleFastIsPrim(int n){
		if(n < 2) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;

		var m = 3;
		while (m < Math.sqrt(n) + 1) {
			if (n % m == 0) return false;
			m += 2;
		}

		return true;
	}
}
