package com.jad.bigint;

public class BigUnsignedInt {
    private Digit head;
    private Digit tail;

    public BigUnsignedInt() {
        this(new Digit((byte) 0));
    }

    public BigUnsignedInt(final Digit head) {
        this.head = head;
        this.tail = head;
    }

    public BigUnsignedInt(final String numberInString) {
        BigUnsignedInt i = stringToBigUnsignedInt(numberInString);
        if (i.getHead() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = i.getHead();
            this.tail = i.getTail();
        }
    }

    static BigUnsignedInt stringToBigUnsignedInt(String numberInString) {
        BigUnsignedInt bigUnsignedIntToReturn = new BigUnsignedInt();
        if (numberInString.equals("")) {
            return bigUnsignedIntToReturn;
        }

        char[] numberInCharArray = numberInString.toCharArray();
        Digit head = null;
        Digit temporaryDigit = null;
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
        if (head == null) {
            this.tail = null;
        } else {
            Digit temporaryDigit = this.head;
            while (temporaryDigit.getNext() != null) {
                temporaryDigit = temporaryDigit.getNext();
            }
            this.tail = temporaryDigit;
        }
    }

    public Digit getTail() {
        return tail;
    }

    public void setTail(final Digit tail) {
        this.tail = tail;
    }

    public void setNumber(String numberInString) {
        this.setHead(stringToBigUnsignedInt(numberInString).getHead());
    }

    @Override
    public String toString() {
        StringBuilder stringToReturn = new StringBuilder();
        Digit temporaryDigit = this.getHead();
        while (temporaryDigit != null) {
            stringToReturn.insert(0, temporaryDigit.getDigit());
            temporaryDigit = temporaryDigit.getNext();
        }
        return stringToReturn.toString();
    }

    public BigUnsignedInt add(BigUnsignedInt secondOperand) {
        BigUnsignedInt bigUnsignedIntToReturn = new BigUnsignedInt();
        Digit head = null;
        Digit temporaryDigit = null;
        Digit firstOperandDigit = this.getHead();
        Digit secondOperandDigit = secondOperand.getHead();
        byte carry = 0;

        while ((firstOperandDigit != null) || (secondOperandDigit != null)) {
            byte firstOperandDigitValue = 0;
            byte secondOperandDigitValue = 0;
            if (firstOperandDigit != null) {
                firstOperandDigitValue = firstOperandDigit.getDigit();
                firstOperandDigit = firstOperandDigit.getNext();
            }
            if (secondOperandDigit != null) {
                secondOperandDigitValue = secondOperandDigit.getDigit();
                secondOperandDigit = secondOperandDigit.getNext();
            }
            byte sum = (byte) (firstOperandDigitValue + secondOperandDigitValue + carry);
            carry = (byte) (sum / 10);
            sum = (byte) (sum % 10);
            if (head == null) {
                head = new Digit(sum);
                temporaryDigit = head;
            } else {
                temporaryDigit.setNext(new Digit(sum));
                temporaryDigit = temporaryDigit.getNext();
            }
        }
        if (carry != 0) {
            temporaryDigit.setNext(new Digit(carry));
        }
        bigUnsignedIntToReturn.setHead(head);
        return bigUnsignedIntToReturn;
    }

    public static int compare(BigUnsignedInt firstOperand, BigUnsignedInt secondOperand) {
        return 0;
    }
}
