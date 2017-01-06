package com.ajaykv.prac.lc;

/**
 * Created by ajaykv on 1/5/17.
 */
public class P186 {
    public void reverseWords(char[] s) {
        if(s == null || s.length <= 1) return;
        int start =0 ,end = 0;
        while(end < s.length){
            if (s[end] == ' '){
                reverse(s,start,end-1);
                start = end;
                start++;
                end++;
            }else{
                end++;
            }
        }
        reverse(s,start,end-1);
        reverse(s,0,s.length-1);
    }

    private void reverse(char[] arr, int strt, int end){
        while(strt<=end){
            char temp = arr[strt];
            arr[strt] = arr[end];
            arr[end] = temp;
            strt++;end--;
        }
    }

}
