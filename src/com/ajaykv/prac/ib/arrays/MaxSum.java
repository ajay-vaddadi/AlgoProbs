package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajaykv on 1/6/17.
 */
public class MaxSum {
    public int maxSubArray(final List<Integer> a) {
        if (a==null || a.size() == 0) return 0;
        int uberMax = 0, tempMax =0, uberMaxUnderZero = Integer.MIN_VALUE;
        boolean allNegative = true;
        for (int i = 0; i < a.size() ; i++) {
            if (a.get(i) >= 0) allNegative = false;
            tempMax = tempMax + a.get(i);
            if (tempMax<0 && uberMaxUnderZero < tempMax) uberMaxUnderZero = tempMax;
            if (tempMax<0) tempMax = 0;
            if (uberMax < tempMax) uberMax = tempMax;
        }
        return allNegative ? uberMaxUnderZero:uberMax;
    }
}
