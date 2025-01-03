package com.ck.striver.basics.pattern;

/*
    Time Complexity:The outer loop runs n times and the inner loop runs 1 to n times, so the total complexity is O(n^2).
    Space Complexity:The space complexity is O(1) since we only use a constant amount of space for variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-14/submissions
public class NicePattern14 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print((char)('A'+j));
            }
            System.out.println();
        }
    }
}
