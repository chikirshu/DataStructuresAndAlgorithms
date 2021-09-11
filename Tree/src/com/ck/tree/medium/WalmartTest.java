package com.ck.tree.medium;

import java.util.Stack;

import com.ck.tree.common.TreeNode;

public class WalmartTest {

	// 1.left = 2
	// 1.right = 3
	// 2.left = 4
	// 2.right = 5
	// 3.left = 6
	// 3.right = 7
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 1;
		TreeNode node1 = new TreeNode();
		node1.val = 2;
		TreeNode node2 = new TreeNode();
		node2.val = 3;
		TreeNode node3 = new TreeNode();
		node3.val = 4;
		TreeNode node4 = new TreeNode();
		node4.val = 5;
		TreeNode node5 = new TreeNode();
		node5.val = 6;
		TreeNode node6 = new TreeNode();
		node6.val = 7;
		TreeNode node7 = new TreeNode();
		node7.val = 8;
		TreeNode node8 = new TreeNode();
		node8.val = 9;
		TreeNode node9 = new TreeNode();
		node9.val = 10;
		TreeNode node10 = new TreeNode();
		node10.val = 11;
		TreeNode node11 = new TreeNode();
		node11.val = 12;
		TreeNode node12 = new TreeNode();
		node12.val = 13;
		TreeNode node13 = new TreeNode();
		node13.val = 14;
		TreeNode node14 = new TreeNode();
		node14.val = 15;

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		node4.left = node9;
		node4.right = node10;
		node5.left = node11;
		node5.right = node12;
		node6.left = node13;
		node6.right = node14;

		traverseTree(root);

	}

	// 1
	// 2 3
	// 4 5 6 7
	// 8 9 10 11 12 13 14 15
	// nodes in that level
	// l r // stk1
	// r l // stk2 15 14 13 12 11 10 9 8
	// ans 1 2 3 7 6 5 4
	public static void traverseTree(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stk1 = new Stack<>();
		Stack<TreeNode> stk2 = new Stack<>();

		stk1.push(root);
		while (!stk1.isEmpty() || !stk2.isEmpty()) {
			TreeNode node = new TreeNode();
			while (!stk1.isEmpty()) {
				node = stk1.pop();
				System.out.print(node.val + " ");
				if (node.right != null)
					stk2.add(node.right);
				if (node.left != null)
					stk2.add(node.left);

			}
			while (!stk2.isEmpty()) {
				node = stk2.pop();
				System.out.print(node.val + " ");
				if (node.left != null)
					stk1.add(node.left);
				if (node.right != null)
					stk1.add(node.right);
			}

		}
	}
}
