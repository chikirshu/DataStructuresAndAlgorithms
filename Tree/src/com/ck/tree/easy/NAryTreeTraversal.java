package com.ck.tree.easy;

import java.util.*;

import com.ck.tree.common.NAryNode;

// LC - 589: N-ary Tree Preorder Traversal
// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class NAryTreeTraversal {

	public static void main(String[] args) {
		NAryNode root = new NAryNode(1);
		
		List<NAryNode> list1 = new ArrayList<>();
		NAryNode node1 = new NAryNode(3);
		NAryNode node2 = new NAryNode(2);
		NAryNode node3 = new NAryNode(4);
		list1.add(node1);
		list1.add(node2);
		list1.add(node3);
		root.children = list1;
		
		List<NAryNode> list2 = new ArrayList<>();
		NAryNode node4 = new NAryNode(5);
		NAryNode node5 = new NAryNode(6);
		list2.add(node4);
		list2.add(node5);
		node1.children = list2;
		
		System.out.println(preorder(root));
	}
	
	public static List<Integer> preorder(NAryNode root) {
        return printPreOrder(root, new ArrayList<>());
    }
    
    public static List<Integer> printPreOrder(NAryNode root, List<Integer> list){
        if(root==null)
            return list;
        list.add(root.val);
        for(NAryNode node : root.children){
            printPreOrder(node,list);
        }
        return list;
    }
}
