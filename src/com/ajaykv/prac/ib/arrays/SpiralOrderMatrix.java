package com.ajaykv.prac.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by ajaykv on 1/7/17.
 */
public class SpiralOrderMatrix {
    public ArrayList<ArrayList<Integer>>  generateMatrix(int n) {
        if (n==0) return new ArrayList<ArrayList<Integer>>();

        int[][] matrix = new int[n][n];
        int[] numbers = new int[n*n];
        for(int i = 0;i<n*n;i++){
            numbers[i] = i+1;
        }

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int index = 0;
        while (top <= bottom && left <= right) {

            index = addRight(matrix, left, right, top, numbers, index);
            top++;
            if(top>bottom) break;

            index = addDown(matrix, top, bottom, right, numbers, index);
            right--;
            if (left > right) break;

            index = addLeft(matrix, right, left, bottom, numbers, index);
            bottom--;
            if(top>bottom) break;

            index = addUp(matrix, bottom, top, left, numbers, index);
            left++;
            if (left > right) break;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int[] row : matrix){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int a : row){
                tmp.add(a);
            }
            result.add(tmp);
        }
        return result;


    }

    private int addRight(int [][]matrix, int left, int right, int top, int[] numbers, int index){
        for (int i = left;i<=right;i++){
            matrix[top][i] = numbers[index];
            index++;
        }
        return index;
    }

    private int addDown(int [][]matrix, int top, int bottom, int right, int[] numbers, int index){
        for (int i = top;i<=bottom;i++){
            matrix[i][right] = numbers[index];
            index++;
        }
        return index;
    }

    private int addLeft(int [][]matrix, int right, int left, int bottom, int[] numbers, int index){
        for (int i = right;i>=left;i--){
            matrix[bottom][i]= numbers[index];
            index++;
        }
        return index;
    }

    private int addUp(int [][]matrix, int bottom, int top, int left, int[] numbers, int index){
        for (int i = bottom;i>=top;i--){
            matrix[i][left]= numbers[index];
            index++;
        }
        return index;
    }
}
