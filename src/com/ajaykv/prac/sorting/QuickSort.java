package com.ajaykv.prac.sorting;

/**
 * Created by ajaykv on 1/5/17.
 */
public class QuickSort implements Sort {
    public int[] sort(int[] inputArr){
        quickSort(inputArr,0,inputArr.length-1);
        return inputArr;
    }

    public void quickSort(int[] inputArr,int startIndx, int endIndx){
        if(startIndx>=endIndx) return;

        int pivotIndx = partition(inputArr,startIndx,endIndx);
        quickSort(inputArr,startIndx,pivotIndx-1);
        quickSort(inputArr,pivotIndx+1,endIndx);
    }

    public int partition(int[] inputArr,int startIndx,int endIndx){
        int pivot = inputArr[endIndx];
        int tempPivot = startIndx;
        for (int i = startIndx; i < endIndx ; i++) {
            if(inputArr[i] <= pivot){
                int tmp = inputArr[tempPivot];
                inputArr[tempPivot] = inputArr[i];
                inputArr[i] = tmp;
                tempPivot++;
            }
        }
        inputArr[endIndx] = inputArr[tempPivot];
        inputArr[tempPivot] = pivot;
        return tempPivot;
    }
}
