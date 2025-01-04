package com.ck.striver.array.easy;

/*
    Time Complexity:O(n), where n is the length of the nums array due to the single loop iterating through all elements
    Space Complexity:O(1), as only a constant amount of space is used for the max variable
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/fundamentals/largest-element/submissions
public class LargestElement {

    public static void main(String[] args){
        int[] nums= {3,3,6,1};
        System.out.println(findLargestElement(nums));
    }

    private static int findLargestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(max<=nums[i]){
                max=nums[i];
            }
        }
        return max;
    }
}
