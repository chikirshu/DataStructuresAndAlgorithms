package com.ck.linkedlist.easy;

import com.ck.linkedlist.common.ListNode;

// GFG - Find N'th node from the end of the list.
public class NthNodeFromBack {

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
		
		// fast and slow pointer approach; 
		// reverse a list and give the n'th node from start; 
		// count the no. of nodes in 1st loop and then traverse till len-n-1
		findNthodeFromLastTwoPointer(head, 1);
	}

	private static void findNthodeFromLastTwoPointer(ListNode head, int n) {
		
		ListNode slow = head, fast = head;
		int cnt=0;
		
		while(cnt<n) {
			if(fast==null) {
				System.out.println(n + " is greater than the number of nodes in the list.");
				return;
			}
			fast = fast.next;
			cnt++;
		}
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		System.out.println(slow.val);;
	}

}
