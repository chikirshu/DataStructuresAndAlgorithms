package com.ck.tree.common;

import java.util.*;

public class NAryNode {
	
	 public int val;
	    public List<NAryNode> children = new ArrayList<>();

	    public NAryNode() {}

	    public NAryNode(int _val) {
	        val = _val;
	    }

	    public NAryNode(int _val, List<NAryNode> _children) {
	        val = _val;
	        children = _children;
	    }

}
