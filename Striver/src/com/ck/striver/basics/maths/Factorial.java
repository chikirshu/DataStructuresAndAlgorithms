package com.ck.striver.basics.maths;

/*
    Time Complexity:O(n) - a single loop runs from n to 1
    Space Complexity:O(1) - only a fixed amount of space is used
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/factorial-of-a-given-number/submissions
public class Factorial {

    public static void main(String[] args){
        int n=6;
        System.out.println(findFactorial(n));
    }

    private static int findFactorial(int n) {
        if(n==0)return 1;
        int sum=1;
        for(int i=n;i>=1;i--){
            sum*=i;
        }
        return sum;
    }
}
