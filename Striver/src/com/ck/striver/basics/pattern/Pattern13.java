package com.ck.striver.basics.pattern;

/*
    Time Complexity:The time complexity is O(n^2) due to the nested loops where the outer loop runs n times and the inner loop runs up to i (which goes from 0 to n-1).
    Space Complexity:The space complexity is O(1) because the space used does not depend on the input size, only a few integer variables are used.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-13/submissions
public class Pattern13 {

    public static void main(String[] args){
        int n=5;
        int cnt=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(cnt+++" ");
            }
            System.out.println();
        }
    }
}
