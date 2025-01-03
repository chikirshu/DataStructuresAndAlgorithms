package com.ck.striver.basics.pattern;

/*
    Time Complexity:The outer loop runs n times and the inner loop runs a decreasing number of times from n to 1, leading to O(n^2) overall.
    Space Complexity:The space complexity is O(1) as only a constant amount of space is used regardless of input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-6/submissions
public class Pattern6 {

    public static void main(String[] args){
        int n=4;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
}
