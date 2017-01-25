package com.ajaykv.prac.ib.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajaykv on 1/6/17.
 */
public class RepeatAndMissing {

    //Mutation Solution
    public ArrayList<Integer> repeatedNumberMutated(List<Integer> a) {
        if(a == null || a.size() == 0) return null;
        ArrayList<Integer> repeatingAndMissing = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int val = a.get(i);
            if (val < 0) val = val*-1;
            if (a.get(val-1) < 0) {
                repeatingAndMissing.add(val);
            } else {
                a.set(val-1,-1*a.get(val-1));
            }
        }

        for (int i = 0; i < a.size() ; i++) {
            if(a.get(i) > 0) repeatingAndMissing.add(i+1);

        }
        return repeatingAndMissing;
    }

    //Non Mutation solution ....
    // if 'x' is the repeated number, 'y' missing number ..
    // y-x = (sum of first n numbers - sum of elements in array)
    // y/x = (n!)/product of all elements in an array)


}
