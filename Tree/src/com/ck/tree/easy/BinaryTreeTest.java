package com.ck.tree.easy;

import com.ck.tree.common.BasicTreeNode;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BaseBinaryTree<Integer> bstI = new BinarySearchTree<>();
		BasicTreeNode root = new BasicTreeNode(50);
		bstI.insertNode(root, 25);
		bstI.insertNode(root, 75);
		bstI.insertNode(root, 12);
		bstI.insertNode(root, 37);
		bstI.insertNode(root, 62);
		bstI.insertNode(root, 87);
		bstI.insertNode(root, 30);
		bstI.insertNode(root, 40);
		bstI.insertNode(root, 60);
		bstI.insertNode(root, 70);
		System.out.println("Inorder Traversal");
		bstI.displayInOrderTree(root);
		bstI.removeNode(root, 50);
		System.out.println("\nRemoved node " + 50);
		bstI.displayInOrderTree(root);
		
		BaseBinaryTree<MyClass> bstII = new BinarySearchTree<>();
		BasicTreeNode root2 = new BasicTreeNode(new MyClass(1,"JohnM",40));
		MyClass node2 = new MyClass(2,"DavidP",40); 
		bstII.insertNode(root2,node2 );
		bstII.insertNode(root2, new MyClass(3,"RamanujaM",50));
		bstII.insertNode(root2, new MyClass(4,"SteveS",30));
		bstII.insertNode(root2, new MyClass(5,"FarkR",40));
		System.out.println("\nInorder Traversal");
		bstII.displayInOrderTree(root2);
		bstII.removeNode(root2, node2);
		System.out.println("\nRemoved node " + node2);
		bstII.displayInOrderTree(root2);
	}

}
