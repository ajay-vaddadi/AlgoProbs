package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 * Created by ajaykv on 1/7/17.
 */
/**
 Runner --
 ArrayList<Integer> a1 = new ArrayList<>();
 a1.add(1);
 a1.add(2);
 a1.add(3);
 a1.add(4);
 ArrayList<Integer> a2 = new ArrayList<>();
 a2.add(5);
 a2.add(6);
 a2.add(7);
 a2.add(8);
 ArrayList<Integer> a3 = new ArrayList<>();
 a3.add(9);
 a3.add(10);
 a3.add(11);
 a3.add(12);
 ArrayList<Integer> a4 = new ArrayList<>();
 a4.add(13);
 a4.add(14);
 a4.add(15);
 a4.add(16);
 ArrayList<Integer> a5 = new ArrayList<>();
 a5.add(17);
 a5.add(18);
 a5.add(19);
 a5.add(20);
 ArrayList<ArrayList<Integer>> xarr = new ArrayList<>();
 xarr.add(a1);
 xarr.add(a2);
 xarr.add(a3);
 xarr.add(a4);

 System.out.println(xarr);

 AntiDiagonal ad = new AntiDiagonal();
 System.out.println(ad.diagonal(xarr));
 */


public class AntiDiagonal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a.size() == 0) return result;
        int rowSize = a.size();
        int marker = 0;

        //till marker x starts smaller(at Zero) goes till rowSize-1
        for (int i = 0; i <= rowSize-1 ; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int x = 0; x <= i; x++) {
//                System.out.print("("+x+","+(i-x)+")");
                tmp.add(a.get(x).get(i-x));
            }
//            System.out.println();
            result.add(tmp);
        }
        //after marker, x starts at marker and goes till zero
        for (int i = 1; i <= rowSize-1 ; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int x = i;
            for (int y = rowSize-1; y >= i ; y--) {
//                System.out.print("("+x+","+(y)+")");
                tmp.add(a.get(x).get(y));
                x++;
            }
//            System.out.println();
            result.add(tmp);
        }
        return result;
    }
}
