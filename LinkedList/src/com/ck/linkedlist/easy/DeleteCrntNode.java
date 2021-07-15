package com.ck.linkedlist.easy;

import com.ck.linkedlist.common.ListNode;

// GFG - Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
public class DeleteCrntNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		dispplayNodes(head);
		deleteGivenNode(node2);
		dispplayNodes(head);
	}

	private static void deleteGivenNode(ListNode node2) {
		// ListNode temp = node2.next;
		// node2 = temp; will not work, you need to explicitly deep copy the values
		//node2.val = temp.val;
		//node2.next = temp.next;
		//temp =null; no need to explicitly free the temp
		//ListNode temp = node2.next.next;
		node2.val = node2.next.val;
		node2.next = node2.next.next;
	}

	private static void dispplayNodes(ListNode head) {
		ListNode crnt = head;
		while(crnt!=null) {
			System.out.print(crnt.val + " ");
			crnt=crnt.next;
		}
		System.out.println();
	}

}
