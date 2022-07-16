package com.ck.dp.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://www.youtube.com/watch?v=3mD20VSib5E
public class LongestIncreasingSubsequencePrintAllPaths {

	public static void main(String[] args) {
		findLISAndPrintPaths(new int[] {10, 22, 42, 33, 21, 50, 41, 60, 59, 3});
	}
	
	public static class LISMetadata{
		int length; // length of longest strictly increasing subsequence in dp table
		int index;  // crnt index of LIS in dp table
		int value;  // value in arr
		String psf; // path so far
		
		public LISMetadata(int length, int index, int value, String psf) {
			this.length = length;
			this.index = index;
			this.value = value;
			this.psf = psf;
		}
	}
	
	public static void findLISAndPrintPaths(int[] arr) {
		
		int[] dp = new int[arr.length];
		int crntMax=0, oMax=0;
		Queue<LISMetadata> queue = new LinkedList<>();
		
		for(int i=0;i<arr.length;i++) {
			crntMax=0;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					crntMax=Math.max(crntMax, dp[j]);
				}
			}
			dp[i]=crntMax+1;
			oMax = Math.max(oMax,dp[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			if(dp[i]==oMax) {
				queue.add(new LISMetadata(oMax,i,arr[i],arr[i]+" "));
			}
		}
		while(!queue.isEmpty()) {
			LISMetadata obj = queue.poll();
			if(obj.length==1) {
				System.out.println(obj.psf);
			}
			
			for(int i=obj.index-1;i>=0;i--) {
				if(dp[i]==obj.length-1 && arr[i]<arr[obj.index]) {
					queue.add(new LISMetadata(dp[i],i,arr[i],arr[i]+"->"+obj.psf));
				}
			}
			
		}
	}

}
