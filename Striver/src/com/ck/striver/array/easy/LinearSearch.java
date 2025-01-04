package com.ck.striver.array.easy;

/*
    Time Complexity:The time complexity is O(n) due to the single loop that iterates through the array of length n.
    Space Complexity:The space complexity is O(1) since no additional space is used that depends on the input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/fundamentals/linear-search/submissions
public class LinearSearch {

    public static void main(String[] args){
        int[] nums = {2,3,4,5,3};
        int target = 3;
        System.out.println(findSmallestIndexOfTarget(nums, target));
    }

    private static int findSmallestIndexOfTarget(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }
}
