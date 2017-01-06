package com.ajaykv.prac.sorting;

import java.util.Arrays;

/**
 * Created by ajaykv on 1/4/17.
 */
public class MergeSort implements Sort{

    public int[] sort(int[] inputArr){
        if (inputArr.length < 2) return inputArr;
        int mid = inputArr.length/2;
        int[] leftArr = Arrays.copyOfRange(inputArr,0,mid);
        int[] rightArr = Arrays.copyOfRange(inputArr,mid,inputArr.length);
        leftArr = sort(leftArr);
        rightArr= sort(rightArr);
        merge(leftArr,rightArr,inputArr);
        return inputArr;
    }

    public int[] merge(int[] arr1, int[] arr2,int[] outputArr){
        int indA1 = 0;
        int indA2 = 0;
        int indOutput = 0;
        while(indA1 < arr1.length && indA2 < arr2.length){
            if(arr1[indA1] < arr2[indA2]){
                outputArr[indOutput] = arr1[indA1];
                indOutput++;
                indA1++;
            }else if(arr1[indA1] == arr2[indA2]){
                outputArr[indOutput] = arr1[indA1];
                indOutput++;
                indA1++;
                outputArr[indOutput] = arr2[indA2];
                indOutput++;
                indA2++;
            }else{
                outputArr[indOutput] = arr2[indA2];
                indOutput++;
                indA2++;
            }

        }
        while(indA1<=arr1.length-1){
            outputArr[indOutput]=arr1[indA1];
            indA1++;
            indOutput++;
        }
        while(indA2<=arr2.length-1){
            outputArr[indOutput]=arr2[indA2];
            indA2++;
            indOutput++;
        }
        return outputArr;
    }
}
