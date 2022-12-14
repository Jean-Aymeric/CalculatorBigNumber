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
        if (i.getHead() == null) {
            this.head = null;
        } else {
            this.head = i.getHead();
        }
    }

    static BigUnsignedInt stringToBigUnsignedInt(String numberInString) {
        BigUnsignedInt bigUnsignedIntToReturn = new BigUnsignedInt();
        if (numberInString.equals("")) {
            return bigUnsignedIntToReturn;
        }

        char[] numberInCharArray = numberInString.toCharArray();
        Digit head =  null;
        Digit temporaryDigit =  null;
        for (int i = numberInString.length() - 1; i >= 0; i--) {
            if ((numberInCharArray[i] < '0') || (numberInCharArray[i] > '9')) {
                return new BigUnsignedInt();
            }
            Digit digit = new Digit((byte) (numberInCharArray[i] - '0'));
            if (head == null) {
                head = digit;
            } else {
                temporaryDigit.setNext(digit);
            }
            temporaryDigit = digit;
        }
        bigUnsignedIntToReturn.setHead(head);
        return bigUnsignedIntToReturn;
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
