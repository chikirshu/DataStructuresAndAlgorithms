package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

/*
    Time Complexity:The time complexity of the code is O(1) as it involves a constant number of operations to delete the head of the list.
    Space Complexity:The space complexity of the code is O(1) as it uses a constant amount of additional space, regardless of the size of the input list.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-doubly-ll/delete-head-of-dll?tab=submissions
public class DeleteHeadOfDLL {

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

        ListNode newHead = processDeletionOfHeadOfDLL(n1);
        if(newHead!=null){
            System.out.println(newHead.val);
        }
    }

    private static ListNode processDeletionOfHeadOfDLL(ListNode n1) {
        if(n1==null || n1.next==null) return null;
        ListNode newHead = n1.next;
        newHead.prev = null;
        return newHead;
    }
}
