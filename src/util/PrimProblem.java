package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public abstract class PrimProblem implements IProblem {

	protected List<Integer> primNumbers = new ArrayList<>();

	protected boolean isPrim(int number) {

		number = Math.abs(number);

		if (CollectionUtils.isEmpty(this.primNumbers) || this.primNumbers.get(this.primNumbers.size() - 1) < number) {

			primNumbers = sieveOfAtkin(number);
		}

		return Collections.binarySearch(this.primNumbers, number) >= 0;
	}

	protected int getOrCalculate(int index) {

		if (index < primNumbers.size()) {
			return primNumbers.get(index);
		} else {

			isPrim(primNumbers.get(primNumbers.size() - 1) + 100);
			getOrCalculate(index);
		}

		return -1;
	}

	/**
	 * Selbstgeschriebene Version vom Sieb des Eratosthenes. Ist nicht super
	 * schnell, macht aber seinen Job.
	 * 
	 * @param border   Bis wohin sollen Primzahlen gesucht werden?
	 * @param primList Die Liste an schon gefundenen Primzahlen. Welche erweitert
	 *                 und wieder zurück gegeben wird.
	 * @return Die vervollständigte Liste an Primzahlen bis zur Parametergrenze.
	 */
	private List<Integer> eratosthenes(final int border, List<Integer> primList) {

		int actualNumber = 6;

		if (CollectionUtils.isEmpty(primList)) {
			primList.add(2);
			primList.add(3);
			primList.add(5);
		} else {
			actualNumber = primList.get(primList.size() - 1);
		}

		while (primList.get(primList.size() - 1) < border) {

			int counter = 0;

			for (final Integer primNumber : primList) {

				if (actualNumber % primNumber != 0) {
					counter++;
				} else {
					break;
				}
			}

			if (counter == primList.size()) {
				primList.add(actualNumber);
			}

			actualNumber++;
		}

		return primList;
	}

	/**
	 * Diesen Algo zum Primzahlen bestimmen hab ich aus dem Internet kopiert und
	 * angepasst. Er läuft schneller als mein selbstgeschriebener Algo.
	 * 
	 * @param border   Bis wohin sollen Primzahlen gesucht werden?
	 * @param primList Die Liste an schon gefundenen Primzahlen. Welche erweitert
	 *                 und wieder zurück gegeben wird.
	 * @return Die vervollständigte Liste an Primzahlen bis zur Parametergrenze.
	 */
	public List<Integer> sieveOfAtkin(int border) {

		List<Integer> primList = new ArrayList<>();
		int limit = border;
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
}
