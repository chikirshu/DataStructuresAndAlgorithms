package com.ck.stack.hard;

import java.util.Stack;

public class LargestAreaInHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	public static int largestRectangleArea(int[] heights) {

		// Will give TLE for huge number of elements in input array
		/*
		 * int min = 0, area=0; for(int i=0;i<heights.length;i++){
		 * min=Integer.MAX_VALUE; for(int j=i;j<heights.length;j++){ min=
		 * Math.min(min,heights[j]); area = Math.max(area,min*(j-i+1)); } } return area;
		 */

		int[] leftBoundary = new int[heights.length];
		int[] rightBoundary = new int[heights.length];
		Stack<Integer> stk = new Stack<>();
		int width = 0, area = 0, n = heights.length;

		rightBoundary[n - 1] = n;
		stk.push(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (stk.size() > 0 && heights[stk.peek()] >= heights[i]) {
				stk.pop();
			}
			if (stk.size() == 0) {
				rightBoundary[i] = n;
			} else {
				rightBoundary[i] = stk.peek();
			}
			stk.push(i);
		}

		stk = new Stack<>();
		leftBoundary[0] = -1;
		stk.push(0);
		for (int i = 1; i < n; i++) {
			while (stk.size() > 0 && heights[stk.peek()] >= heights[i]) {
				stk.pop();
			}
			if (stk.size() == 0) {
				leftBoundary[i] = -1;
			} else {
				leftBoundary[i] = stk.peek();
			}
			stk.push(i);
		}

		for (int i = 0; i < n; i++) {
			// System.out.print("right b = "+rightBoundary[i]+" left b = "+leftBoundary[i]);
			width = rightBoundary[i] - leftBoundary[i] - 1;
			area = Math.max(area, width * heights[i]);
			// System.out.println();
		}
		return area;
	}

}
