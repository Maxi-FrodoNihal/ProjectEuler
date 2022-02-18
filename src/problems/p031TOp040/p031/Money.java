package problems.p031TOp040.p031;

public enum Money {

	OnePenny(1), TwoPennys(2), FivePennys(5), TenPennys(10), TwentyPennys(20), FiftyPennys(50), OnePound(100),
	TwoPounds(200);

	private int pennys;

	Money(final int pennys) {
		this.pennys = pennys;
	}

	public int getPennys() {
		return this.pennys;
	}
}
