package com.ajaykv.prac.ib.math;

import java.util.ArrayList;

/**
 * Created by ajaykv on 1/20/17.
 */
public class PrimeSum {
    public ArrayList<Integer> primesum(int a) {
        int firstPrime, secondPrime;
        int firstPrimeLimit = a/2;
        if(firstPrimeLimit <= 2) {
            firstPrime = 2;
            secondPrime = a-firstPrime;
            ArrayList<Integer> res = new ArrayList<>();
            res.add(firstPrime);
            res.add(secondPrime);
            return res;
        }
        return new ArrayList<>();
    }

}
