package com.ck.striver.basics.pattern;

/*
    for n=5=>1+2+3+4+5 = n*(n+1)/2
    Time Complexity:O(n^2) due to nested loops where the outer loop runs n times and the inner loop runs up to i times which sums to n(n+1)/2
    Space Complexity:O(1) as only a fixed amount of space is used regardless of the input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-11/submissions
public class Pattern11 {

    public static void main(String[] args){
        int n=5;
        for(int i=1;i<=n;i++){
            int rem = i%2;
            boolean start= rem == 1;
            for(int j=0;j<i;j++){
                int val = start?1:0;
                System.out.print(val+" ");
                start=!start;
            }
            System.out.println();
        }
    }
}
