package problems.p021TOp030.p026;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.tuple.Triple;

import util.CList;
import util.ICListController;
import util.IProblem;

public class Problem26 implements
		ICListController<Triple<Integer, Integer, BigDecimal>, Callable<Triple<Integer, Integer, BigDecimal>>>,
		IProblem {

	private final int bigDecLenght = 10000;
	private BigDecimal actualBiDec = new BigDecimal(2);
	private int biggestMusterLenght = 0;
	private int biggestD = 0;
	private final int threadAmount = 8;

	@Override
	public String getSolution() {
		return "983";
	}

	@Override
	public String solve() {

		final CList<Triple<Integer, Integer, BigDecimal>, Callable<Triple<Integer, Integer, BigDecimal>>> clist = new CList<>(
				this.threadAmount, Executors.newCachedThreadPool(), this);

		try {
			clist.run();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return String.valueOf(this.biggestD);
	}

	@Override
	public Callable<Triple<Integer, Integer, BigDecimal>> getNext() {

		this.actualBiDec = this.actualBiDec.add(BigDecimal.ONE);

		return new BigDecCallable(BigDecimal.ONE.divide(this.actualBiDec, this.bigDecLenght, RoundingMode.HALF_UP));
	}

	@Override
	public void callbackValue(final Triple<Integer, Integer, BigDecimal> o) {

		if (o.getLeft() > this.biggestMusterLenght) {
//			System.out.println("Musterlänge: " + o.getLeft() + " Nenner: " + o.getMiddle());
			this.biggestD = o.getMiddle();
			this.biggestMusterLenght = o.getLeft();
		}
	}

	@Override
	public boolean continueCalculation() {
		return this.actualBiDec.compareTo(new BigDecimal("1000")) < 0;
	}
}
