package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ajaykv on 1/11/17.
 */
public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        if(a == null || a.size() == 0) return new ArrayList<>();
        Collections.sort(a);
        //0 1 2 3 4 5
        //1 2 3 4 5 6
        for (int i = 0; i < a.size()-1 ;i = i+2) {
            int tmp = a.get(i);
            a.set(i,a.get(i+1));
            a.set(i+1, tmp);
        }
        return a;
    }
}
