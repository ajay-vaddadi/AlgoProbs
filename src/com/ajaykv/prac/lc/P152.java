package com.ajaykv.prac.lc;

/**
 * Created by ajaykv on 1/6/17.
 */
public class P152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length ==0) return 0;
        int uberMax = nums[0], finalMax = nums[0] , uberMin = nums[0];
        for (int i = 1; i < nums.length; i++) {

            //Swapping Positive and Negative Max and Min based on upcoming number makes sure
            if (nums[i] < 0) {
                int temp = uberMax;
                uberMax = uberMin;
                uberMin = temp;
            }

            uberMax = Math.max(uberMax*nums[i],nums[i]); // This is protection from nums[i] being zero .. so that
            uberMin = Math.min(uberMin*nums[i],nums[i]);

            finalMax = Math.max(finalMax,uberMax); // this lets handle when you encounter zero ... max of the maxes
        }
        return finalMax;
    }
}
