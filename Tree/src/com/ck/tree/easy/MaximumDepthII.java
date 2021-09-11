package com.ck.tree.easy;

import java.util.Scanner;

// OLA Test - Open
public class MaximumDepthII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] edges = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}
		System.out.println(maxDepth(n, edges));
	}

	private static int maxDepth(int n, int[][] edges) {
		return findMaxDepth(edges, 1, edges[0][0]);
	}

	private static int findMaxDepth(int[][] edges, int maxDepth, int parent) {
		int localDepth = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] == parent) {
				localDepth = findMaxDepth(edges, maxDepth + 1, edges[i][1]);
				if (localDepth >= maxDepth)
					maxDepth = localDepth;
			}
		}
		return maxDepth-1;
	}

}
