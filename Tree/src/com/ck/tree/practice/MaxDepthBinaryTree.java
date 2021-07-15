package com.ck.tree.practice;

import com.ck.tree.common.TreeNode;

public class MaxDepthBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 5;
		TreeNode node1 = new TreeNode();
		node1.val = 3;
		TreeNode node2 = new TreeNode();
		node2.val = 8;
		TreeNode node3 = new TreeNode();
		node3.val = 4;
		TreeNode node4 = new TreeNode();
		node3.val = 9;
		TreeNode node5 = new TreeNode();
		node3.val = 10;
		TreeNode node6 = new TreeNode();
		node3.val = 2;
		TreeNode node7 = new TreeNode();
		node3.val = 6;
		TreeNode node8 = new TreeNode();
		node3.val = 11;
		TreeNode node9 = new TreeNode();
		node3.val = 12;
		TreeNode node10 = new TreeNode();
		node3.val = 7;
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node6.right = node9;
		node7.left = node10;		
		
		
		System.out.println(maxDepth(root,0));
	}
	
	public static int maxDepth(TreeNode node, int crnt) {
		
		if(node==null) return 0;
		
		crnt++;
		if(node.left==null && node.right==null) {
			return crnt;
		}
		int maxDepthLeft = maxDepth(node.left,crnt);
		int maxDepthRight =  maxDepth(node.right,crnt);
		return Math.max(maxDepthLeft, maxDepthRight);
	}

}
