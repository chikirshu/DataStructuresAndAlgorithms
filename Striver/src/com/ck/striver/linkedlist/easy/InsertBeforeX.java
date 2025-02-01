package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity of the code is O(n), where n is the number of nodes in the linked list, as it may need to traverse the entire list in the worst case to find the node before which the insertion will be done.
    Space Complexity:The space complexity of the code is O(1) as it uses a constant amount of extra space regardless of the size of the input linked list.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/insertion-before-the-value-x-in-ll?tab=submissions
public class InsertBeforeX {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n3;
        n3.next = n4;
        n4.next = null;

        int val = 2;
        ListNode newHead = processInsertionAfterX(n1, 3, val);
        System.out.println(newHead.val);
    }

    private static ListNode processInsertionAfterX(ListNode n1, int x, int val) {
        ListNode newHead = n1, crnt = n1;
        ListNode newNode = new ListNode(val);

        if(crnt==null) return null;
        if(crnt.val == x){
            newHead = newNode;
            newHead.next = n1;
            return newHead;
        }
        while(crnt.next!= null){
            if(crnt.next.val==x){
                break;
            }
            crnt = crnt.next;
        }

        if(crnt.next!=null){
            newNode.next = crnt.next;
            crnt.next = newNode;
        }
        return newHead;
    }
}
