package com.ck.striver.basics.maths;

/*
    Time Complexity:O(n * sqrt(n)) due to the nested loops for number checking
    Space Complexity:O(1) since only a fixed number of variables are used
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/count-of-prime-numbers-till-n/submissions
public class CountPrimeNumbersTillN {

    public static void main(String[] args){

        int n=20;
        System.out.println(countPrimeNumbersTillN(n));
    }

    // O(n*sqrt(n))
    private static int countPrimeNumbersTillN(int n) {
        int cnt=0;
        for(int i=2;i<=n;i++){
            if(isPrimeNumber(i))cnt++;
        }
        return cnt;
    }

    private static boolean isPrimeNumber(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
