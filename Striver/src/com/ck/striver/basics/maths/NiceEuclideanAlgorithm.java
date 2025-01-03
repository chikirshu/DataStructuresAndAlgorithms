package com.ck.striver.basics.maths;

// Theory - GCD(n1, n2) = GCD(n1-n2, n2) given that n1>n2
/*
    Time Complexity:The time complexity is O(log(min(n1, n2))) due to the Euclidean algorithm used for finding the GCD.
    Space Complexity:The space complexity is O(1) as no additional space is used that scales with input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/gcd-of-two-numbers/submissions
public class NiceEuclideanAlgorithm {

    public static void main(String[] args){
        int n1 = 100, n2 = 2;
        System.out.print(" ans = " +getGCDI(n1, n2) + "\n");
        System.out.print(" ans = " + getGCDII(n1, n2) + "\n");
        System.out.print(" ans = " + getGCDIII(n1, n2) + "\n");
    }

    // O(min(n1, n2))
    private static int getGCDI(int n1, int n2) {
        long startTime = System.currentTimeMillis();
        int minInt = Math.min(n1, n2);

        for(int i=minInt;i>=1;i--){
            if(n1%i==0 && n2%i==0) {
                System.out.print("Total Time for getGCDI : "+(System.currentTimeMillis()-startTime));
                return i;
            }
        }
        System.out.print("Total Time for getGCDI : "+(System.currentTimeMillis()-startTime));
        return 1;
    }

    // Euclidean approach
    private static int getGCDII(int n1, int n2) {
        long startTime = System.currentTimeMillis();
        while(n1!=0 && n2!=0){
            if(n1>n2){
                n1=n1-n2;
            }
            else{
                n2=n2-n1;
            }
        }
        System.out.print("Total Time for getGCDII : "+(System.currentTimeMillis()-startTime));
        return n1==0?n2:n1;
    }

    // Optimized Euclidean approach
    private static int getGCDIII(int n1, int n2) {
        long startTime = System.currentTimeMillis();
        while(n1!=0 && n2!=0){
            if(n1>n2){
                n1=n1%n2;
            }
            else{
                n2=n2%n1;
            }
        }
        System.out.print("Total Time for getGCDIII : "+(System.currentTimeMillis()-startTime));
        return n1==0?n2:n1;
    }
}
