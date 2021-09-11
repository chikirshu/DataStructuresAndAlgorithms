package com.ck.tree.hard;

import com.ck.tree.common.ListNode;
import com.ck.tree.common.TreeNode;

// GFG - In-place conversion of Sorted DLL to Balanced BST - open
// https://www.geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-balanced-bst/
public class InPlaceSortedDLLToBalancedBST {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		displaytree(DLLToBalancedBST(head));
	}

	private static void displaytree(TreeNode root) {
		if (root == null)
			return;
		displaytree(root.left);
		System.out.print(root.val + " ");
		displaytree(root.right);
	}

	public static TreeNode DLLToBalancedBST(ListNode head) {
		ListNode crnt = head;
		int cnt = 0;
		while (crnt != null) {
			crnt = crnt.next;
			cnt++;
		}
		TreeNode root = new TreeNode();
		return assignTreeNodes(root, head, 0, cnt);
	}

	private static TreeNode assignTreeNodes(TreeNode root, ListNode head, int start, int end) {
		if (end <= start)
			return null;
		int crnt = 0;
		ListNode node = head;
		while (node != null && end > 0 && crnt != (end - start) / 2) {
			node = node.next;
			crnt++;
		}
		if (node == null)
			return null;
		root.val = node.val;
		root.left = assignTreeNodes(new TreeNode(), head, start, crnt);
		root.right = assignTreeNodes(new TreeNode(), node, crnt + 1, end);
		return root;
	}

}
