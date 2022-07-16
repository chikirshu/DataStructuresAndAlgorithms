package com.ck.arrays.easy;

import java.util.Arrays;

// GFG - Find minimum and maximum element in an array
// https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1/
// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/ - check to optimize it to 3n/2 - 2
public class MinMaxInArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getMinMax(new long[] {3, 2, 1, 56, 10000, 167}, 7)));
	}
	
	// 2n comparisons
	public static int[] getMinMax(long a[], long n)  
    {
        //Write your code here
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            max=(int)Math.max(a[i], max);
            min=(int)Math.min(a[i], min);
        }
        return new int[] {min, max};
    }
	
	

}
