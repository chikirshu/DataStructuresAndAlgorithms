package com.ck.striver.array.easy;

/*
    Time Complexity:O(n) where n is the length of the array due to the single while loop iterating through the array
    Space Complexity:O(1) since only a fixed amount of extra space is used for variables
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/logic-building/remove-duplicates-from-sorted-array/submissions
public class NiceRemoveDuplicatesFromSortedArray {

    public static void main(String[] args){
        int[] nums = {0,0,1,1,2};
        int uniqueElements = removeDuplicates(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        System.out.println("Unique elements="+uniqueElements);
    }

    private static int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;

        int start=0, end=1, uniqueElements=1;
        while(end<n){
            if(nums[start]==nums[end]){
                end++;
            }
            else{
                if(start+1!=end){
                    // No need to swap, just bring further element closer
                    //swap(nums, start+1, end);
                    move(nums, start+1, end);
                }
                start++;
                end++;
                uniqueElements++;
            }
        }
        return uniqueElements;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private static void move(int[] nums, int i, int j) {
        nums[i]=nums[j];
    }
}
