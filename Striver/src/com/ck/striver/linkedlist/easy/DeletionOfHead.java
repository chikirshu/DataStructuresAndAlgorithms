package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity of the given code is O(1) because it only changes references and performs a few constant time operations.
    Space Complexity:The space complexity is O(1) as it doesn't use any additional space that scales with the input size, it only uses a fixed amount of space for references.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/deletion-of-the-head-of-ll?tab=submissions
public class DeletionOfHead {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode newHead = deleteHead(n1);
        System.out.println(newHead.val);
    }

    private static ListNode deleteHead(ListNode n1) {
        if(n1==null) return null;
        ListNode newHead = n1.next;
        n1.next = null;
        return newHead;
    }
}
