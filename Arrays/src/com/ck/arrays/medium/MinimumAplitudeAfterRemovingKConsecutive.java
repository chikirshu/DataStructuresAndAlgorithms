package com.ck.arrays.medium;

// codility - Minimum Amplitude
// Find the minimum amplitude of the rest of the numbers after removing K consecutive numbers from an array. 
// Minimum amplitude means the difference of max and min should be minimum - open
public class MinimumAplitudeAfterRemovingKConsecutive {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 8,8,4,3,2 }, 2));
	}

	public static int solution(int[] A, int K) {
		// write your code in Java SE 8
		int localMin = Integer.MAX_VALUE, localMax = Integer.MIN_VALUE;
		int crntMaxDiff = 0, globalMaxDiff = -1, start = 0, iMin = 0, iMax = 0;
		int n = A.length;

		for (int i = 0; i < n; i++) {
			if (localMin > A[i])
				localMin = A[i];
			if (localMax < A[i])
				localMax = A[i];
			if (i - start == K - 1) {
				crntMaxDiff = localMax - localMin;
				/*if (crntMaxDiff == 0) {
					return 0;
				} else */
				if (crntMaxDiff > globalMaxDiff) {
					globalMaxDiff = crntMaxDiff;
					iMin = start;
					iMax = i;
					start++;
					localMin = A[start];
					localMax = A[start];
				}
			}
		}
		localMin = Integer.MAX_VALUE;
		localMax = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (i >= iMin && i <= iMax)
				continue;
			if (localMin > A[i])
				localMin = A[i];
			if (localMax < A[i])
				localMax = A[i];
		}
		return localMax - localMin;
	}

}
