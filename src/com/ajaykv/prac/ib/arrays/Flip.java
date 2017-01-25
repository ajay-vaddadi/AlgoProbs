package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ajaykv on 1/6/17.
 */
public class Flip {
    public ArrayList<Integer> flip(String A) {
        ArrayList<ArrayList<Integer>> count = new ArrayList<>();
        if (A == null) return new ArrayList<>();
        char[] bits = A.toCharArray();
        if (bits.length < 1) return new ArrayList<>();

        if(bits.length == 1) {
            if(bits[0] == '0'){
                return new ArrayList<>(Arrays.asList(1,1));
            } else {
                return new ArrayList<>();
            }
        }

        int multiplier = 1;
        int start = 0, bitCount = 0;
        for (int i = 0; i < bits.length-1; i++) {
            char currBit = bits[i];
            char nextBit = bits[i+1];
            bitCount++;
            if (currBit != nextBit){
                multiplier = currBit == '0' ? 1 : -1; // Flipping 1's means we are losing points so -1
                bitCount *= multiplier;
                ArrayList tmp = new ArrayList<>();
                tmp.add(bitCount);
                tmp.add(start);
                tmp.add(i);
                count.add(tmp);
                bitCount = 0;
                start = i+1;
            }
        }

        //Taking Care of the Last Bit
        if(bits[bits.length-1] == bits[bits.length-2]){
            bitCount++;
        }else {
            bitCount = 1;
        }
        multiplier = bits[bits.length-1] == '0' ? 1 : -1;
        bitCount *= multiplier;
        ArrayList tmp = new ArrayList<>();
        tmp.add(bitCount);
        tmp.add(start);
        tmp.add(bits.length-1);
        count.add(tmp);
        System.out.println(count);
        return maxSubArray(count);
    }

    private ArrayList<Integer> maxSubArray(ArrayList<ArrayList<Integer>> arr){
        ArrayList<Integer> startResult = new ArrayList<>();
        ArrayList<Integer> endResult = new ArrayList<>();
        ArrayList<Integer> uberMaxTmp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int uberMax = 0, tempMax = 0, start = 0, end = 0;
        boolean allNegative = true;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).get(0) > 0) allNegative = false;
            if (tempMax == 0 && (tempMax + arr.get(i).get(0)) > 0) startResult.add(arr.get(i).get(1));
            tempMax = tempMax + arr.get(i).get(0);
            if(tempMax < 0) {
                tempMax = 0;
            }

            if(uberMax < tempMax) {
                 uberMax = tempMax;
                 uberMaxTmp.add(uberMax);
                 endResult.add(arr.get(i).get(2));
            }
        }
        System.out.println(startResult);
        System.out.println(endResult);
        System.out.println(uberMaxTmp);

        if (!allNegative){
            int maxInd = 0, maxVal = 0;
            for (int i = 0; i < uberMaxTmp.size(); i++) {
                if(maxVal < uberMaxTmp.get(i)) {
                    maxVal = uberMaxTmp.get(i);
                    maxInd = i;
                }
            }
            if(maxInd >= startResult.size()){
                result.add(startResult.get(startResult.size()-1)+1);

            }else{
                result.add(startResult.get(maxInd)+1);
            }
            result.add(endResult.get(maxInd)+1);

        }
        return result;
    }

}
