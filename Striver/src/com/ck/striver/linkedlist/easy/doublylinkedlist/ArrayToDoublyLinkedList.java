package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

/*
    Time Complexity:O(n), where n is the length of the array as each element is processed once
    Space Complexity:O(n), for storing the n nodes of the doubly linked list
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-doubly-ll/convert-array-to-dll?tab=submissions
public class ArrayToDoublyLinkedList {

    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        ListNode head = convertArrayToDoublyLinkedList(arr);
        System.out.println(head.val);
    }

    private static ListNode convertArrayToDoublyLinkedList(int[] arr) {
        ListNode head = null, prev = null;

        for(int val : arr){
            ListNode crnt = new ListNode(val);
            if(head == null){
                head = crnt;
            }
            else{
                prev.next = crnt;
                crnt.prev = prev;
                crnt.next = null;
            }
            prev = crnt;
        }
        return head;
    }
}
