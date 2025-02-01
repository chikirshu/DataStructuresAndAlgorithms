package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity is O(N) where N is the position K. In the worst case, you need to traverse the list up to the K-th position, which takes linear time in terms of the size of the list.
    Space Complexity:The space complexity is O(1) because we are only using a fixed amount of extra space (a few pointers), regardless of the input size.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/insertion-at-the-kth-position-of-ll?tab=submissions
public class InsertAtKthNode {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n3;
        n3.next = n4;
        n4.next = null;

        ListNode newHead = processInsertionAtKthNode(n1, 2, 2);
        System.out.println(newHead.val);
    }

    private static ListNode processInsertionAtKthNode(ListNode n1, int val, int pos) {
        ListNode newHead = n1, crnt = n1;
        if(crnt==null && pos!=1) return n1;

        ListNode newNode = new ListNode(val);

        if(pos==1){
            newNode.next = n1;
            newHead = newNode;
            return newHead;
        }

        int i=1;

        while(crnt.next!=null){
            if(i+1==pos){
                break;
            }
            crnt=crnt.next;
            i++;
        }
        if (crnt.next != null || i+1==pos) {
            newNode.next = crnt.next;
            crnt.next = newNode;
        }
        return newHead;
    }
}
