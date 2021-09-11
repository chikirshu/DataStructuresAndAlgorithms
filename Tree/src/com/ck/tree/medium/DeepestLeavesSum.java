package com.ck.tree.medium;

import java.util.LinkedList;

import com.ck.tree.common.TreeNode;

// LC - 1302 : Deepest Leaves Sum
// https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		node3.left = node6;
		node5.right = node7;

		System.out.println(deepestLeavesSumI(root));
		System.out.println(deepestLeavesSumII(root));
	}

	// Simpler approach - BFS - level wise sum
	public static int deepestLeavesSumII(TreeNode root) {
		int res = 0, i, lvl = 0, cnt = 0;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			System.out.println("lvl " + lvl++ + " - " + q.size());
			for (i = q.size() - 1, res = 0; i >= 0; --i) {
				TreeNode node = q.poll();
				res += node.val;
				if (node.right != null)
					q.add(node.right);
				if (node.left != null)
					q.add(node.left);
				cnt++;
			}
		}
		System.out.println("It ran for " + cnt + " loops."); // O(V+E) V - Vertices, E - Edges
		return res;
	}

	// Complex Approach - DFS
	public static int deepestLeavesSumI(TreeNode root) {
		int depth = findDepth(root);
		return sumAtDepth(root, depth, 1, 0);
	}

	private static int findDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(findDepth(root.left), findDepth(root.right));
	}

	private static int sumAtDepth(TreeNode root, int d, int crntLvl, int sum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null && crntLvl == d)
			return sum + root.val;
		int sum1 = sumAtDepth(root.left, d, crntLvl + 1, sum);
		int sum2 = sumAtDepth(root.right, d, crntLvl + 1, Math.max(sum, sum1));
		return Math.max(sum1, sum2); // Sum2 can be 0 or can be a greater number than sum1
	}

}
