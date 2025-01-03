package com.ck.striver.basics.pattern;

/*
    Time Complexity:The outer loop runs n times and the inner loop runs decreasingly from n to 1, resulting in O(n^2) time complexity.
    Space Complexity:The space complexity is O(1) as no additional data structures are used that grow with input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-15/submissions
public class Pattern15 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<=n-1-i;j++){
                System.out.print((char)('A'+j));
            }
            System.out.println();
        }
    }
}
