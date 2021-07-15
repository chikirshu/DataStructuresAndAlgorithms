package com.ck.tree.easy;

import com.ck.tree.common.TreeNode;

public class RemoveNodeFromBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 50;
		TreeNode node1 = new TreeNode();
		node1.val = 25;
		TreeNode node2 = new TreeNode();
		node2.val = 75;
		TreeNode node3 = new TreeNode();
		node3.val = 12;
		TreeNode node4 = new TreeNode();
		node4.val = 37;
		TreeNode node5 = new TreeNode();
		node5.val = 62;
		TreeNode node6 = new TreeNode();
		node6.val = 87;
		TreeNode node7 = new TreeNode();
		node7.val = 30;
		TreeNode node8 = new TreeNode();
		node8.val = 40;
		TreeNode node9 = new TreeNode();
		node9.val = 60;
		TreeNode node10 = new TreeNode();
		node10.val = 70;

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node4.left = node7;
		node4.right = node8;
		node5.left = node9;
		node5.right = node10;
		displayTree(root);
		removeNode(root, 50);
		System.out.println();
		displayTree(root);
	}

	public static TreeNode removeNode(TreeNode node, int val) {
		if (node == null)
			return null;
		if (node.val > val) {
			node.left = removeNode(node.left, val);
		} else if (node.val < val) {
			node.right = removeNode(node.right, val);
		}else {
			if(node.left!=null && node.right!=null) {
				int leftMax = findMax(node.left, Integer.MIN_VALUE);
				node.val=leftMax;
				node.left = removeNode(node.left,leftMax);
				return node;
			}
			else  if(node.left!=null) {
				return node.left;
			}
			else if(node.right!=null) {
				return node.right;
			}
			else {
				return null;
			}
		}
		return node;
	}

	private static int findMax(TreeNode node, int max) {
		if(node==null) return Integer.MIN_VALUE;
		max = Math.max(max, node.val);
		int max1 = findMax(node.right,max);
		return Math.max(max, max1);
	}

	// InOrder Traversal
	public static void displayTree(TreeNode root) {
		if (root == null) {
			return;
		}
		displayTree(root.left);
		System.out.print(root.val + " ");
		displayTree(root.right);
	}

}
