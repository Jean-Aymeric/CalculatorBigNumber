package com.jad;

import com.jad.bigint.BigUnsignedInt;

public class Main {

    public static void main(String[] args) {
        BigUnsignedInt i = new BigUnsignedInt("121212121212121212");
        System.out.println(i);
        BigUnsignedInt j = new BigUnsignedInt("989898989898989898");
        System.out.println(j);
        BigUnsignedInt k = i.add(j);
        System.out.println(k);
    }
}
