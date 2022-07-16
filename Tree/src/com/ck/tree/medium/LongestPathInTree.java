package com.ck.tree.medium;

import com.ck.tree.common.TreeNode;

public class LongestPathInTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 0;
		TreeNode node1 = new TreeNode();
		node1.val = 1;
		TreeNode node2 = new TreeNode();
		node2.val = 2;
		TreeNode node3 = new TreeNode();
		node3.val = 6;
		TreeNode node4 = new TreeNode();
		node4.val = 4;
		TreeNode node5 = new TreeNode();
		node1.val = 3;
		TreeNode node6 = new TreeNode();
		node2.val = 2;
		TreeNode node7 = new TreeNode();
		node3.val = 6;
		TreeNode node8 = new TreeNode();
		node8.val = 4;
		
		root.left = node1;
		root.right = node2;
		node1.right = node3;
		node2.left = node4;
	}

}
