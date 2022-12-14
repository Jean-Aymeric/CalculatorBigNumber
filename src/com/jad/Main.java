package com.jad;

import com.jad.bigint.BigInt;
import com.jad.bigint.BigUnsignedInt;

public class Main {

    public static void main(String[] args) {
        BigInt i = new BigInt("1234567890123456789012345678901234567890");
        System.out.println(i);
        BigInt j = new BigInt("-987654321098765432109876543210987654321");
        System.out.println(j);
    }
}
