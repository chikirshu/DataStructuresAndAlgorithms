package com.ck.arrays.easy;

// LC - 733 : Flood Fill
// https://leetcode.com/problems/flood-fill/
public class FloodFill {

	public static void main(String[] args) {
		int[][] res = floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		boolean[][] visited = new boolean[image.length][image[0].length];
		floodFillVisit(image, sr, sc, newColor, image[sr][sc], visited);
		return image;
	}

	public static void floodFillVisit(int[][] image, int sr, int sc, int newColor, int origColor, boolean[][] visited) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != origColor
				|| visited[sr][sc]) {
			return;
		}
		visited[sr][sc] = true;
		image[sr][sc] = newColor;
		floodFillVisit(image, sr - 1, sc, newColor, origColor, visited); // top
		floodFillVisit(image, sr, sc - 1, newColor, origColor, visited); // left
		floodFillVisit(image, sr + 1, sc, newColor, origColor, visited); // down
		floodFillVisit(image, sr, sc + 1, newColor, origColor, visited); // right
		// visited[sr][sc] = false; // for finding different maze paths
	}

}
