package com.ck.tree.medium;

import com.ck.tree.common.TreeNode;

// G2G - Check for Balanced Tree
// Note : Height balancing concept is also used in AVL Trees
// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1#
public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 10;
		TreeNode node1 = new TreeNode();
		node1.val = 20;
		TreeNode node2 = new TreeNode();
		node2.val = 30;
		TreeNode node3 = new TreeNode();
		node3.val = 40;
		TreeNode node4 = new TreeNode();
		node4.val = 50;

		root.left = node1;
		//root.right = node2;
		//node1.left = node3;
		//node1.right = node4;
		System.out.println(isBalanced(root));
	}

	public static boolean isBalanced(TreeNode root) {
		// Your code here
		if (root == null)
			return true;
		int lh = height(root.left) - 1; // minus the root itself
		int rh = height(root.right) - 1;

		if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;
	}

	public static int height(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

}
