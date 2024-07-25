package com.ck.arrays.medium;

//LC - 162 : Find Peak Element
// https://leetcode.com/problems/find-peak-element/description/
public class FindPeak {

    public static void main(String[] args){
        int[] nums = {3,4,3,2,1};
        int res = findPeakElement(nums);
        System.out.println(res);
    }

    public static int findPeakElement(int[] nums) {
        int low=1, high=nums.length-2, mid=0, n=nums.length;

        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        while(low<=high){
            mid = low+(high-low)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            if(nums[mid]>nums[mid-1]) low=mid+1;
            else if(nums[mid]>nums[mid+1]) high=mid-1;
            else low=mid+1;
        }

        return -1;

    }
}
