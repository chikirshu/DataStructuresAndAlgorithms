package com.ck.striver.linkedlist.easy;

import com.ck.striver.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
    Time Complexity:The time complexity is O(n) where n is the number of nodes in the linked list, due to iterating through each node once.
    Space Complexity:The space complexity is O(n) because a list storing node values of size n is created.
*/
// https://takeuforward.org/plus/dsa/linked-list/fundamentals-single-ll/traversal-in-linked-list?tab=submissions
public class LinkedListTraversal {

    public static void main(String[] args){
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(0);

        n1.next = n2;
        n2.next=n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        System.out.println(getLinkedListData(n1));

    }

    private static List<Integer> getLinkedListData(ListNode n1) {
        ListNode crnt = n1;
        List<Integer> ans = new ArrayList<>();
        while(crnt!=null){
            ans.add(crnt.val);
            crnt = crnt.next;
        }
        return ans;
    }
}
