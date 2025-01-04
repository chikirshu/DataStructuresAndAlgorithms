package com.ck.striver.array.easy;

/*
    Time Complexity:O(n) where n is the number of elements in the array, due to a single loop through the array
    Space Complexity:O(1) as only a constant amount of extra space is used for variables
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/fundamentals/second-largest-element/submissions
public class SecondLargestElement {

    public static void main(String[] args){
        int[] nums = {12,12,7,7,2,2,10,10,10};
        System.out.println(findSecondLargest(nums));
    }

    private static int findSecondLargest(int[] nums) {
        int maxElement=Integer.MIN_VALUE, secondMaxElement=-1;
        for(int i=0;i<nums.length;i++){
            if(maxElement<nums[i]){
                secondMaxElement=maxElement;
                maxElement=nums[i];
            }
            else if(secondMaxElement<nums[i] && nums[i]!=maxElement){
                secondMaxElement=nums[i];
            }
        }
        return secondMaxElement==Integer.MIN_VALUE?-1:secondMaxElement;
    }
}
