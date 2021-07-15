package com.ck.stack.easy;

public class MaxStack {

	public int maxElement;
	public int topIdx;
	public int[] arr;
	public int maxSize = 30000;

	public MaxStack() {
		maxElement = Integer.MIN_VALUE;
		topIdx = -1;
		arr = new int[maxSize];
	}

	public void push(int val) {
		arr[++topIdx] = val;
		if (maxElement < val)
			maxElement = val;
	}

	public void pop() {
		topIdx--;
		if (maxElement == arr[topIdx + 1]) {
			findMax();
		}
	}

	private void findMax() {
		maxElement = Integer.MIN_VALUE;
		for (int i = 0; i <= topIdx; i++) {
			maxElement = (int) Math.max(maxElement, arr[i]);
		}
	}

	public int top() {
		return arr[topIdx];
	}

	public int peekMax() {
		return maxElement;
	}

	public void popMax() {
		for (int i = topIdx; i >=0 ; i--) {
			if (arr[i] == maxElement) {
				removeElement(arr[i], i);
				break;
			}
		}
	}

	private void removeElement(int element, int idx) {
		for (int i = idx + 1; i < topIdx; i++) {
			arr[i - 1] = arr[i];
		}
		topIdx--;
		findMax();
	}
}
