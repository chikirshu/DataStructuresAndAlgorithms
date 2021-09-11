package com.ck.tree.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ck.tree.common.TrieNode;
import com.ck.tree.easy.TrieOperations;

public class Boggle {

	public static void main(String[] args) {
		String[] words = new String[] { "apple", "pickle", "side", "kick", "sick", "mood", "cat", "cats", "man",
				"super", "autmn", "antman", "godzilla", "dog", "dot", "sine", "cos", "signal", "bitcoin", "cool",
				"zapper" };
		TrieNode root = new TrieNode();
		TrieOperations op = new TrieOperations();
		for (String word : words) {
			op.insert(root, word);
		}
		char[][] boggle = new char[][] { { 'c', 'n', 't', 's', 's' }, 
										 { 'd', 'a', 't', 'i', 'n' },
										 { 'o', 'o', 'm', 'e', 'l' }, 
										 { 's', 'i', 'k', 'n', 'd' }, 
										 { 'p', 'i', 'c', 'l', 'e' } };
		boolean[][] visited = new boolean[boggle.length][boggle.length];
		Set<String> ans = new HashSet<>();
		for(int i =0;i<visited.length;i++) {
			for(int j=0;j<visited.length;j++) {
				if(!visited[i][j])findInBoggle(boggle, root, visited,i,j,"",ans);
			}
		}
		System.out.println(ans);
	}

	private static void findInBoggle(char[][] boggle, TrieNode root, boolean[][] visited, int row, int col, String crnt, Set<String> ans) {
		if(root==null || row<0 || col<0 || row>=boggle.length || col>=boggle.length || visited[row][col]) {
			return;
		}
		TrieOperations op = new TrieOperations();
		
		visited[row][col]=true;
		crnt+=String.valueOf(boggle[row][col]);
		TrieNode temp = op.search(root, crnt);
		if(temp==null) {
			visited[row][col]=false;
			return;
		}
		else if(temp.isWordEnd) ans.add(crnt);
		//anti clockwise
		findInBoggle(boggle,root,visited,row-1,col,crnt,ans);//top
		findInBoggle(boggle,root,visited,row-1,col-1,crnt,ans);//top-left
		findInBoggle(boggle,root,visited,row,col-1,crnt,ans);//left
		findInBoggle(boggle,root,visited,row+1,col-1,crnt,ans);//bottom-left
		findInBoggle(boggle,root,visited,row+1,col,crnt,ans);//bottom
		findInBoggle(boggle,root,visited,row+1,col+1,crnt,ans);//bottom-right
		findInBoggle(boggle,root,visited,row,col+1,crnt,ans);//right
		findInBoggle(boggle,root,visited,row-1,col+1,crnt,ans);//top-right
		visited[row][col]=false;
	}

}
