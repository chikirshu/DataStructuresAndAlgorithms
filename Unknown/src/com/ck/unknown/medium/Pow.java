package com.ck.unknown.medium;

// LC - 50 : Pow(x, n)
// https://leetcode.com/problems/powx-n/description/
public class Pow{

    public static void main(String[] args){
        double res= myPowII(2.0000, 2);
        System.out.println(res);
    }

    // Gives TLE on leetcode
    public static double myPowI(double x, int n) {
        if(n==0) return 1;
        double res=1;
        if(n>0){
            while(n>0){
                res=res*x;
                n--;
            }
        }
        else{
            while(n<0){
                res=1/(res*x);
                n--;
            }
        }

        return res;

    }

    /*
    11=1011
    8+0+2+1=1*2^3+0*2^2+1*2^1+1*2^0

    7^11 = 7^8 * 7^2 * 7^1

    pow = 7
    x = 49  (7^2)
    11%2 = 1
    11/2 = 5

    pow = 343
    x = 2401 (7^4)
    5%2 = 1
    5/2 = 2

    pow = 343
    x = 5764801 (7^8)
    2%2 = 0
    2/2 = 1

    pow = 1977326743
    x = 33232930569601 (7^16)
    1%2 = 1
    1/2 = 0
    */
    public static double myPowII(double x, int n){
        double res = 1;

        if(n==0) return 1;
        if(n<0) x=1/x;

        while(n!=0){
            if(n%2!=0) res*=x;

            x*=x;
            n=n/2;
        }

        return res;
    }
}