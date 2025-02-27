package com.ck.striver.common.doublylinkedlist;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public ListNode(int val, ListNode next, ListNode prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
