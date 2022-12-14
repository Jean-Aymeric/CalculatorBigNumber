package com.jad.bigint;

public class BigInt {
    private BigUnsignedInt bigUnsignedInt;
    private Sign sign;

    public BigInt() {
        this.sign = Sign.Plus;
        this.bigUnsignedInt = new BigUnsignedInt();
    }

    public BigInt(String numberInString) {
        this(BigInt.stringToBigInt(numberInString));
    }

    public BigInt(BigInt bi) {
        this.sign = bi.getSign();
        this.bigUnsignedInt = new BigUnsignedInt(bi.getBigUnsignedInt());
    }

    public static BigInt stringToBigInt(String numberInString) {
        BigInt bigIntToReturn = new BigInt();
        if (numberInString.equals("")) {
            bigIntToReturn.sign = Sign.Plus;
            bigIntToReturn.bigUnsignedInt = new BigUnsignedInt();
        } else {
            String buiInString = numberInString;
            if ((numberInString.toCharArray()[0] < '0') || (numberInString.toCharArray()[0] > '9')) {
                bigIntToReturn.sign = Sign.getSignFromChar(numberInString.toCharArray()[0]);
                buiInString = numberInString.substring(1);
            } else {
                bigIntToReturn.sign = Sign.Plus;
            }
            bigIntToReturn.bigUnsignedInt = BigUnsignedInt.stringToBigUnsignedInt(buiInString);
        }
        return bigIntToReturn;
    }

    @Override
    public String toString() {
        return this.getSign().toString() + this.getBigUnsignedInt().toString();
    }

    public Sign getSign() {
        return sign;
    }

    public BigUnsignedInt getBigUnsignedInt() {
        return bigUnsignedInt;
    }

    public int countDigits() {
        return 0;
    }

    public BigInt add(BigInt secondOperand) {
        // soit les deux Bi ont le même signe
        // alors le résultat sera de ce signe et o1.add(o2)
        // sinon on fait le plus grand - le plus petit et on met le signe en conséquence
        return new BigInt();
    }

    public BigInt subtract(BigInt secondOperand) {
        // soit les deux Bi ont le même signe
        // alors on fait le plus grand - le plus petit et on met le signe en conséquence
        // sinon le résultat sera de ce signe et o1.add(o2)
        return new BigInt();
    }
}
