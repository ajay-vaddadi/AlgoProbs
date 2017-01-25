package com.ajaykv.prac.ib.math;

/**
 * Created by ajaykv on 1/18/17.
 */
public class IsPrime {
    public int isPrime(int a) {
        if(a>1 && a<=3) return 1;
        System.out.println(Math.sqrt(a));
        for (int i = 2 ; i <= Math.sqrt(a) ; i++) {
            System.out.println(i);
            if(a%i == 0) return 0;
        }
        return 1;
    }
}
