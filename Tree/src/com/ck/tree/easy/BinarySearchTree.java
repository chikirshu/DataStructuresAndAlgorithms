package com.ck.tree.easy;

import com.ck.tree.common.BasicTreeNode;

public class BinarySearchTree<T> implements BaseBinaryTree<T> {

	@Override
	public BasicTreeNode insertNode(BasicTreeNode root, T o) {
		if (root == null) {
			BasicTreeNode temp = new BasicTreeNode(o);
			return temp;
		}
		// No Duplicates allow
		if (o instanceof Integer) {
			if ((Integer) o > (Integer) root.val) {
				root.right = insertNode(root.right, o);
			} else if ((Integer) o < (Integer) root.val) {
				root.left = insertNode(root.left, o);
			}
		} else if (o instanceof MyClass) {
			MyComparator mc = new MyComparator();
			if (mc.compare((MyClass) o, (MyClass) root.val) > 0) {
				root.right = insertNode(root.right, o);
			} else if (mc.compare((MyClass) o, (MyClass) root.val) < 0) {
				root.left = insertNode(root.left, o);
			}
		}
		return root;
	}

	@Override
	public boolean findNode(BasicTreeNode root, T o) {
		if (root == null) {
			return false;
		}
		boolean res = false;
		if (o instanceof Integer) {
			if ((Integer) o == (Integer) root.val)
				return true;
			else if (((Integer) o) > ((Integer) root.val)) {
				res = findNode(root.right, o);
			} else {
				res = findNode(root.left, o);
			}
		} else if (o instanceof MyClass) {
			MyComparator mc = new MyComparator();
			if (mc.compare((MyClass) o, (MyClass) root.val) == 0)
				return true;
			else if (mc.compare((MyClass) o, (MyClass) root.val) > 0) {
				res = findNode(root.right, o);
			} else {
				res = findNode(root.left, o);
			}
		}
		return res;
	}

	@Override
	public BasicTreeNode removeNode(BasicTreeNode root, T o) {
		if (root == null)
			return null;
		if (o instanceof Integer) {
			if ((Integer) o > (Integer) root.val) {
				root.right = removeNode(root.right, o);
			} else if ((Integer) o < (Integer) root.val) {
				root.left = removeNode(root.left, o);
			} else {
				if (root.left != null && root.right != null) {
					Integer val = (Integer) findMaxObject(root.left,o, (T) (Integer)0);
					root.val = val;
					root.left = removeNode(root.left, (T) val);
				} else if (root.left != null) {
					return root.left;
				} else if (root.right != null) {
					return root.right;
				} else {
					return null;
				}
			}
		} else if (o instanceof MyClass) {
			MyComparator mc = new MyComparator();
			if (mc.compare((MyClass) o, (MyClass) root.val) > 0) {
				root.right = removeNode(root.right, o);
			} else if (mc.compare((MyClass) o, (MyClass) root.val) < 0) {
				root.left = removeNode(root.left, o);
			} else {
				if (root.left != null && root.right != null) {
					MyClass val = (MyClass) findMaxObject(root.left,o, (T) root.left.val);
					root.val = val;
					root.left = removeNode(root.left, (T) val);
				} else if (root.left != null) {
					return root.left;
				} else if (root.right != null) {
					return root.right;
				} else {
					return null;
				}
			}

		}
		return root;

	}

	private T findMaxObject(BasicTreeNode node,T o, T max) {
		if(node==null) return max;
		if(o instanceof Integer) {
			if ((Integer)max < (Integer) node.val) {
				max = (T)node.val;
				T max2 = findMaxObject(node.right,o, max);
				max = (Integer)max>(Integer)max2 ? max : max2;
			}
		}
		else if(o instanceof MyClass) {
			MyComparator mc = new MyComparator();
			if (mc.compare((MyClass)max, (MyClass) node.val) > 0) {
				max = (T)node.val;
				T max2 = findMaxObject(node.right, o, max);
				max = mc.compare((MyClass)max, (MyClass)max2) > 0 ? max : max2;
			}
		} 
		
		return max;
	}

}
