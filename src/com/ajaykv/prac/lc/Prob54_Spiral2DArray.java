package com.ajaykv.prac.lc;

public class Prob54_Spiral2DArray {

    public static void main(String[] args) {
        //declarations
        int arrHeight = 4;
        int arrWidth = 1;
        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        Prob54_Spiral2DArray spiral = new Prob54_Spiral2DArray();
        spiral.traverseClockWise(arr, arrHeight, arrWidth);
    }

    public void traverseClockWise(int [][]arr, int arrHeight,int arrWidth){

        int top = 0;
        int bottom = arrHeight-1;
        int left = 0;
        int right = arrWidth-1;

        int i=0; int j=0;

        while (top <= bottom && left <= right) {
//            System.out.println("Top: " + top + " Bottom:" + bottom + " Left:" + left + " Right:" + right);

            traverseRight(arr, left, right, top);
            top++;
            if(top>bottom) break;

            traverseDown(arr, top, bottom, right);
            right--;
            if (left > right) break;

            traverseLeft(arr, right, left, bottom);
            bottom--;
            if(top>bottom) break;

            traverseUp(arr, bottom, top, left);
            left++;
            if (left > right) break;
        }
    }

    private void traverseRight(int [][]arr, int left, int right, int top){
        for (int i = left;i<=right;i++){
            System.out.println(arr[top][i]);
        }
    }

    private void traverseDown(int [][]arr, int top, int bottom, int right){
        for (int i = top;i<=bottom;i++){
            System.out.println(arr[i][right]);
        }
    }

    private void traverseLeft(int [][]arr, int right, int left, int bottom){
        for (int i = right;i>=left;i--){
            System.out.println(arr[bottom][i]);
        }
    }

    private void traverseUp(int [][]arr, int bottom, int top, int left){
        for (int i = bottom;i>=top;i--){
            System.out.println(arr[i][left]);
        }
    }
}
