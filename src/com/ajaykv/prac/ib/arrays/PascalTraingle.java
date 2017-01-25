package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 * Created by ajaykv on 1/7/17.
 */
public class PascalTraingle {
    public ArrayList<Integer> getRow(int a) {
        a = a+1;
        ArrayList<Integer> row = new ArrayList<>(a);
        row.add(1);
        for (int i = 1; i < a; i++) {
            row.add(0);
        }
        for (int i = 1; i < row.size(); i++) {
            for (int j = row.size()-1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
        }
}
