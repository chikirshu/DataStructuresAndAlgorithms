
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 10;
		TreeNode node1 = new TreeNode();
		node1.val = 7;
		TreeNode node2 = new TreeNode();
		node2.val = 15;
		TreeNode node3 = new TreeNode();
		node3.val = 9;
		TreeNode node4 = new TreeNode();
		node4.val = 11;

		root.left = node1;
		root.right = node2;
		node1.right = node3;
		node2.left = node4;
		System.out.println(isSymmetric(root));
	}

	private static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return compareNode(root.left, root.right);
	}

	private static boolean compareNode(TreeNode left, TreeNode right) {

		boolean res = false;
		if ((left == null && right != null) || (left != null && right == null)) {
			return false;
		} else if (left == null && right == null) {
			return true;
		}
		if (left.val == right.val) {
			res = compareNode(left.left, right.right);
			if (res) {
				res = compareNode(left.right, right.left);
			}
		} else {
			return false;
		}
		return res;
	}

}
