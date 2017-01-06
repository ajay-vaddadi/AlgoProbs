package com.ajaykv.prac.lc;

import com.ajaykv.prac.commons.ListNode;

import java.util.List;

/**
 * Created by ajaykv on 1/5/17.
 */
public class P61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        int length = length(head);
        if(k%length==0) return head;
        if(k>length) k = k%length;
        ListNode tempHead = head;
        int pivotIndex = length-k;
        for (int i = 1; i < pivotIndex ; i++) {
            tempHead = tempHead.next;
        }
        ListNode newHead = tempHead.next;
        tempHead.next=null;
        tempHead=newHead;
        while(tempHead.next!=null){
            tempHead =tempHead.next;
        }
        tempHead.next = head;
        return newHead;
    }

    private int length(ListNode head){
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        return size;
    }
}
