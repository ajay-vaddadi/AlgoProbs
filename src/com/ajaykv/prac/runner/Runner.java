package com.ajaykv.prac.runner;

import com.ajaykv.prac.commons.ListNode;
import com.ajaykv.prac.lc.P186;
import com.ajaykv.prac.lc.P189;
import com.ajaykv.prac.lc.P59;
import com.ajaykv.prac.lc.P61;
import com.ajaykv.prac.sorting.InsertionSort;
import com.ajaykv.prac.sorting.MergeSort;
import com.ajaykv.prac.sorting.QuickSort;
import com.ajaykv.prac.sorting.Sort;

import java.util.Arrays;

/**
 * Created by ajaykv on 1/3/17.
 */
public class Runner {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String s = " the sky is blue";
        char[] str = s.toCharArray();
//        ListNode head = new ListNode(arr[0]);
//        ListNode tmp = head;
//        for (int i = 1; i < arr.length; i++) {
//            tmp.next = new ListNode(arr[i]);
//            tmp = tmp.next;
//        }

        P186 p186 = new P186();
        p186.reverseWords(str);
        System.out.println(str);

//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
    }
}
