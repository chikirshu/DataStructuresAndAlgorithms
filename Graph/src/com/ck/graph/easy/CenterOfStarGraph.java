package com.ck.graph.easy;

// LC - 1791 : Find Center of Star Graph
// https://leetcode.com/problems/find-center-of-star-graph/
public class CenterOfStarGraph {

	public static void main(String[] args) {
		System.out.println(findCenterI(new int[][] { { 1, 2 }, { 2, 3 }, { 4, 2 } }));
		System.out.println(findCenterII(new int[][] { { 1, 2 }, { 2, 3 }, { 4, 2 } }));
	}

	// O(N) time and O(N) space
	public static int findCenterI(int[][] edges) {
		int[] arr = new int[edges.length + 1];
		for (int[] edge : edges) {
			arr[edge[0] - 1]++;
			arr[edge[1] - 1]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == edges.length)
				return i + 1;
		}

		return 0;
	}

	// O(1) time and O(1) space
	public static int findCenterII(int[][] edges) {
		return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
	}

}
