package com.ck.striver.basics.maths;

/*
    Time Complexity:O(log n), where n is the input number since we process each digit of n
    Space Complexity:O(1), only a fixed amount of space is used for variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/count-number-of-odd-digits-in-a-number/submissions
public class CountOddDigitsInNumber {

    public static void main(String[] args){
        int n=15;
        System.out.println(countAllOddDigits(n));
    }

    private static int countAllOddDigits(int n) {
        int cnt=0;
        while(n!=0){
            int rem = n%10;
            if(rem%2!=0)cnt++;
            n=n/10;
        }
        return cnt;
    }
}
