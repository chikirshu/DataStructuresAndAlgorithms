package com.ck.striver.basics.pattern;

/*
    Time Complexity:The time complexity is O(n^2) because there are nested loops: the outer loop runs n times and the inner loops together run at most 2n times.
    Space Complexity:The space complexity is O(1) as no additional significant space is used that grows with n.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-17/submissions
public class Pattern17 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0; j<n-1-i; j++){
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                System.out.print((char)('A'+j));
            }
            for(int j=i; j>0; j--){
                System.out.print((char)('A'+(j-1)));
            }
            for(int j=0; j<n-1-i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
