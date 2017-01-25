package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 * Created by ajaykv on 1/6/17.
 */
public class MinSteps {

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if(X.size()!=Y.size()) return -1;
        int numSteps = 0;
        for (int i = 0; i < X.size()-1 ; i++) {
            int x = X.get(i);
            int y = Y.get(i);
            int nextX = X.get(i+1);
            int nextY = Y.get(i+1);
            int diffX =0, diffY =0;
            if(x >= nextX){
                diffX = x-nextX;
            }else {
                diffX = nextX-x;
            }
            if(y >= nextY){
                diffY = y-nextY;
            }else {
                diffY = nextY-y;
            }
            numSteps += diffX>=diffY ? diffX : diffY;
        }
        return numSteps;
    }
}
