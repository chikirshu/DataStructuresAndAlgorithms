package com.ck.linkedlist.easy;

import java.util.Arrays;

import com.ck.linkedlist.common.ListNode;

// GFG - Sort linked list of 0s, 1s, 2s
// https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
public class Segregate_0_1_2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(0);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(2);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		displayList(head);
		displayList(segregateI(head));
		displayList(segregateII(head));
		System.out.println(Arrays.toString(segregateIII(new int[] { 1, 2, 2, 1, 2, 0, 2, 2 })));
		// Dutch National Flag -With linkedlist you will need doubly linked for
		// implementing this - no that's not true; check segregateIV
		displayList(segregateIV(head));
	}

	// Also a Dutch National Flag approach
	static ListNode segregateIV(ListNode head) {
		ListNode crntZero = new ListNode(0);
		ListNode headZero = new ListNode(0);
		ListNode crntOne = new ListNode(0);
		ListNode headOne = new ListNode(0);
		ListNode crntTwo = new ListNode(0);
		ListNode headTwo = new ListNode(0);

		crntZero = headZero;
		crntOne = headOne;
		crntTwo = headTwo;

		ListNode crnt = head;

		while (crnt != null) {
			if (crnt.val == 0) {
				crntZero.next = crnt;
				crntZero = crntZero.next;
			} else if (crnt.val == 1) {
				crntOne.next = crnt;
				crntOne = crntOne.next;
			} else {
				crntTwo.next = crnt;
				crntTwo = crntTwo.next;
			}
			crnt = crnt.next;
		}
		crntZero.next = headOne.next != null ? headOne.next : headTwo.next;
		crntOne.next = headTwo.next;
		head = headZero.next;

		return head;
	}

	// Dutch National Flag Algorithm
	static int[] segregateIII(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1, temp = 0;
		// low represents start of 1s, mid represents unknown region and high represents
		// 2s.
		while (mid != high) {
			// if arr[mid]=0 swap arr[low] and arr[mid] and do low++, mid++
			// if arr[mid]=1 do mid++;
			// if arr[mid]=2 swap arr[mid] and arr[high] and do high--
			if (arr[mid] == 0) {
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				mid++;
				low++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
		return arr;
	}

	static ListNode segregateII(ListNode head) {
		ListNode crnt = head;
		int[] cnt = new int[3];
		while (crnt != null) {
			cnt[crnt.val]++;
			crnt = crnt.next;
		}
		crnt = head;
		int i = 0;
		while (crnt != null) {
			if (cnt[i] == 0)
				i++;
			else {
				crnt.val = i;
				crnt = crnt.next;
				cnt[i]--;
			}
		}
		return head;
	}

	static ListNode segregateI(ListNode head) {
		// add your code here
		ListNode crnt = head;
		int cnt0 = 0, cnt1 = 0, cnt2 = 0;
		while (crnt != null) {
			if (crnt.val == 0)
				cnt0++;
			else if (crnt.val == 1)
				cnt1++;
			else
				cnt2++;
			crnt = crnt.next;
		}
		crnt = head;
		while (cnt0 != 0 && crnt != null) {
			crnt.val = 0;
			cnt0--;
			crnt = crnt.next;
		}
		while (cnt1 != 0 && crnt != null) {
			crnt.val = 1;
			cnt1--;
			crnt = crnt.next;
		}
		while (cnt2 != 0 && crnt != null) {
			crnt.val = 2;
			cnt2--;
			crnt = crnt.next;
		}
		return head;
	}

	private static void displayList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

}
