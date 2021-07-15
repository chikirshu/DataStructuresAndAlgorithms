package com.ck.graph.medium;

import java.util.ArrayList;
import java.util.List;

// LC - 1557 : Minimum Number of Vertices to Reach All Nodes
// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
public class MinimumVerticesToCoverAllNodes {

	public static void main(String[] args) {
		List<List<Integer>> edges = new ArrayList<>();
		List<Integer> edge = new ArrayList<>();
		edge.add(0);
		edge.add(2);
		edges.add(edge);
		edge = new ArrayList<>();
		edge.add(2);
		edge.add(4);
		edges.add(edge);
		edge = new ArrayList<>();
		edge.add(3);
		edge.add(0);
		edges.add(edge);
		edge = new ArrayList<>();
		edge.add(3);
		edge.add(1);
		edges.add(edge);

		System.out.println(findSmallestSetOfVerticesI(5, edges)); // wrong answer
		System.out.println(findSmallestSetOfVerticesII(5, edges));
	}
	
	// outdegree is the answer
	public static List<Integer> findSmallestSetOfVerticesII(int n, List<List<Integer>> edges) {
		List<Integer> res = new ArrayList<>();
		int[] visitedNodes = new int[n];
		for(List<Integer> edge : edges) {
			visitedNodes[edge.get(1)] = 1;
		}
		for(int i=0;i<n;i++) {
			if(visitedNodes[i]==0) res.add(i);
		}
		return res;
	}

	// Getting very complex not giving correct result after 2 hours
	public static List<Integer> findSmallestSetOfVerticesI(int n, List<List<Integer>> edges) {
		List<Integer> res = new ArrayList<>();
		List<Integer> visitedNodes = new ArrayList<>();
		traverseUnVisitedVertices(n, 0, edges, res, visitedNodes, 0);
		return res;
	}

	public static void traverseUnVisitedVertices(int n, int rootNode, List<List<Integer>> edges, List<Integer> res,
			List<Integer> visitedNodes, int crntEdge) {

		if (visitedNodes.size() == n - 1) {
			res.add(rootNode);
			return;
		}

		for (int i = crntEdge; i < edges.size(); i++) {
			if (edges.get(i).get(0) == rootNode) {
				if (!visitedNodes.contains(edges.get(i).get(0)))
					visitedNodes.add(edges.get(i).get(0));

				if (!visitedNodes.contains(edges.get(i).get(1))) {
					visitedNodes.add(edges.get(i).get(1));
					traverseUnVisitedVertices(n, edges.get(i).get(1), edges, res, visitedNodes, i + 1);
				}
					
				if (!res.contains(edges.get(i).get(0))) {
					if (res.contains(edges.get(i).get(1))) {
						res.remove(edges.get(i).get(1)); // hope it will remove object and not index
					}
					res.add(edges.get(i).get(0));
					if (rootNode != n - 1)
						rootNode = rootNode + 1;
				}
				
			} else {
				return;
			}

		}
	}

}
