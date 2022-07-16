package com.ck.arrays.medium;

// LC - 1524 : Number of Sub-arrays With Odd Sum
// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/submissions/
public class SubArraysWithOddSum {

	public static void main(String[] args) {
		System.out.println(numOfSubarraysII(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
	}

	// will give TLE
	public static int numOfSubarraysI(int[] arr) {
		int sum = 0, res = 0, mod = (int)1e9+7;
		for (int start = 0; start < arr.length; start++) {
			sum = 0;
			for (int end = start; end < arr.length; end++) {
				sum += arr[end];
				if (sum % 2 != 0)
					res = (res+1)%mod;
			}
		}
		return res;
	}
	
	// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/discuss/754743/JavaC%2B%2BPython-Prefix-Sum
	public static int numOfSubarraysII(int[] A) {
        int cur = 0, res = 0, count[] = {1, 0}, mod = (int)1e9 + 7;
        for (int a: A) {
            cur ^= a & 1;
            res = (res + count[1 - cur]) % mod;
            count[cur]++;
        }
        return res;
    }

}
