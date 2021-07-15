package com.ck.linkedlist.easy;

import com.ck.linkedlist.common.ListNode;

public class ListsIntersection {

	public static void main(String[] args) {
		ListNode headA = new ListNode(4);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(8);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		headA.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode headB = new ListNode(5);
		ListNode node2B = new ListNode(6);
		ListNode node3B = new ListNode(1);
		// ListNode node4B = new ListNode(8);
		// ListNode node5B = new ListNode(4);
		// ListNode node6B = new ListNode(5);

		headB.next = node2B;
		node2B.next = node3B;
		node3B.next = node3;
		System.out.println(getIntersectionNode(headA, headB).val);
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode crnt1 = headA, crnt2 = headB, res = null;
		int cnt1 = 0, cnt2 = 0, d = 0;

		cnt1 = findLengthOfList(crnt1);
		cnt2 = findLengthOfList(crnt2);

		if (cnt1 >= cnt2) {
			d = cnt1 - cnt2;
			res = traverseListToIntersection(headA, headB, d);
		} else {
			d = cnt2 - cnt1;
			res = traverseListToIntersection(headB, headA, d);
		}
		return res;
	}

	private static int findLengthOfList(ListNode crnt) {
		int cnt = 0;

		while (crnt != null) {
			cnt++;
			crnt = crnt.next;
		}
		return cnt;
	}

	private static ListNode traverseListToIntersection(ListNode large, ListNode small, int dist) {
		for (int i = 0; i < dist; i++) {
			large = large.next;
		}
		while (large != null && small != null) {
			if (large == small) {
				return large;
			}
			large = large.next;
			small = small.next;
		}
		return null;
	}

}
