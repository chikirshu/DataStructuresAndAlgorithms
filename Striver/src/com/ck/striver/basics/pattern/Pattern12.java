package com.ck.striver.basics.pattern;

/*
    Time Complexity:O(n^2) due to nested loops where outer loop runs n times and inner loops run proportional to n
    Space Complexity:O(1) since only a constant amount of extra space is used regardless of input size
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-12/submissions
public class Pattern12 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            for(int j=0;j<2*(n-1-i);j++){
                System.out.print(" ");
            }
            for(int j=i;j>=0;j--){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
}
