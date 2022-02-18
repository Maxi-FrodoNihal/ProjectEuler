package problems.p011TOp020.p018;

public class BiLeave {

	private BiLeave rightLeave = null;
	private BiLeave leftLeave = null;
	private int value;
	private int level;

	public BiLeave() {

	}

	public BiLeave getRightLeave() {
		return this.rightLeave;
	}

	public void setRightLeave(final BiLeave rightLeave) {
		this.rightLeave = rightLeave;
	}

	public BiLeave getLeftLeave() {
		return this.leftLeave;
	}

	public void setLeftLeave(final BiLeave leftLeave) {
		this.leftLeave = leftLeave;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(final int value) {
		this.value = value;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(final int level) {
		this.level = level;
	}

	@Override
	public String toString() {

		final String show = "" + this.value + "";

		return show;
	}
}
