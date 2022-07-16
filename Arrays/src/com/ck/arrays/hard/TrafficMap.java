package com.ck.arrays.hard;

// Code Signal - open
/*
 * Consider a map of city streets, in the form of a grid.

example

You'd like to know if it's possible to make your way to the exit, under the following rules:

You begin from the left side of the square in the top-left corner;
The exit is on the right side of the square in the bottom-right corner;
You must travel along a connected path between squares.
You're given directions, a matrix of integers representing the grid of streets, where each integer corresponds to a different type of road square:

0 stands for 0
1 stands for 1
2 stands for 2
3 stands for 3
4 stands for 4
5 stands for 5
Your task is to return true if it's possible to reach the exit, and false otherwise.

Example

For directions = [[0, 2, 1], [5, 4, 0]], the output should be trafficMap(directions) = true.

The map looks as follows:

example1

It's possible to enter the top-left square from the left, travel along a connected path, and exit the right side of the bottom-right square. So the answer is true.

For directions = [[0, 2, 1], [5, 4, 1]], the output should be trafficMap(directions) = false.

The map looks as follows:

example2

It's possible to enter the top-left square from the left, but there's no connected path that leads to the bottom-right square. So the answer is false.

For directions = [[0, 2, 1], [5, 4, 2]], the output should be trafficMap(directions) = false.

The map looks as follows:

example3

The path leading to the bottom-right square exists, but it doesn't exit to the right.

For directions = [[1], [4]], the output should be trafficMap(directions) = false.

The map looks as follows:

example4

It's possible to travel along the path to the exit, but the entrance isn't in the right place.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer directions

The map of streets, represented as the rectangular matrix of integers.

Guaranteed constraints:
1 <= directions.length <= 100,
1 <= directions[0].length <= 100,
directions[i].length = directions[0].length,
0 <= directions[i][j] <= 5.

[output] boolean

true if it's possible to reach the right side of the bottom right corner along a connected path from the left side of the top left corner, and false otherwise.
 */
public class TrafficMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean trafficMap(int[][] directions) {
		boolean[][] visited = new boolean[directions.length][directions[0].length];
		return isPossiblePath(directions, 0, 0, directions[0][0], visited);
	}

	public static boolean isPossiblePath(int[][] directions, int r, int c, int prev, boolean[][] visited) {
		if (r < 0 || r > directions.length || c < 0 || c > directions[0].length || visited[r][c]) {
			return false;
		}
		if (r == directions.length - 1 && c == directions[0].length - 1)
			return true;
		if ((r == 0 && c == 0) || (directions[r][c] == 5 && (prev == 2 || prev == 1)
				|| (directions[r][c] == 2 && (prev == 5 || prev == 1)))) {
			visited[r][c] = true;
			isPossiblePath(directions, r - 1, c, prev, visited); // top
			isPossiblePath(directions, r, c - 1, prev, visited); // left
			isPossiblePath(directions, r + 1, c, prev, visited); // down
			isPossiblePath(directions, r, c + 1, prev, visited); // right
		}
		return true;
	}
}
