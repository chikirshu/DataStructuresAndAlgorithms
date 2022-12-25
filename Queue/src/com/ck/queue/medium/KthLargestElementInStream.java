package com.ck.queue.medium;

import java.util.PriorityQueue;

// LC - 703 : Kth Largest Element in a Stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementInStream {

	public static void main(String[] args) {
		KthLargest obj = new KthLargest(1, new int[] {});

		System.out.print(obj.add(-3) + " ");
		System.out.print(obj.add(-2) + " ");
		System.out.print(obj.add(-4) + " ");
		System.out.print(obj.add(0) + " ");
		System.out.print(obj.add(4));
	}

	static class KthLargest {

		int[] nums;
		int k;
		PriorityQueue<Integer> pq;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			this.nums = nums;
			pq = new PriorityQueue<>();

			for (int i = 0; i < nums.length; i++) {
				if (i < k) {
					pq.add(nums[i]);
				} else {
					if (nums[i] > pq.peek()) {
						pq.remove();
						pq.add(nums[i]);
					}
				}
			}
		}

		public int add(int val) {
			if (pq.size() < k) {
				pq.add(val);
			} else if (val > pq.peek()) {
				pq.remove();
				pq.add(val);
			}
			return !pq.isEmpty() ? pq.peek() : null;
		}
	}

}
