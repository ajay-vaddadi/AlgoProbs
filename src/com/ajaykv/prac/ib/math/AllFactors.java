package com.ajaykv.prac.ib.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by ajaykv on 1/18/17.
 */
public class AllFactors {
    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        if(a>1) result.add(a);
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i == 0){
                result.add(i);
                if(a/i != i) result.add(a/i);
            }
        }
        Collections.sort(result);
        return result;
    }
}
