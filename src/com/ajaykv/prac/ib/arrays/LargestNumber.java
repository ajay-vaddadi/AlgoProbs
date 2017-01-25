package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;
import java.util.List;


/**
 Integer[] arr = {3, 90, 34, 2, 1};
 LargestNumber ln = new LargestNumber();
 System.out.println(ln.largestNumber(Arrays.asList(arr)));
 */
public class LargestNumber {
    public String largestNumber(final List<Integer> a) {
        ArrayList<Integer> tmp = customMergeSort(new ArrayList<>(a));
        StringBuilder sb = new StringBuilder();
        for (int i : tmp){
            sb.append(i);
        }
        return sb.toString();
    }

    private ArrayList<Integer> customMergeSort(ArrayList<Integer> arr){
        System.out.print("Working On ==>");
        System.out.println(arr);
        if(arr.size() < 2) return arr;
        int mid = arr.size()/2;
        ArrayList<Integer> firstHalf = new ArrayList<>(arr.subList(0,mid));
        ArrayList<Integer> secondHalf = new ArrayList<>(arr.subList(mid,arr.size()));
        ArrayList<Integer> temp1 = customMergeSort(firstHalf);
        ArrayList<Integer> temp2 = customMergeSort(secondHalf);
        return customMerge(temp1,temp2);
    }

    private ArrayList<Integer> customMerge(ArrayList<Integer> t1, ArrayList<Integer> t2){
        ArrayList<Integer> temp = new ArrayList<>();
        System.out.println("Merging :"+t1+" and "+t2+" as ==>");
        int i =0, j = 0;
        while (i < t1.size() && j < t2.size()){

        }
        return temp;
    }

}
