package com.ck.striver.basics.pattern;

/*
    Time Complexity:O(n^2) due to nested loops where outer loop runs n times and inner loops combined also run in proportional to n
    Space Complexity:O(1) as no additional space that grows with input size is used.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-8/submissions
public class Pattern8 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*(n-1-i)+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
