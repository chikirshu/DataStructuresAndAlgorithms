package com.ck.arrays.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 11, 13, 21, 3 };
		Map<Integer, Integer> map = findResult(arr);
		for (int i : arr) {
			System.out.println(i + "->" + map.get(i));
		}
	}

	public static Map<Integer, Integer> findResult(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stk = new Stack<>();
		stk.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			while (!stk.isEmpty() && stk.peek() < arr[i]) {
				map.put(stk.pop(), arr[i]);
			}
			stk.push(arr[i]);
		}
		while (!stk.isEmpty()) {
			map.put(stk.pop(), -1);
		}
		return map;

	}

}
