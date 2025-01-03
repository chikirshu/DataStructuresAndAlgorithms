package com.ck.striver.basics.recursion;

/*
    Time Complexity:The time complexity is O(log n) due to the repeated division by 10 in the recursive calls.
    Space Complexity:The space complexity is O(log n) due to the recursion stack depth when dividing the number.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/sum-of-digits-in-a-given-number/submissions
public class NiceSumOfDigits {

    public static void main(String[] args){
        int n=38;
        System.out.println(getSumOfDigits(n));
    }

    private static int getSumOfDigits(int n) {
        if(n/10==0) return n;

        int sum=0;
        n = Math.abs(n);
        return getOptimisedSumOfDigits(n, sum);
    }

    private static int getOptimisedSumOfDigits(int n, int crntSum) {
        if((crntSum+n)/10==0) return crntSum+n;

        crntSum+=n%10;
        while(crntSum/10!=0){
            crntSum=getSumOfDigits(crntSum);
        }
        return getOptimisedSumOfDigits(n/10, crntSum);
    }
}
