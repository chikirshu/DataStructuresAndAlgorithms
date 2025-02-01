package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

/*
    Time Complexity:The time complexity of the given code is O(n) because it traverses the list until the tail node is found.
    Space Complexity:The space complexity of the given code is O(1) because it only uses a constant amount of additional space regardless of the input size.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-doubly-ll/delete-tail-of-dll?tab=submissions
public class DeleteTailOfDLL {

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

        ListNode newHead = processDeletionOfTailOfDLL(n1);

        if(newHead!=null){
            System.out.println(newHead.val);
        }
    }

    private static ListNode processDeletionOfTailOfDLL(ListNode n1) {
        ListNode newHead = n1, crnt = n1;

        if(n1==null || n1.next==null) return null;
        while(crnt.next!=null){
            crnt=crnt.next;
        }

        ListNode temp = crnt.prev;
        temp.next = null;
        return newHead;
    }
}
