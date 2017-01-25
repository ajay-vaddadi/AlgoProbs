package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 FindPermutation fp = new FindPermutation();
 System.out.println(fp.findPerm("I",2));
 */
public class FindPermutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        if(A == null || B == 0 || B-A.length() != 1) return new ArrayList<>();
        int min = 1;
        int max = B;
        ArrayList<Integer> result = new ArrayList<>(B);
        for (int i = 0; i < A.length() ; i++) {
            if(A.charAt(i) == 'I'){
                result.add(min);
                min++;
            }
            if(A.charAt(i) == 'D'){
                result.add(max);
                max--;
            }
        }
        result.add(min);
        return result;
    }
}
