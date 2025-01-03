package com.ck.striver.basics.maths;

/*
    Time Complexity:The time complexity is O(log n) due to the while loop that divides n by 10 in each iteration until it becomes 0.
    Space Complexity:The space complexity is O(1) because only a constant amount of space is used for variables irrespective of the input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/count-all-digits-of-a-number/submissions
public class CountAllDigits {

    public static void main(String[] args){
        int n=10;
        System.out.println(countAllDigits(n));
    }

    private static int countAllDigits(int n) {
        if(n==0) return 1;
        int cnt=0;

        while(n!=0){
            n=n/10;
            cnt++;
        }
        return cnt;
    }
}
