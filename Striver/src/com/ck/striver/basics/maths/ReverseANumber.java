package com.ck.striver.basics.maths;

/*
    Time Complexity:The time complexity is O(d) where d is the number of digits in the input integer n. Can also be treated as O(logn)
    Space Complexity:The space complexity is O(1) since we are using a constant amount of extra space.
*/
public class ReverseANumber {

    public static void main(String[] args){
        Integer n=123;
        System.out.println(reverseANumber(n));
        System.out.println("printing n="+n);
    }

    private static int reverseANumber(Integer n) {
        int i=0, sum=0;
        while(n!=0){
            int rem = n%10;
            sum=sum*10+rem;
            n=n/10;
            i++;
        }
        return sum;
    }
}
