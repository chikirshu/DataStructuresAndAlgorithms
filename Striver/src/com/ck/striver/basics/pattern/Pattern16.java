package com.ck.striver.basics.pattern;

/*
    Time Complexity:The outer loop runs n times and the inner loop runs i+1 times for each iteration, resulting in O(n^2) time complexity in total.
    Space Complexity:The space complexity is O(1) since no additional data structures are used that scale with input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-16/submissions
public class Pattern16 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print((char)('A'+i));
            }
            System.out.println();
        }
    }
}
