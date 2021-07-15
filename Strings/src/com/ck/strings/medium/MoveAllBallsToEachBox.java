package com.ck.strings.medium;

import java.util.Arrays;

// LC - 1769 : Minimum Number of Operations to Move All Balls to Each Box
public class MoveAllBallsToEachBox {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(minOperationsI("001011")));
	}

	// O(N*N) time and O(N) space
	public static int[] minOperationsI(String boxes) {
		int[] res = new int[boxes.length()];
		int n = boxes.length(), k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (boxes.charAt(j) == '1')
					res[k] += Math.abs(j - i);
			}
			k++;
		}
		return res;
	}
	
	// O(N) - need to check
	public static int[] minOperations(String boxes) {
	    int[] res = new int[boxes.length()];
	    for (int i = 0, ops = 0, cnt = 0; i < boxes.length(); ++i) {
	       res[i] += ops;
	       cnt += boxes.charAt(i) == '1' ? 1 : 0;
	       ops += cnt;
	    }    
	    for (int i = boxes.length() - 1, ops = 0, cnt = 0; i >= 0; --i) {
	        res[i] += ops;
	        cnt += boxes.charAt(i) == '1' ? 1 : 0;
	        ops += cnt;
	    }
	    return res;
	}

}
