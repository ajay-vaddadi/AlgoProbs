package com.ajaykv.prac.ib.arrays;

import com.ajaykv.prac.commons.CommonUtils;

import java.util.ArrayList;

/**
 Integer[] arr = {444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52};
 Integer[] arr = {1,2,3,6,5,4};
 ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(arr));
 NextPermutation np = new NextPermutation();
 np.nextPermutation(a);
 System.out.println(a);
 */
public class NextPermutation {
    public void nextPermutation(ArrayList<Integer> a) {
        boolean swapped = false;
        for (int i = a.size()-1; i > 0; i--) {
            if (firstDigit(a.get(i)) > firstDigit(a.get(i-1))) {
                swapped = true;
                int temp = a.get(i);
                a.set(i, a.get(i-1));
                a.set(i-1,temp);

                break;
            }
        }
        if(!swapped){
            sortAsc(a);
        }
    }
    private int firstDigit(int a){
        while (a > 10){
            a = a/10;
        }
        return a;
    }

    private void sortAsc(ArrayList<Integer> arr){
        quickSort(arr,0,arr.size()-1);
    }

    private void quickSort(ArrayList<Integer> a, int start, int end){
        if (start >= end) return;
        int pivot = arrange(a,start,end);
        quickSort(a,start,pivot-1);
        quickSort(a,pivot+1,end);
    }

    private int arrange(ArrayList<Integer> arr, int start, int end){
        int pivot = arr.get(end);
        int tempPivot = start;
        for (int i = start; i < end ; i++) {
            if(arr.get(i) <= pivot){
                int temp = arr.get(i);
                arr.set(i,arr.get(tempPivot));
                arr.set(tempPivot,temp);
                tempPivot++;
            }
        }
        arr.set(end,arr.get(tempPivot));
        arr.set(tempPivot,pivot);
        return tempPivot;
    }
}
