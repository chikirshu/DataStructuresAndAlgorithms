package com.ck.striver.basics.pattern;

/*
    Time Complexity:The outer loop runs n times and the inner loop runs i+1 times, leading to a time complexity of O(n^2).
    Space Complexity:The space complexity is O(1) since no additional data structures are used that grow with input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-18/submissions
public class Pattern18 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                System.out.print((char)('A'+(n-1-j)));
            }
            System.out.println();
        }
    }
}
