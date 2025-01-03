package com.ck.striver.basics.pattern;

/*
    Time Complexity:The outer loop runs n times, and the inner loop decreases from n to 1, leading to a total of n * (n + 1) / 2 iterations, resulting in O(n^2) time complexity.
    Space Complexity:The space complexity is O(1) as only a fixed amount of space is used, regardless of the input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-5/submissions
public class Pattern5 {

    public static void main(String[] args){
        int n=4;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
