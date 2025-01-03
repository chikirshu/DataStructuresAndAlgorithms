package com.ck.striver.basics.pattern;

/*
    Time Complexity:O(n^2) due to nested loops for pattern generation
    Space Complexity:O(1) since no extra space is used that scales with input
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-9/submissions
public class Pattern9 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=n-1;j>i;j--){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int j=n-1;j>i;j--){
                System.out.print(" ");
            }
            System.out.println();
        }

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
