package com.ck.striver.basics.maths;

/*
    Time Complexity:O(sqrt(n)) because the loop runs from 2 to the square root of n
    Space Complexity:O(1) since only a constant amount of space is used irrespective of the input size
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/check-for-prime-number/submissions
public class CheckPrime {

    public static void main(String[] args){
        int n = 9;
        System.out.println(isPrimeNumber(n));
    }

    private static boolean isPrimeNumber(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
