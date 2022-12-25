package com.ck.queue.medium;

import java.util.PriorityQueue;

// LC - 215 : Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
public class KthLargestElement {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
	}
	
	 public static int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int i=0;i<nums.length;i++){
	            if(i<k){
	                pq.add(nums[i]);
	            }
	            else{
	                if(nums[i]>pq.peek()){
	                    pq.remove();
	                    pq.add(nums[i]);
	                }
	            }
	        }
	        return pq.poll();
	    }

}
