package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 Integer[] a= {9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27 };
 Integer[] d= {32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38};
 ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(a));
 ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(d));
 HotelBookingPossible hbp = new HotelBookingPossible();
 System.out.println(hbp.hotel(arrive,depart,16));
 */
public class HotelBookingPossible {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if( K == 0 || arrive == null || depart == null) return false;
        sortByArrival(arrive,depart);
//        System.out.println(arrive);
//        System.out.println(depart);
        int occupency = 0;
        int i=0, j=0;
        while(i < arrive.size() && j < depart.size()){
            if(arrive.get(i) < depart.get(j)){
                occupency++;
                if(occupency > K) return false;
                i++;
                continue;
            }
            if(arrive.get(i) > depart.get(j)){
                occupency--;
                j++;
                continue;
            }
            if(arrive.get(i) == depart.get(j)){
                i++;j++;
                continue;
            }
        }

        return true;


    }

    private void sortByArrival(ArrayList<Integer> a, ArrayList<Integer> b){
        quickSort(a,0,a.size()-1);
        quickSort(b,0,a.size()-1);
    }

    private void quickSort(ArrayList<Integer> a, int start, int end){
        if (start >= end) return;
        int pivot = arrange(a, start, end);
        quickSort(a,start,pivot-1);
        quickSort(a,pivot+1,end);
    }

    private int arrange(ArrayList<Integer> a, int start, int end){
        int pivot = a.get(end);
        int tempPivotIndx = 0;
        for (int i = 0; i < end; i++) {
            if(a.get(i) <= pivot){
                int tmp = a.get(i);
                a.set(i,a.get(tempPivotIndx));
                a.set(tempPivotIndx,tmp);
                tempPivotIndx++;
            }
        }
        a.set(end, a.get(tempPivotIndx));
        a.set(tempPivotIndx, pivot);
        return tempPivotIndx;
    }
}
