package com.ck.striver.basics.recursion;

/*
    Time Complexity:The time complexity is O(n) due to the recursive calls for each decrement of n until reaching the base case.
    Space Complexity:The space complexity is O(n) as it utilizes stack space for the recursive calls.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/factorial-of-a-given-number/submissions
public class Factorial {

    public static void main(String[] args){
        int n=13;
        System.out.println(getFactorial(n, 1));
    }

    private static long getFactorial(int n, long crntAns) {
        if(n==0 || n==1) return crntAns;
        return getFactorial(n-1,crntAns*n);
    }
}
