package p011TOp020.p013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import util.IProblem;

public class Problem13 implements IProblem {

	private List<BigInteger> prepareBigNumberList() {

		final List<BigInteger> bigNumberList = new ArrayList<>();

		try (BufferedReader bfr = new BufferedReader(new FileReader(new File(
				"C:\\Users\\frodo\\Desktop\\Anwendungen\\workspace\\ProjectEuler\\src\\p011TOp020\\p013\\bigNumbers.txt")))) {

			while (bfr.ready()) {
				bigNumberList.add(new BigInteger(bfr.readLine()));
			}

		} catch (final IOException e) {
			e.printStackTrace();
		}

		return bigNumberList;
	}

	@Override
	public String solve() {

		final List<BigInteger> bigNumberList = this.prepareBigNumberList();

		BigInteger sumBigInt = BigInteger.ZERO;

		for (final BigInteger tmpBigInt : bigNumberList) {
			sumBigInt = sumBigInt.add(tmpBigInt);
		}

		final String firstTenDigis = sumBigInt.toString().substring(0, 10);

		return firstTenDigis;
	}
}
