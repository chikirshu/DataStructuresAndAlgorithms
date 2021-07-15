package com.ck.graph.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.youtube.com/watch?v=6Fw4jYtP6jU&list=PLpO3gASfJEIJ6cYs4kAY3SnH2kpohSTZI&index=5
public class GraphTraversal_DFS_BFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices ");
		int v = sc.nextInt();
		System.out.println("Enter no. of edges");
		int e = sc.nextInt();
		System.out.println("Enter Edges:");
		int[][] adjMatrix = new int[v][v];
		// Undirected Graph with vertices from 0 to n-1
		for (int i = 0; i < e; i++) {
			int startV = sc.nextInt();
			int endV = sc.nextInt();
			adjMatrix[startV][endV] = 1;
			adjMatrix[endV][startV] = 1;
		}
		System.out.println("Print DFS");
		printDFS(adjMatrix);

		System.out.println("\nPrint BFS");
		printBFS(adjMatrix);
	}

	private static void printBFS(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		for (int i = 0; i < adjMatrix.length; i++) {
			if (!visited[i]) {
				printBFSHelper(adjMatrix, visited, i);
			}
		}
	}

	private static void printBFSHelper(int[][] adjMatrix, boolean[] visited, int root) {
		Queue<Integer> q = new LinkedList<>();

		q.add(root);
		visited[root] = true;
		while (!q.isEmpty()) {
			int front = q.poll();
			System.out.print(front + " ");
			for (int i = 0; i < adjMatrix.length; i++) {
				if (adjMatrix[front][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void printDFS(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		for (int i = 0; i < adjMatrix.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				printDFSHelper(adjMatrix, i, visited);
			}
		}
	}

	private static void printDFSHelper(int[][] adjMatrix, int i, boolean[] visited) {
		System.out.print(i + " ");
		for (int j = 0; j < adjMatrix.length; j++) {
			if (adjMatrix[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				printDFSHelper(adjMatrix, j, visited);
			}
		}
	}

}
