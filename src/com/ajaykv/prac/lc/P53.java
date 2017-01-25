package com.ajaykv.prac.lc;

/**
 * Created by ajaykv on 1/6/17.
 */
public class P53 {
    public int maxSubArray(int[] a) {
        if (a==null || a.length == 0) return 0;
        int uberMax = 0, tempMax =0, uberMaxUnderZero = Integer.MIN_VALUE;
        boolean allNegative = true;
        for (int i = 0; i < a.length ; i++) {
            if (a[i] >= 0) allNegative = false;
            tempMax = tempMax + a[i];
            if (tempMax<0 && uberMaxUnderZero < tempMax) uberMaxUnderZero = tempMax;
            if (tempMax<0) tempMax = 0;
            if (uberMax < tempMax) uberMax = tempMax;
        }
        return allNegative ? uberMaxUnderZero:uberMax;
    }
}
