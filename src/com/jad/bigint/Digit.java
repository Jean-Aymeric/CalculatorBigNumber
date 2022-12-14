package com.jad.bigint;

public class Digit {

    private byte digit;
    private Digit next;

    public Digit(final byte digit) {
        this.digit = digit;
        this.next = null;
    }

    public byte getDigit() {
        return digit;
    }

    public void setDigit(final byte digit) {
        this.digit = digit;
    }

    public Digit getNext() {
        return next;
    }

    public void setNext(final Digit next) {
        if (next != this) {
            this.next = next;
        }
    }
}
