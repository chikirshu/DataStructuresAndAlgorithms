package com.ck.tree.common;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	
	public static final int ALPHABET_SIZE = 26;
	public List<TrieNode> children;
	public boolean isWordEnd;
	
	public TrieNode(){
		isWordEnd = false;
		children = new ArrayList<>();
		for(int i=0;i<ALPHABET_SIZE;i++) {
			children.add(null);
		}
	}

}
