package problems.p021TOp030.p027;

public class Formula {

	private int n = -1;
	private int a;
	private int b;

	public Formula(final int a, final int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getN() {
		return this.n;
	}

	public void setN(final int n) {
		this.n = n;
	}

	public int getA() {
		return this.a;
	}

	public void setA(final int a) {
		this.a = a;
	}

	public int getB() {
		return this.b;
	}

	public void setB(final int b) {
		this.b = b;
	}

	public int calculateNext() {
		++this.n;
		return this.n * this.n + this.a * this.n + this.b;
	}

	@Override
	public String toString() {
		return this.n + "² + " + this.a + " + " + this.n + " + " + this.b;
	}
}
