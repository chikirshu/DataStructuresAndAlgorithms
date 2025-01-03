package com.ck.striver.basics.maths;

/*
    Time Complexity:O(n) due to the for loop checking divisors up to n/2
    Space Complexity:O(1) as only a fixed amount of space is used for variables
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/check-for-perfect-number/submissions
public class IsPerfectNumber {

    public static void main(String[] args){
        int n=6;
        System.out.println(isPerfectNumber(n));
    }

    private static boolean isPerfectNumber(int n) {
        int sumOfDivisors = 0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                sumOfDivisors+=i;
            }
        }
        return sumOfDivisors==n;
    }
}
