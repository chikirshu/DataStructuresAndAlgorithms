package com.ck.stack.easy;

// LC - 155 : Min Stack
// https://leetcode.com/problems/min-stack/
public class MinStack {

	public int minElement;
	public int topIdx;
	public int[] arr;
	public int maxSize = 30000;

	public MinStack() {
		minElement = Integer.MAX_VALUE;
		topIdx = -1;
		arr = new int[maxSize];
	}

	public void push(int val) {
		arr[++topIdx] = val;
		if (minElement > val)
			minElement = val;
	}

	public void pop() {
		topIdx--;
		if (minElement == arr[topIdx + 1]) {
			minElement = Integer.MAX_VALUE;
			for (int i = 0; i <= topIdx; i++) {
				minElement = (int) Math.min(minElement, arr[i]);
			}
		}
	}

	public int top() {
		return arr[topIdx];
	}

	public int getMin() {
		return minElement;
	}

}
