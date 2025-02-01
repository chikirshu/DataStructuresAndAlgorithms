package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity of the code is O(n) because in the worst case scenario, we may need to traverse the entire linked list to find the node with the value X.
    Space Complexity:The space complexity of the code is O(1) because it uses a constant amount of extra space for the pointer variables.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/delete-the-element-with-value-x?tab=submissions
public class DeleteNodeWithValX {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode newHead = processDeleteNodeWithValX(n1, 4);
        if(newHead!=null)
            System.out.println(newHead.val);
    }

    private static ListNode processDeleteNodeWithValX(ListNode n1, int val) {
        // not considered n1.next==null here, because there can be a case val is not present in a linkedlist with only 1 value
        if(n1==null) return null;

        ListNode crnt = n1, newHead = n1;
        if(n1.val==val){
            newHead = crnt.next;
            return newHead;
        }

        while(crnt.next!=null){
            if(crnt.next.val==val){
                break;
            }
            crnt = crnt.next;
        }

        if(crnt.next!=null){
            crnt.next = crnt.next.next;
        }
        return newHead;
    }
}
