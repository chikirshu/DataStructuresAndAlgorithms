package com.ck.tree.easy;

import com.ck.tree.common.TrieNode;

public class TrieOperations {

	public void insert(TrieNode root, String key) {
		TrieNode crnt = root;
		for (char c : key.toCharArray()) {
			if (crnt.children.get(c - 'a') == null) {
				crnt.children.set(c - 'a', new TrieNode());
			}
			crnt = crnt.children.get(c - 'a');
		}
		crnt.isWordEnd = true;
	}

	public TrieNode search(TrieNode root, String key) {
		TrieNode crnt = root;
		for (char c : key.toCharArray()) {
			if (crnt.children.get(c - 'a') == null)
				return null;
			crnt = crnt.children.get(c - 'a');
		}
		return crnt;
	}

	public static void main(String[] args) {

		TrieNode root = new TrieNode();
		TrieOperations op = new TrieOperations();
		op.insert(root, "techie");
		op.insert(root, "techi");
		//op.insert(root, "tech");

		System.out.println(op.search(root, "tech")==null?false:op.search(root, "tech").isWordEnd);
		System.out.println(op.search(root, "techi")==null?false:op.search(root, "techi").isWordEnd);
		System.out.println(op.search(root, "techie")==null?false:op.search(root, "techie").isWordEnd);
		System.out.println(op.search(root, "techiedelight")==null?false:op.search(root, "techiedelight").isWordEnd);

		op.insert(root, "techiedelight");

		System.out.println(op.search(root, "tech")==null?false:op.search(root, "tech").isWordEnd);
		System.out.println(op.search(root, "techi")==null?false:op.search(root, "techi").isWordEnd);
		System.out.println(op.search(root, "techie")==null?false:op.search(root, "techie").isWordEnd);
		System.out.println(op.search(root, "techiedelight")==null?false:op.search(root, "techiedelight").isWordEnd);

	}

}
