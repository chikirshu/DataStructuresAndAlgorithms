package com.ck.striver.basics.maths;

// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/return-the-largest-digit-in-a-number/submissions
public class LargestDigitInNumber {

    public static void main(String[] args){
        int n=23;
        System.out.println(getLargestDigit(n));
    }

    private static int getLargestDigit(int n) {
        if(n==0)return 0;
        int largestDigit=-1;
        while(n!=0){
            int rem = n%10;
            if(largestDigit<rem){
                largestDigit=rem;
            }
            n=n/10;
        }
        return  largestDigit;
    }
}
