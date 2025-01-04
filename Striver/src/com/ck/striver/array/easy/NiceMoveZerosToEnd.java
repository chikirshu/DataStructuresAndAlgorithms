package com.ck.striver.array.easy;

// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/logic-building/move-zeros-to-end/submissions
public class NiceMoveZerosToEnd {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        moveZerosToEndI(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        int[] nums2 = {1,2,3,4,5};
        moveZerosToEndII(nums2);
        for(int i=0;i<nums2.length;i++){
            System.out.print(nums2[i]+" ");
        }
    }

    private static void moveZerosToEndII(int[] nums){
        int i=0, j=0, n=nums.length;
        while(i<n){
            if(nums[i]!=0){
                swap(nums, i, j);
                j++;
            }
            i++;
        }
    }

    /*
        Time Complexity:O(n) because we traverse the array once with a while loop, and swapping elements takes O(1) time.
        Space Complexity:O(1) as we are using a constant amount of extra space for variables i, j, and temp.
    */
    // Optimized
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /*
        Time Complexity:O(n) since it iterates over the array twice
        Space Complexity:O(n) for the temporary array used to store non-zero elements
    */
    // Brute Force
    private static void moveZerosToEndI(int[] nums){
        int n=nums.length, k=0;
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                temp[k++]=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            nums[i]=temp[i];
        }
    }

    // failed due to outer for loop for 0,20,0,-20,0,20
    // attempt on the lines of optimized but failed miserably
    private static void moveZerosToEndFailed(int[] nums) {
        int n = nums.length, consecutiveZeros=0, totalZeros=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                consecutiveZeros++;
                totalZeros++;
            }
            else{
                if(consecutiveZeros>0){
                    leftRotateArray(nums, consecutiveZeros, n, i);
                    consecutiveZeros=0;
                }
            }
        }
    }

    private static void leftRotateArray(int[] nums, int k, int n, int start) {
        k=k%n;

        for(int i=start;i<n;i++){
            nums[i-k]=nums[i];
        }
        for(int i=n-k;i<n;i++){
            nums[i]=0;
        }

    }
}
