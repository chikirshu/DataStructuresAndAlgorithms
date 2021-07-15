package com.ck.tree.medium;

import java.util.ArrayList;
import java.util.List;

import com.ck.tree.common.TreeNode;

// GFG - Min distance between two given nodes of a Binary Tree 
// https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1#
public class ShortestPathBetweenTwoNodes {

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
		
		System.out.println(findDist(root, 9,11));
	}
	public static int findDist(TreeNode root, int a, int b) {
		int i=0,distLcaFromRoot=0;
        boolean flgDiff = false;
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root,a,path1);
        findPath(root,b,path2);
        for(i=0;i<path1.size() && i<path2.size();i++){
            if(!path1.get(i).equals(path2.get(i))) break;
        }
        distLcaFromRoot= i==0?i:i-1; 
        /*System.out.println("distLcaFromRoot = "+distLcaFromRoot+" path1 size = "+path1.size()+" path2 size = "+path2.size());
        System.out.println("Path1");
        for(Node n : path1){
            System.out.print(n.data+" ");
        }
        System.out.println("\nPath2");
        for(Node n : path2){
            System.out.print(n.data+" ");
        }*/
        return (path1.size()-1)+(path2.size()-1)-2*distLcaFromRoot;
    }
    private static boolean findPath(TreeNode node, int val, List<TreeNode> path){
        if(node==null) return false;
        path.add(node);
        if(node.val==val) return true;
        
        boolean found = findPath(node.left,val,path);
        if(!found) found = findPath(node.right,val,path);
        
        if(!found) {
        	path.remove(node);
            return false;
        }
        return true;
    }

}
