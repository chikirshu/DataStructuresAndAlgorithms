package com.ck.arrays.medium;

// HackerEarth - Minimum swaps required to make 1st two elements of circular array equal - open - because of Time Limit Exceed - O(N*N)
// https://www.hackerearth.com/problem/algorithm/minimum-swaps-97f51beb-bf8cac06/
public class MinimumSwapsCircularArray {

	public static void main(String[] args) {
		System.out.println(minSwapsCircularArray(5, new long[] { 1, 2, 3, 4, 1 }));
	}

	static long minSwapsCircularArray(int N, long[] A) {
		long swapsForIFor1st = 0, swapsForJFor2nd = 0, swapsForJFor1st = 0, swapsForIFor2nd = 0, ans = 0,
				totalSwaps = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (A[i] == A[j]) {
					swapsForIFor1st = (long) Math.min(i, N - i);
					swapsForJFor2nd = (long) Math.min(j - 1, N - j + 1);

					swapsForJFor1st = (long) Math.min(j, N - j);  
					swapsForIFor2nd = (long) Math.min(i - 1, N - i + 1);

					if (swapsForIFor1st < 0 || swapsForJFor2nd < 0) {
						ans = (long) Math.min(totalSwaps, swapsForJFor1st + swapsForIFor2nd);
					} else if (swapsForJFor1st < 0 || swapsForIFor2nd < 0) {
						ans = (long) Math.min(totalSwaps, swapsForIFor1st + swapsForJFor2nd);
					} else {
						ans = (long) Math.min(swapsForIFor1st + swapsForJFor2nd, swapsForJFor1st + swapsForIFor2nd);
					}

					totalSwaps = (long) Math.min(totalSwaps, ans);
				}
			}
		}
		return totalSwaps == Integer.MAX_VALUE ? -1 : totalSwaps;
	}

}
