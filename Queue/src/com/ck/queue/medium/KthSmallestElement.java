package com.ck.queue.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// GFG - Kth smallest element
// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1/
public class KthSmallestElement {

	public static void main(String[] args) {
		System.out.println(kthSmallestI(new int[] {7,10, 4, 3, 20, 15}, 3));
		System.out.println(kthSmallestII(new int[] {7,10, 4, 3, 20, 15}, 3));
	}
	
	// will give TLE in GFG
	public static int kthSmallestI(int[] arr, int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            if(i<k){
                pq.add(arr[i]);
            }
            else{
                if(arr[i]<pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        return pq.peek();
    }
	
	// will give TLE in GFG
	public static int kthSmallestII(int[] arr, int k) {
		
		Arrays.sort(arr);
        return arr[k-1];
	}

}
