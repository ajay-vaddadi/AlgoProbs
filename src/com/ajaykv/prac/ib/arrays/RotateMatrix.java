package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
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

 for(ArrayList<Integer> a : xarr){
 System.out.println(a);
 }

 RotateMatrix rm = new RotateMatrix();
 rm.rotate(xarr);

 System.out.println("ROTATED ==> ");

 for(ArrayList<Integer> a : xarr){
 System.out.println(a);
 }

 */
public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a==null || a.size() == 0) return;

        /*
        Idea is to break matrix into concentric squares and move each n-1 moves ahead
                1 2 3 4        1 2 3 4
                5 6 7 8  ===>  5     8
                9 1 2 3        9     3
                4 5 6 7        4 5 6 7
         */

        int start = 0, end = a.size()-1;
        while(start <= end){
            int moveAhead = end - start;
            for (int i = start; i < end; i++) {
                moveCyclic(a,start,i,moveAhead,start,end);
            }
            start++;
            end--;
        }
    }


    public void moveCyclic(ArrayList<ArrayList<Integer>> a, int xStart,int yStart, int moveAhead, int minBoundary, int maxBoundary){
        int xCurr = xStart, xNext = xStart, xInit = xStart;
        int yCurr = yStart, yNext = yStart, yInit = yStart;
        int[] nextXY = nextStep(xCurr,yCurr,moveAhead,minBoundary,maxBoundary);
        xNext = nextXY[0];
        yNext = nextXY[1];
//        System.out.println("CurrX : "+xCurr+" CurrY : "+yCurr);
//        System.out.println("NextX : "+xNext+" CurrY : "+yNext);
        int tmp = a.get(xCurr).get(yCurr);
        while (xNext != xInit || yNext != yInit){
            int tmp2 = a.get(xNext).get(yNext);
//            System.out.println("Setting Value: "+tmp+" at ("+xNext+","+yNext+")");
            a.get(xNext).set(yNext,tmp);
            tmp = tmp2;
            xCurr = xNext;
            yCurr = yNext;
            nextXY = nextStep(xCurr,yCurr,moveAhead,minBoundary,maxBoundary);
            xNext = nextXY[0];
            yNext = nextXY[1];
//            System.out.println("CurrX : "+xCurr+" CurrY : "+yCurr);
//            System.out.println("NextX : "+xNext+" CurrY : "+yNext);
        }
//        System.out.println("Setting Value: "+tmp+" at ("+xNext+","+yNext+")");
        a.get(xNext).set(yNext,tmp);
    }

    public int[] nextStep(int x, int y, int moveAhead,int min,int max){
        int i = 0;
        while(i < moveAhead){
            //if x == min, then its on the top most row. So, go right till (x,y) maximizes on 'y' keeping x constant
            if(x == min && y >= min && y < max){
                y++;
                i++;
                continue;
            }
            //if x == min and y == max, then its on the right most row. So, go down till (x,y) maximizes on 'x' keeping y constant
            if(y == max && x >= min && x < max){
                x++;
                i++;
                continue;
            }
            if(x == max && y <= max && y > min){
                y--;
                i++;
                continue;
            }
            if(y == min && x<= max && x > min){
                x--;
                i++;
                continue;
            }
        }
        return new int[]{x,y};
    }
}
