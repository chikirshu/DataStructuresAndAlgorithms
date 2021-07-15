package com.ck.linkedlist.easy;

import java.util.HashSet;
import java.util.Set;

import com.ck.linkedlist.common.ListNode;

// LC - 141 : Linked List Cycle 
public class DetectCycle {

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
		node5.next = node2;

		// Using hashing
		System.out.println(hasCycleI(head));

		// Using Floyd's Algorithm - Two Pointers
		System.out.println(hasCycleII(head));
	}

	public static boolean hasCycleI(ListNode head) {

		Set<ListNode> set = new HashSet<>();
		ListNode crnt = head;
		while (crnt != null) {
			if (!set.contains(crnt)) {
				set.add(crnt);
				crnt = crnt.next;
			} else {
				return true;
			}
		}
		return false;
	}

	public static boolean hasCycleII(ListNode head) {

		ListNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
