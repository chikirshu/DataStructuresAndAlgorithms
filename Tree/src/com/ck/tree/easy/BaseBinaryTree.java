package com.ck.tree.easy;

import com.ck.tree.common.BasicTreeNode;

public interface BaseBinaryTree<T> {

	public BasicTreeNode insertNode(BasicTreeNode root, T o);

	public boolean findNode(BasicTreeNode root, T o);

	public BasicTreeNode removeNode(BasicTreeNode root, T o);

	default void displayInOrderTree(BasicTreeNode root) {
		if (root == null) {
			return;
		}
		displayInOrderTree(root.left);
		System.out.print(root.val + " ");
		displayInOrderTree(root.right);
	}

}
