package com.ck.arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class isValidSudoku {

	public static void main(String[] args) {
		System.out.println(isValidSudokuI(new char[][] { 
				{ '.', '.', '4', '.', '.', '.', '6', '3', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '5', '.', '.', '.', '.', '.', '.', '9', '.' },
				{ '.', '.', '.', '5', '6', '.', '.', '.', '.' }, 
				{ '4', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '5', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } }));
		System.out.println(isValidSudokuII(new char[][] { 
			{ '.', '.', '4', '.', '.', '.', '6', '3', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
			{ '5', '.', '.', '.', '.', '.', '.', '9', '.' },
			{ '.', '.', '.', '5', '6', '.', '.', '.', '.' }, 
			{ '4', '.', '3', '.', '.', '.', '.', '.', '1' },
			{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, 
			{ '.', '.', '.', '5', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } }));
	}
	
	public static boolean isValidSudokuII(char[][] board) {
	    Set<String> seen = new HashSet<>();
	    for (int i=0; i<9; ++i) {
	        for (int j=0; j<9; ++j) {
	            char number = board[i][j];
	            if (number != '.')
	                if (!seen.add(number + " in row " + i) ||
	                    !seen.add(number + " in column " + j) ||
	                    !seen.add(number + " in block " + (i/3)*3 + "-" + (j/3)*3))
	                    return false;
	        }
	    }
	    return true;
	}

	public static boolean isValidSudokuI(char[][] board) {
		boolean res;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				else {
					res = isValid(board, i, j, board[i][j]);
					if (!res)
						return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(char[][] board, int r, int c, char val) {
		for (int j = 0; j < 9; j++) {
			if (c == j || board[r][j] == '.')
				continue;
			else if (board[r][j] == val)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (r == i || board[i][c] == '.')
				continue;
			else if (board[i][c] == val)
				return false;
		}
		int subMatTopLeftI = (r / 3) * 3;
		int subMatTopLeftJ = (c / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((r == i + subMatTopLeftI && c == j + subMatTopLeftJ)
						|| board[i + subMatTopLeftI][j + subMatTopLeftJ] == '.')
					continue;
				else if (board[i + subMatTopLeftI][j + subMatTopLeftJ] == val)
					return false;
			}
		}
		return true;
	}

}
