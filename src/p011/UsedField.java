package p011;

public class UsedField {

    private final int value;
    private int accessAmount = 0;

    public UsedField(final int value) {
        super();
        this.value = value;
    }

    public int getValue() {
        ++this.accessAmount;
        return this.value;
    }

    public int getAccessAmount() {
        return this.accessAmount;
    }
}
