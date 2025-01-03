package com.ck.striver.basics.recursion;

import java.util.List;

/*
    Time Complexity:O(n) where n is the size of the nums list as it iterates through the list once
    Space Complexity:O(1) as it uses a constant amount of space regardless of input size
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/check-if-the-array-is-sorted/submissions
public class IsSortedArray {

    public static void main(String[] args){
        int nums[] = {1,2,3,4,5};
        System.out.println(isSortedArray(nums));
    }

    // for array
    private static boolean isSortedArray(int[] nums) {
        if(nums.length==0 || nums.length==1) return true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]) return false;
        }
        return true;
    }

    // for list
    private boolean isSortedArray(List<Integer> nums) {
        if(nums==null || nums.isEmpty() || nums.size()==1) return true;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)<nums.get(i-1)) return false;
        }
        return true;
    }
}
