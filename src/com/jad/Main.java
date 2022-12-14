package com.jad;

import com.jad.bigint.BigUnsignedInt;

public class Main {

    public static void main(String[] args) {
        BigUnsignedInt i = new BigUnsignedInt("12");
        BigUnsignedInt j = new BigUnsignedInt("98");
        System.out.println(i.add(j));
    }
}
