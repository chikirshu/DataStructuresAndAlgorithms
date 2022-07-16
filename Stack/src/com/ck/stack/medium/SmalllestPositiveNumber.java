package com.ck.stack.medium;

import java.util.Arrays;
import java.util.Stack;
// codility - Missing Integer
// Write a function:
// class Solution { public int solution(int[] A); }
// that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
// For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
// Given A = [1, 2, 3], the function should return 4.
// Given A = [-1, -3], the function should return 1.
// Write an efficient algorithm for the following assumptions:
// N is an integer within the range [1..100,000];
// each element of array A is an integer within the range [-1,000,000..1,000,000].

public class SmalllestPositiveNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2}));
	}
	public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i=0;i<A.length;i++){
            if(A[i]<=0) continue;
            if(A[i]-stk.peek() >1 ) break;
            stk.push(A[i]);
        }
        return stk.peek()+1;
    }

}
