package com.ck.tree.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.ck.tree.common.TreeNode;

// LC - 1379 : Find a Corresponding Node of a Binary Tree in a Clone of That Tree
// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class CorrespndingNodeInCloneTree {

	public static void main(String[] args) {

		TreeNode target = new TreeNode();
		TreeNode rootA = new TreeNode(7);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(19);

		rootA.left = node1;
		rootA.right = node2;
		node2.left = node3;
		node2.right = node4;
		target = node2;

		TreeNode rootB = new TreeNode(7);
		node1 = new TreeNode(4);
		node2 = new TreeNode(3);
		node3 = new TreeNode(6);
		node4 = new TreeNode(19);

		rootB.left = node1;
		rootB.right = node2;
		node2.left = node3;
		node2.right = node4;

		System.out.println(getTargetCopyI(rootA, rootB, target).val);
		System.out.println(getTargetCopyI(rootA, rootB, target).val);

	}

	// DFS approach
	public static final TreeNode getTargetCopyII(final TreeNode original, final TreeNode cloned,
			final TreeNode target) {
		if (original == null || original == target)
			return cloned;
		TreeNode res = getTargetCopyII(original.left, cloned.left, target);
		if (res != null)
			return res;
		return getTargetCopyII(original.right, cloned.right, target);
	}

	// BFS approach
	public static final TreeNode getTargetCopyI(final TreeNode original, final TreeNode cloned, final TreeNode target) {

		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		boolean found = false;
		q1.add(original);
		q2.add(cloned);

		while (!q1.isEmpty()) {
			for (int i = q1.size() - 1; i >= 0; i--) {
				if (q1.peek() == target) {
					found = true;
					break;
				}
				TreeNode temp1 = q1.poll();
				if (temp1.left != null)
					q1.add(temp1.left);
				if (temp1.right != null)
					q1.add(temp1.right);

				TreeNode temp2 = q2.poll();
				if (temp2.left != null)
					q2.add(temp2.left);
				if (temp2.right != null)
					q2.add(temp2.right);
			}
			if (found)
				return q2.peek();
		}
		return null;
	}

}
