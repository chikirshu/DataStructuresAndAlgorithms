package com.ck.arrays.easy;

// LC - 724 : Find Pivot Index
//https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex {

	public static void main(String[] args) {
		int[] arr = {1,7,3,6,5,6};
		System.out.println(pivotIndex(arr));
	}
	
	public static int pivotIndex(int[] nums) {
        
        int totalSum=0, leftSum=0, rightSum=0;
        
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        
        for(int i=0; i<nums.length;i++){
            rightSum=totalSum-leftSum-nums[i];
            if(rightSum==leftSum)
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }

}
