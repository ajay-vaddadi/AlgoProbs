package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 * Created by ajaykv on 1/7/17.
 */
public class PascalTraingleRows {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        if(a == 0) return finalList;
        ArrayList<Integer> row = new ArrayList<>(a);
        row.add(1);
        ArrayList<Integer> wtf = new ArrayList<>(row);
        finalList.add(wtf);
        for (int i = 2; i <= a; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(row);
            tmp.add(0);
            tmp = pascalRow(tmp);
            finalList.add(tmp);
            row = tmp;
        }
        return finalList;
    }

    private ArrayList<Integer> pascalRow(ArrayList<Integer> previousRow){
        for (int j = previousRow.size()-1; j >= 1; j--) {
            previousRow.set(j, previousRow.get(j) + previousRow.get(j - 1));
        }
        return previousRow;
    }
}
