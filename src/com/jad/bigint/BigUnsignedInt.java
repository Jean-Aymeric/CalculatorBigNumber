package com.jad.bigint;

public class BigUnsignedInt {
    private Digit head;

    public BigUnsignedInt() {
        this(new Digit((byte) 0));
    }

    public BigUnsignedInt(final Digit head) {
        this.head = head;
    }

    public BigUnsignedInt(final String numberInString) {
        BigUnsignedInt i = stringToBigUnsignedInt(numberInString);
        if (i == null) {
            this.head = null;
        } else {
            this.head = i.getHead();
        }
    }

    static BigUnsignedInt stringToBigUnsignedInt(String numberInString) {
        return null;
    }

    protected Digit getHead() {
        return head;
    }

    protected void setHead(final Digit head) {
        this.head = head;
    }

    public void setNumber(String numberInString) {
        this.setHead(stringToBigUnsignedInt(numberInString).getHead());
    }

    @Override
    public String toString() {
        return "";
    }
}
