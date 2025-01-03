package com.ck.striver.basics.recursion;

/*
    Time Complexity:The time complexity is O(N) due to the linear recursive calls made for each number down to 1.
    Space Complexity:The space complexity is O(N) because of the recursive call stack, which can go up to N frames deep.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/sum-of-first-n-numbers/submissions
public class SumOfFirstNNumbers {

    public static void main(String[] args){
        int n=4;
        System.out.println(getSumOfFirstNNumbers(n, 0));
    }

    private static int getSumOfFirstNNumbers(int n, int crntSum) {
        if(n==1) return crntSum+1;
        return getSumOfFirstNNumbers(n-1, crntSum+n);
    }
}
