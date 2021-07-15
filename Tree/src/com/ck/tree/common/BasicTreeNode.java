package com.ck.tree.common;

public class BasicTreeNode {

	public Object val;
	public BasicTreeNode left;
	public BasicTreeNode right;

	public BasicTreeNode() {
	}

	public BasicTreeNode(Object val) {
		this.val = val;
	}

	public BasicTreeNode(Object val, BasicTreeNode left, BasicTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
