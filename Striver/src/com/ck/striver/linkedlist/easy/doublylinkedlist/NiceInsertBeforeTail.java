package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

/*
    Time Complexity:O(n), where n is the number of nodes in the linked list.
    Space Complexity:O(1), as we are using a constant amount of extra space regardless of the input size.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-doubly-ll/insert-node-before-tail-in-dll?tab=submissions
public class NiceInsertBeforeTail {

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

        ListNode newHead = processInsertionBeforeTail(n1, 4);
        System.out.println(newHead.val);
    }

    private static ListNode processInsertionBeforeTail(ListNode n1, int val) {
        ListNode newHead = n1, crnt = n1;
        ListNode newNode = new ListNode(val);

        while(crnt.next!=null){
            crnt = crnt.next;
        }

        ListNode tempPrev = crnt.prev;
        if(tempPrev!=null){
            tempPrev.next = newNode;
        }
        else{
            // Note - Don't forget this
            newHead = newNode;
        }
        newNode.prev = tempPrev;
        newNode.next = crnt;

        // Note - Don't forget this
        crnt.prev = newNode;

        return newHead;
    }
}
