package com.ck.tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ck.tree.common.TreeNode;

// LC - 102 : Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(-1);
		TreeNode node6 = new TreeNode(5);
		TreeNode node7 = new TreeNode(1);
		TreeNode node8 = new TreeNode(6);
		TreeNode node9 = new TreeNode(8);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.right = node8;
		node5.right = node9;
		
		System.out.println(levelOrder(root)); 
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {


		List<List<Integer>> list = new ArrayList<>();

		if (root == null)
			return list;

		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();

		queue1.add(root);
		while (!queue1.isEmpty() || !queue2.isEmpty()) {

			List<Integer> listEven = new ArrayList<>();
			List<Integer> listOdd = new ArrayList<>();

			while (!queue1.isEmpty()) {
				TreeNode node = queue1.poll();
				listEven.add(node.val);
				if (node.left != null)
					queue2.add(node.left);
				if (node.right != null)
					queue2.add(node.right);

			}

			while (!queue2.isEmpty()) {
				TreeNode node = queue2.poll();
				listOdd.add(node.val);
				if (node.left != null)
					queue1.add(node.left);
				if (node.right != null)
					queue1.add(node.right);

			}

			if (listEven.size() > 0)
				list.add(listEven);
			if (listOdd.size() > 0)
				list.add(listOdd);
		}
		return list;
	}

}
