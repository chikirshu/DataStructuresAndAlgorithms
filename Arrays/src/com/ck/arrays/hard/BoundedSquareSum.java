package com.ck.arrays.hard;

//Code Signal - open
/*
 * You are given two arrays of integers a and b, and two integers lower and upper. Your task is to find the number of pairs (i, j) such that lower <= a[i] * a[i] + b[j] * b[j] <= upper.

Example

For a = [3, -1, 9], b = [100, 5, -2], lower = 7, and upper = 99, the output should be boundedSquareSum(a, b, lower, upper) = 4.

There are only four pairs that satisfy the requirement:

If i = 0 and j = 1, then a[0] = 3, b[1] = 5, and 7 <= 3 * 3 + 5 * 5 = 9 + 25 = 36 <= 99.
If i = 0 and j = 2, then a[0] = 3, b[2] = -2, and 7 <= 3 * 3 + (-2) * (-2) = 9 + 4 = 13 <= 99.
If i = 1 and j = 1, then a[1] = -1, b[1] = 5, and 7 <= (-1) * (-1) + 5 * 5 = 1 + 25 = 26 <= 99.
If i = 2 and j = 2, then a[2] = 9, b[2] = -2, and 7 <= 9 * 9 + (-2) * (-2) = 81 + 4 = 85 <= 99.
For a = [1, 2, 3, -1, -2, -3], b = [10], lower = 0, and upper = 100, the output should be boundedSquareSum(a, b, lower, upper) = 0.

Since the array b contains only one element 10 and the array a does not contain 0, it is not possible to satisfy 0 <= a[i] * a[i] + 10 * 10 <= 100.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer a

A first array of integers.

Guaranteed constraints:
1 <= a.length <= 105,
-104 <= a[i] <= 104.

[input] array.integer b

A second array of integers.

Guaranteed constraints:
1 <= b.length <= 105,
-104 <= b[i] <= 104.

[input] integer lower

An integer representing a lower bound of a satisfiable square sum.

Guaranteed constraints:
0 <= lower <= 109.

[input] integer upper

An integer representing an upper bound of a satisfiable square sum.

Guaranteed constraints:
lower <= upper,
0 <= upper <= 109.

[output] integer

The number of pairs (i, j) such, that lower <= a[i] * a[i] + b[j] * b[j] <= upper. It is guaranteed that the answer fits in 32-bit value type.
 * */
public class BoundedSquareSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
