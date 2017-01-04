package com.ajaykv.prac.lc;

import java.util.ArrayList;
import java.util.List;

public class Prob54_Spiral2DArray {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        Prob54_Spiral2DArray spiral = new Prob54_Spiral2DArray();
        System.out.println(spiral.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> finalList = new ArrayList<>();

        if (matrix == null) { return finalList;}
        if (matrix.length == 0) { return finalList;}

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (top <= bottom && left <= right) {

            traverseRight(matrix, left, right, top, finalList);
            top++;
            if(top>bottom) break;

            traverseDown(matrix, top, bottom, right, finalList);
            right--;
            if (left > right) break;

            traverseLeft(matrix, right, left, bottom, finalList);
            bottom--;
            if(top>bottom) break;

            traverseUp(matrix, bottom, top, left, finalList);
            left++;
            if (left > right) break;
        }

        return finalList;

    }

    private void traverseRight(int [][]matrix, int left, int right, int top, List<Integer> finalList){
        for (int i = left;i<=right;i++){
            finalList.add(matrix[top][i]);
        }
    }

    private void traverseDown(int [][]matrix, int top, int bottom, int right, List<Integer> finalList){
        for (int i = top;i<=bottom;i++){
            finalList.add(matrix[i][right]);
        }
    }

    private void traverseLeft(int [][]matrix, int right, int left, int bottom, List<Integer> finalList){
        for (int i = right;i>=left;i--){
            finalList.add(matrix[bottom][i]);
        }
    }

    private void traverseUp(int [][]matrix, int bottom, int top, int left, List<Integer> finalList){
        for (int i = bottom;i>=top;i--){
            finalList.add(matrix[i][left]);
        }
    }
}
