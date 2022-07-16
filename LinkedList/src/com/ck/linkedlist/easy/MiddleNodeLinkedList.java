package com.ck.linkedlist.easy;

import com.ck.linkedlist.common.ListNode;

public class MiddleNodeLinkedList {

	public static void main(String[] args) {

		ListNode headA = new ListNode(1);
		ListNode node2A = new ListNode(2);
		ListNode node3A = new ListNode(3);
		ListNode node4A = new ListNode(4);
		ListNode node5A = new ListNode(5);

		headA.next = node2A;
		node2A.next = node3A;
		node3A.next = node4A;
		node4A.next = node5A;
		
		ListNode result = middleNode(headA);
		while(result!=null) {
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
        
        ListNode slow=head, fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }

}
