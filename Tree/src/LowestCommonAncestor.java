import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 5;
		TreeNode node1 = new TreeNode();
		node1.val = 2;
		TreeNode node2 = new TreeNode();
		node2.val = 3;
		TreeNode node3 = new TreeNode();
		node3.val = 4;
		root.left = node1;
		node1.left = node2;
		node1.right = node3;

		System.out.println(lca(root, 3, 4).val);
	}

	private static TreeNode lca(TreeNode root, int n1, int n2) {

		TreeNode resNode = new TreeNode(-1);
		List<TreeNode> roots1 = new ArrayList<>();

		roots1 = findRoots(root, n1, roots1);
		for (TreeNode n : roots1) {
			if (findChild(n, n2) != null) {
				resNode = n;
				break;
			}
		}
		return resNode;
	}

	private static List<TreeNode> findRoots(TreeNode root, int n, List<TreeNode> roots) {
		if (root == null) {
			return new ArrayList<>();
		}
		if (root.val == n) {
			roots.add(root);
			return roots;
		}

		List<TreeNode> crntRoots = findRoots(root.left, n, roots);
		if (crntRoots.size() > 0 && !crntRoots.contains(root)) {
			crntRoots.add(root);
		} else {
			crntRoots = findRoots(root.right, n, roots);
			if (crntRoots.size() > 0 && !crntRoots.contains(root)) {
				crntRoots.add(root);
			}
		}
		return crntRoots;
	}

	private static TreeNode findChild(TreeNode root, int n) {
		if (root == null) {
			return null;
		}

		if (root.val == n) {
			return root;
		}
		TreeNode res = findChild(root.left, n);
		if (res == null) {
			res = findChild(root.right, n);
		}
		return res;
	}

}
