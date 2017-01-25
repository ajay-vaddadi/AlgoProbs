package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 Integer[] a = {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0};
 ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(a));
 Integer[] b = {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0};
 ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(b));
 Integer[] c ={1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1};
 ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(c));

 ArrayList<ArrayList<Integer>> xarr = new ArrayList<>();
 xarr.add(a1);
 xarr.add(a2);
 xarr.add(a3);

 for(ArrayList<Integer> aa : xarr){
 System.out.println(aa);
 }

 SetMatrixZeros smz = new SetMatrixZeros();
 smz.setZeroes(xarr);

 System.out.println("Solution");
 for(ArrayList<Integer> aa : xarr){
 System.out.println(aa);
 }


 */
public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        if( a == null || a.size() == 0) return;

        int m = a.get(0).size();
        ArrayList<Integer> rowsToSwitch = new ArrayList<>();
        ArrayList<Integer> colsToSwitch = new ArrayList<>();
        boolean foundZero = false;
        for (int i = 0; i < a.size() ; i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if(a.get(i).get(j) == 0) {
                    foundZero = true;
                    colsToSwitch.add(j);
                }
            }
            if(foundZero){
                rowsToSwitch.add(i);
            }
            foundZero = false;
        }

        ArrayList<Integer> constZeroRow = new ArrayList<>();
        ArrayList<Integer> constNonZeroRow = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            constZeroRow.add(0);
            constNonZeroRow.add(1);
        }

        for (int i = 0,k = colsToSwitch.size(); i < k ; i++) {
            constNonZeroRow.set(colsToSwitch.get(i),0);

        }

        int k = 0;
        for (int i = 0; i < a.size() ; i++) {
            if (k < rowsToSwitch.size() && rowsToSwitch.get(k) == i){
                a.set(i,constZeroRow);
                k++;
            } else {
                a.set(i,constNonZeroRow);
            }
        }
    }
}
