package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity is O(n) because you have to traverse the entire list to insert at the tail.
    Space Complexity:The space complexity is O(1) as only a constant amount of extra space is used regardless of the input size.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/insertion-at-the-tail-of-ll?tab=submissions
public class InsertionAtTail {

    public static void main(String[] args){

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode newHead = processInsertionAtTail(n1, 4);
        System.out.println(newHead.val);
    }

    private static ListNode processInsertionAtTail(ListNode n1, int val) {
        ListNode newHead = n1, crnt = n1;
        ListNode newNode = new ListNode(val);
        newNode.next = null;

        if(n1==null){
            newHead = newNode;
            return newHead;
        }

        while(crnt.next!=null){
            crnt = crnt.next;
        }
        crnt.next = newNode;

        return newHead;
    }
}
