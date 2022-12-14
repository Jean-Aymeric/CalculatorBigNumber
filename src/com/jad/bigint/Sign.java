package com.jad.bigint;

public enum Sign {
    Plus('+'), Minus('-');

    private char signInChar;

    Sign(char signInChar) {
        this.signInChar = signInChar;
    }

    @Override
    public String toString() {
        return String.valueOf(signInChar);
    }

    public static Sign getSignFromChar(char signInChar) {
        for (Sign sign : Sign.values()) {
            if (sign.is(signInChar)) {
                return sign;
            }
        }
        return Plus;
    }

    public boolean is(char signInChar) {
        return signInChar == this.signInChar;
    }
}
