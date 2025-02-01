package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

/*
    Time Complexity:The time complexity of the code is O(n), which includes traversing the list to the kth node to delete it.
    Space Complexity:The space complexity of the code is O(1) as it uses a constant amount of extra space regardless of the input size.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-doubly-ll/delete-kth-element-of-dll?tab=submissions
public class DeleteKthNode {

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

        ListNode newHead = processDeletionOfKthNode(n1, 2);
        if(newHead != null){
            System.out.println(newHead.val);
        }
    }

    private static ListNode processDeletionOfKthNode(ListNode n1, int pos) {
        ListNode newHead = n1, crnt = n1;
        int i=1;
        if(n1==null || (pos==1 && crnt.next==null)) return null;
        if(pos==1){
            newHead = crnt.next;
            newHead.prev = null;
            return newHead;

        }
        while(crnt.next!=null){
            if(i==pos){
                break;
            }
            crnt=crnt.next;
            i++;
        }

        if(crnt.next!=null || i==pos){
            ListNode tempPrev = crnt.prev;
            ListNode tempNext = crnt.next;
            tempPrev.next = tempNext;
            if(tempNext!=null) tempNext.prev = tempPrev;
        }
        return newHead;
    }
}
