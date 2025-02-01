package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

/*
    Time Complexity:The time complexity is O(1) because we perform a constant number of operations regardless of the size of the list.
    Space Complexity:The space complexity is O(1) because we only allocate space for a single new ListNode.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-doubly-ll/insert-node-before-head-in-dll?tab=submissions
public class InsertNodeBeforeHead {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n1.prev = null;

        n2.next = n3;
        n2.prev = n1;

        n3.next = null;
        n3.prev = n2;

        ListNode newHead = processInsertionBeforeHead(n1, 0);
        System.out.println(newHead.val);
    }

    private static ListNode processInsertionBeforeHead(ListNode n1, int val) {
        ListNode newHead =  new ListNode(val);
        newHead.prev = null;
        newHead.next = n1;
        // Note - don't forget this
        n1.prev=newHead;
        return newHead;
    }
}
