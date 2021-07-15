package com.ck.linkedlist.medium;

import com.ck.linkedlist.common.ListNode;

// LC - 142 : Linked List Cycle II
public class DetectCycleStartPoint {

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
		node5.next = head;
		System.out.println(detectCycle(head).val);
	}

	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head, res = null;
		boolean hasCycle = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
			
		}
		if (hasCycle) {
			// one of the other way to find the starting of the loop
			// res=detectStartPoint(slow,head);

			// this is better solution which also works
			slow = head;
			/* Below part is if you want to remove cycle from the list
			 * if(flgHasCycle){ 
			 * 	// if it is a circular list 
			 * 	if(fast==head){ 
			 * 		while(slow.next!=head){ 
			 * 			slow=slow.next;
			 * 		}
			 * 		prev = slow; 
			 * 	} 
			 *  else{ 
			 *  	while(slow!=fast){ 
			 *  		prev = fast; 
			 *  		slow=slow.next;
			 * 			fast=fast.next; 
			 * 		} 
			 * 	}
			 *  prev.next=null; 
			 * }
			 */
			while (slow != fast) {
				System.out.println("Slow value = " + slow.val);
				slow = slow.next;
				fast = fast.next;
			}
			res = slow;
		}
		return res;
	}

	private static ListNode detectStartPoint(ListNode loop, ListNode head) {
		ListNode ptr1 = head, ptr2 = null;
		while (true) {
			ptr2 = loop;
			while (ptr2.next != ptr1 && ptr2.next != loop) {
				ptr2 = ptr2.next;
			}
			if (ptr2.next == ptr1)
				break;

			ptr1 = ptr1.next;
		}
		return ptr1;
	}

}
