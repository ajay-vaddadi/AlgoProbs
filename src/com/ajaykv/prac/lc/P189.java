package com.ajaykv.prac.lc;

/**
 * Created by ajaykv on 1/5/17.
 */
public class P189 {
    public void rotate(int[] nums, int k) {
        if(k==0||k%nums.length==0) return;
        if(k>nums.length) k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);


    }

    private void reverse(int[] arr, int strt, int end){
        while(strt<=end){
            int temp = arr[strt];
            arr[strt] = arr[end];
            arr[end] = temp;
            strt++;end--;
        }
    }

}

