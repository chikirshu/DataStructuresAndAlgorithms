package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity of the code is O(1) because it performs a constant amount of work to insert a node at the head of the linked list.
    Space Complexity:The space complexity of the code is O(1) because it uses a fixed amount of extra space regardless of the input size.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/insertion-at-the-head-of-ll?tab=submissions
public class InsertionAtHead {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode newHead = processInsertionAtHead(n1, 0);
        System.out.println(newHead.val);
    }

    private static ListNode processInsertionAtHead(ListNode n1, int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = n1;
        return newHead;
    }
}
