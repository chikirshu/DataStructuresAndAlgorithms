package com.ck.graph.medium;

public class ReorderRoutesToLeadToZero {

	public static void main(String[] args) {
		// System.out.println(minReorder(4,new int[][] {{0,1},{2,0},{3,2}}));
		System.out.println(minReorder(6, new int[][] { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } }));
	}

	public static int minReorder(int n, int[][] connections) {
		int[] visited = new int[n];
		int res = 0;
		for (int[] edge : connections) {
			if (edge[0] == 0) {
				// check for outdegree for 0 - ++
				visited[0]++;
			} else {
				// check for indegree - ++
				if (edge[1] != 0) {
					visited[edge[1]]++;
				}
				// check for outdegree - --
				visited[edge[0]]--;
			}

		}
		for (int i = 0; i < visited.length; i++) {
			if (i == 0)
				res += visited[0];
			else if (visited[i] >= 0)
				res++;
		}
		return res;
	}

}
