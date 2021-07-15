package com.ck.stack.hard;

import java.util.Stack;

// Hackerrank Problem - https://leetcode.com/discuss/general-discussion/534205/interview-question
/*Calculate Region
There is a straight line of students of various heights. The students' heights are given in in 
the form of an array, in the order, they are standing in the line. Consider the region of a 
student as the length of the largest subarray that includes that student's position, and in 
which that student's height is equal to maximum height among all students present in that subarray. 
Return the sum of the region of all students. For example •heights [1, 2, 1] The longest subarray 
in which the first student height is equal to maximum height among all other students is [1]; 
thus, the length of the region of the first student is 1. The longest subarray in which the second 
student height is equal to maximum height among all other students is [1, 2, 1]; thus, the length 
of the region of the second student is 3. The longest subarray in which the third student height 
is equal to maximum height among all other students is [1]; thus, the length of the region of the 
third student is 1. • Thus, the sum of the lengths of all regions of all students is 1+3+1 =5
 * */
public class CalculateRegion {

	public static void main(String[] args) {
		System.out.println(calculateRegion(new int[] { 1, 1, 1, 1 }));
	}

	public static int calculateRegion(int[] arr) {
		int n = arr.length, sum = 0;
		Stack<Integer> stk = new Stack<>();
		int[] rightBoundary = new int[n];
		int[] leftBoundary = new int[n];

		rightBoundary[n - 1] = n - 1;
		stk.push(n - 1);

		// calculate right boundary for each element in the array
		for (int i = n - 2; i >= 0; i--) {
			while (stk.size() > 0 && arr[stk.peek()] <= arr[i]) {
				stk.pop();
			}
			if (stk.size() == 0) {
				rightBoundary[i] = n - 1;
			} else {
				rightBoundary[i] = i;
			}
			stk.push(i);
		}

		stk.clear();

		leftBoundary[0] = 0;
		stk.push(0);

		// calculate left boundary for each element in the array
		for (int i = 1; i < n; i++) {
			while (stk.size() > 0 && arr[stk.peek()] <= arr[i]) {
				stk.pop();
			}
			if (stk.size() == 0) {
				leftBoundary[i] = 0;
			} else {
				leftBoundary[i] = i;
			}
			stk.push(i);
		}

		// final answer will be r-l+1
		for (int i = 0; i < n; i++) {
			sum += rightBoundary[i] - leftBoundary[i] + 1;
		}
		return sum;
	}

}
