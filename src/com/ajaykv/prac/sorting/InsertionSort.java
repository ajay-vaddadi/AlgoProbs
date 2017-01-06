package com.ajaykv.prac.sorting;

/**
 * Created by ajaykv on 1/4/17.
 */
public class InsertionSort implements Sort{

    public int[] sort(int[] inputArr){
        int divider = 0;
        int currentIndex = 0;

        for (divider = 0; divider <= inputArr.length-2; divider++) {
            currentIndex = divider+1;
            for (int i = 0; i <= divider-1; i++) {
                if(inputArr[i]<=inputArr[currentIndex]){
                    continue;
                }else {
                    int temp = inputArr[i];
                    inputArr[i]=inputArr[currentIndex];
                    inputArr[currentIndex]=temp;
                }
            }
        }
        return inputArr;
    }

}
