package com.ck.dp.easy;

import java.util.Scanner;

// PepCoding Lecture video - 1
public class fibonacciOfN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] memoize = new int[n + 1];
		// System.out.println(fibonacciDP(memoize, n));
		// System.out.println(fibbonacciOldWay(n));
		System.out.println(fibonacciDPTable(n));
	}

	// Recursion
	public static int fibbonacciOldWay(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		System.out.println("hello " + n);
		int num1 = fibbonacciOldWay(n - 1);
		int num2 = fibbonacciOldWay(n - 2);
		return num1 + num2;
	}

	// DP Memoize
	public static int fibonacciDP(int[] memoize, int n) {
		if (n == 0 || n == 1) {
			// memoize[n]=n; no need as we are directly returning the value of n
			return n;
		}
		if (memoize[n] != 0) {
			return memoize[n];
		}
		System.out.println("hello " + n);
		int num1 = fibonacciDP(memoize, n - 1);
		int num2 = fibonacciDP(memoize, n - 2);
		memoize[n] = num1 + num2;

		return memoize[n];
	}

	public static int fibonacciDPTable(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
