package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;

/**
 * Created by ajaykv on 1/6/17.
 */
public class MaxAbsDiff {
    public int maxArr(ArrayList<Integer> A) {
        // Case 1 : MAX(A[i]+i)-MIN(A[j]+j)
        int case1MaxAI = Integer.MIN_VALUE;
        int case1MinAJ = Integer.MAX_VALUE;

        //Case 2 : MAX (A[i]-i) - MIN (A[j-j])
        int case2MaxAI = Integer.MIN_VALUE;
        int case2MinAJ = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int tmp = i + A.get(i);
            int tmp2 = A.get(i)-i;
            case1MaxAI = Math.max(tmp,case1MaxAI);
            case2MaxAI = Math.max(tmp2,case2MaxAI);
            case1MinAJ = Math.min(tmp,case1MinAJ);
            case2MinAJ = Math.min(tmp2,case2MinAJ);
        }
        return Math.max((case1MaxAI-case1MinAJ), (case2MaxAI-case2MinAJ));
    }
}

