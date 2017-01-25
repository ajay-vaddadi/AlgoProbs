package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ajaykv on 1/11/17.
 */
public class MaxUnsortedSubArr {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int unsortedStart = 0;
        int unsortedEnd = A.size()-1;
        int max1 = 0;

        for (int i = 0; i < A.size(); i++) {
            if(A.get(i) >= max1){
                max1 = A.get(i);
            }else{
                unsortedStart = i-1;
                break;
            }
        }

        int maxIndex = 0;
        int maxValTillNow = A.get(0);

        for (int i = 0; i < A.size() ; i++) {
            if(A.get(i) >= maxValTillNow){

            }

        }

        Integer[] a = {unsortedStart,unsortedEnd};
        return new ArrayList<>(Arrays.asList(a));
    }
}
