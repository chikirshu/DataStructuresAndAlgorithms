package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity of the code is O(n) because it traverses the linked list once to reach the second last node.
    Space Complexity:The space complexity of the code is O(1) because it uses a constant amount of additional space for pointer manipulation.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/deletion-of-the-tail-of-ll?tab=submissions
public class DeletionOfTail {

    public static void main(String[] tail){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode newHead = processDeleteTail(n1);
        if(newHead!=null)
            System.out.println(newHead.val);
    }

    private static ListNode processDeleteTail(ListNode n1) {
        ListNode crnt = n1, head = n1;
        if(crnt == null || crnt.next==null) return null;
        while(crnt.next.next!=null){
            crnt = crnt.next;
        }
        crnt.next = null;
        return head;
    }
}
