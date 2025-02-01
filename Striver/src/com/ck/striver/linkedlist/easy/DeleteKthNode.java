package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

/*
    Time Complexity:The time complexity of the code is O(n), where n is the number of nodes in the linked list, because it may require iterating through the entire list to find the k-th node.
    Space Complexity:The space complexity of the code is O(1) as it uses a constant amount of extra space regardless of the input size.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/deletion-of-the-kth-element-of-ll?tab=submissions
public class DeleteKthNode {

    public static void main(String[] args){

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode newHead = processDeleteKthNode(n1, 2);
        if(newHead!=null)
            System.out.println(newHead.val);
    }

    private static ListNode processDeleteKthNode(ListNode n1, int k) {
        ListNode crnt = n1, newHead = n1;
        if(crnt==null || k==0) return null;
        if(k==1){
            newHead=crnt.next;
            return newHead;
        }
        int i=1;
        while(crnt!=null){
            if(i+1==k){
                break;
            }
            i++;
            crnt = crnt.next;
        }

        if(crnt!=null && crnt.next!=null){
            ListNode temp = crnt.next.next;
            crnt.next = temp;
        }
        return newHead;
    }
}
