package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

/*
    Time Complexity:The time complexity of the code is O(1) because the deletion of a node in a doubly linked list takes constant time.
    Space Complexity:The space complexity is O(1) as no additional space is used apart from a few variables.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-doubly-ll/removing-given-node-in-dll?tab=submissions
public class NiceDeleteGivenNode {

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

        processDeletionOfGivenNode(n2);
    }

    private static void processDeletionOfGivenNode(ListNode n1) {
        ListNode tempPrev = n1.prev;
        ListNode tempNext = n1.next;

        tempPrev.next = tempNext;
        if(tempNext!=null){
            tempNext.prev = tempPrev;
        }
    }
}
