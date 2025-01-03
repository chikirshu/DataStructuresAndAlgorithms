package com.ck.striver.basics.maths;

/*
    Time Complexity:O(log(min(n1, n2))) for GCD and O(1) for LCM calculation, overall O(log(min(n1, n2)))
    Space Complexity:O(1) since only a constant amount of space is used for variables
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/lcm-of-two-numbers/submissions
public class NiceLCM {

    public static void  main(String[] args){
        int n1=40, n2=20;
        System.out.println(getLCMI(n1, n2));
        System.out.println(getLCMII(n1, n2));
    }

    // O(n1*n2)
    private static int getLCMI(int n1, int n2) {

        int max = Math.max(n1, n2);
        for(int i=max;i<=n1*n2;i++){
            if(i%n1==0 && i%n2==0) return i;
        }
        return n1*n2;
    }

    //O(log(min(n1,n2)))
    private static int getLCMII(int n1, int n2) {
        int mul = n1*n2;
        int gcd = getGCD(n1,n2);
        return mul/gcd;
    }

    private static int getGCD(int n1, int n2) {
        while(n1!=0 && n2!=0){
            if(n1>n2){
                n1 = n1%n2;
            }
            else{
                n2 = n2%n1;
            }
        }
        return n1==0?n2:n1;
    }
}
