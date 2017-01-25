package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ajaykv on 1/7/17.
 */
public class MaxNonNegSubArr {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if(a == null || a.size() == 0) return new ArrayList<>();
        long tempSum = 0;
        long start = 0;
        ArrayList<ArrayList<Long>> data = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) < 0){
                if (start == i) {
                    start = i+1;
                    continue;
                }
                ArrayList<Long> temp = new ArrayList<>(Arrays.asList(tempSum,start,(long)i-1));
                data.add(temp);
                tempSum = 0;
                start = i+1;
            } else {
                tempSum += a.get(i);

            }
        }
        if(a.get(a.size()-1) >= 0){
            ArrayList<Long> temp = new ArrayList<>(Arrays.asList(tempSum,start,(long)a.size()-1));
            data.add(temp);
        }

        System.out.println(data);
        long maxSum =0;
        int maxInd = 0;
        for (int i = 0; i < data.size(); i++) {
            if(maxSum < data.get(i).get(0)){
                maxSum = data.get(i).get(0);
                maxInd = i;
            } else if (maxSum == data.get(i).get(0)) {
                if ((data.get(maxInd).get(2)-data.get(maxInd).get(1)) < (data.get(i).get(2)-data.get(i).get(1))){
                    maxInd = i;
                }
            }
        }

        if (data.size() == 0) {
            return new ArrayList<>();
        }else {
            return new ArrayList<>(a.subList(data.get(maxInd).get(1).intValue(), data.get(maxInd).get(2).intValue() + 1));
        }

    }
}
