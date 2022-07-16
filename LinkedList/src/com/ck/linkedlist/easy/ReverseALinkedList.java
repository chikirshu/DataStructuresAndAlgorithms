package com.ck.linkedlist.easy;

import com.ck.linkedlist.common.ListNode;

// G2G - Reverse a linked list 
// https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1#
// LC - 206 : Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/
public class ReverseALinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		displayList(head);
		displayList(reverseList(head));
	}

	private static void displayList(ListNode head) {
		while (head != null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode reverseList(ListNode head) {
		// code here
		ListNode prev = null, crnt = head, next = null;
		while (crnt != null) {
			next = crnt.next;
			crnt.next = prev;
			prev = crnt;
			crnt = next;
		}
		return prev;
	}

}
