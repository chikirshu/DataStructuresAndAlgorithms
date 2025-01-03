package com.ck.striver.basics.pattern;

// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-10/submissions
public class Pattern10 {

    public static void main(String[] args){
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
