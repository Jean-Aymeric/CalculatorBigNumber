package com.jad.bigint;

public class Digit {

    private byte digit;
    private Digit next;
    private Digit previous;

    public Digit(final byte digit) {
        this.digit = digit;
        this.next = null;
        this.previous = null;
    }

    public Digit(Digit d) {
        if (d == null) {
            this.digit = 0;
            this.next = null;
            this.previous = null;
        } else {
            this.digit = d.getDigit();
            this.next = null;
            this.previous = null;
        }
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
            if (next != null) {
                next.setPrevious(this);
            }
        }
    }

    public Digit getPrevious() {
        return previous;
    }

    public void setPrevious(final Digit previous) {
        this.previous = previous;
        if ((this.getPrevious() != null) && (this.getPrevious().getNext() != this)) {
            this.getPrevious().setNext(this);
        }
    }
}
