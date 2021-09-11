package com.ck.arrays.medium;

public class SolveSudoku {

	public static void main(String[] args) {
		int[][] arr = new int[][] { 
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
			};
		solveSudoku(arr, 0, 0);
		// will not work
		/*
		 * for(int i=0;i<9;i++) { for(int j=0;j<9;j++) {
		 * System.out.print(arr[i][j]+" "); } System.out.println(); }
		 */

	}

	private static void solveSudoku(int[][] arr, int i, int j) {
		if (i == arr.length) {
			display(arr);
			return;
		}
		int nextI = 0, nextJ = 0;
		if (j == arr.length - 1) {
			nextI = i + 1;
			nextJ = 0;
		} else {
			nextI = i;
			nextJ = j + 1;
		}
		if (arr[i][j] != 0) {
			solveSudoku(arr, nextI, nextJ);
		} else {
			for (int val = 1; val <= 9; val++) {
				if (isValid(arr, i, j, val)) {
					arr[i][j] = val;
					solveSudoku(arr, nextI, nextJ);
					arr[i][j] = 0;
				}
			}
		}
	}

	private static void display(int[][] arr) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean isValid(int[][] arr, int r, int c, int val) {
		for (int j = 0; j < arr[0].length; j++) {
			if (arr[r][j] == val)
				return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][c] == val)
				return false;
		}
		int subMatTopLeftI = (r / 3) * 3;
		int subMatTopLeftJ = (c / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[subMatTopLeftI + i][subMatTopLeftJ + j] == val)
					return false;
			}
		}
		return true;
	}

}
