package com.ck.striver.basics.maths;

/*
    Time Complexity:O(d) where d is the number of digits in the number n, since each digit is processed once and we also compute the power for each digit.
    Space Complexity:O(1) as the space used does not depend on the input size, only a fixed amount of space is used for variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/check-if-the-number-if-armstrong/submissions
public class IsArmstrongNumber {

    public static void main(String[] args){
        int n=153;
        System.out.println(isArmstrongNumber(n));
    }

    private static boolean isArmstrongNumber(int n) {
        int originalNum=n;
        int digits = countNumberOfDigits(n);
        int sum=0;
        while(n!=0){
            int rem = n%10;
            sum+=(int)Math.pow(rem, digits);
            n=n/10;
        }
        return sum==originalNum;
    }

    private static int countNumberOfDigits(int n) {
        int cnt=0;
        while(n!=0){
            n=n/10;
            cnt++;
        }
        return cnt;
    }
}
