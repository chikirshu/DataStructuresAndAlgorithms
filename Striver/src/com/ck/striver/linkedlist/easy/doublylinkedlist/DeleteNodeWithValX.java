package com.ck.striver.linkedlist.easy.doublylinkedlist;

import com.ck.striver.common.doublylinkedlist.ListNode;

public class DeleteNodeWithValX {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next=n2;
        n1.prev = null;

        n2.next = n3;
        n2.prev = n1;

        n3.next = null;
        n3.prev = n2;

        ListNode newHead = processDeletionOfNodeWithValX(n1, 2);
        if(newHead!=null)
            System.out.println(newHead.val);
    }

    private static ListNode processDeletionOfNodeWithValX(ListNode n1, int val) {
        ListNode newHead = n1, crnt = n1;

        if(n1==null || (n1.next==null && n1.val==val)) return null;
        if(n1.val == val){
            newHead = crnt.next;
            newHead.prev = null;
            return newHead;
        }

        while(crnt.next!=null){
            if(crnt.val==val){
                break;
            }
            crnt=crnt.next;
        }

        if(crnt.next!=null || crnt.val==val){
            ListNode tempPrev = crnt.prev;
            ListNode tempNext = crnt.next;
            tempPrev.next = tempNext;
            if(tempNext!=null){
                tempNext.prev = tempPrev;
            }
        }
        return newHead;
    }
}
