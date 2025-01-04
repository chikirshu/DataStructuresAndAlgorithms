package com.ck.striver.array.easy;


// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/fundamentals/left-rotate-array/submissions
public class NiceLeftRotateArrayByK {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        int k=2;
        leftRotateArrayByKI(nums, k);
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }

        System.out.println();

        int[] nums2 = {1,2,3,4,5,6};
        leftRotateArrayByKII(nums2, k);
        for (int i=0;i<nums2.length;i++){
            System.out.print(nums2[i]+" ");
        }

        System.out.println();

        int[] nums3 = {1,2,3,4,5,6};
        leftRotateArrayByKIII(nums3, k);
        for (int i=0;i<nums3.length;i++){
            System.out.print(nums3[i]+" ");
        }

    }

    /*
        Time Complexity:O(n*k) where n is the array length and k is the number of rotations
        Space Complexity:O(1) as no additional space is used except for a few variables
    */
    // Brute force
    private static void leftRotateArrayByKI(int[] nums, int k) {
        int n= nums.length;
        if(n==1) return;
        for(int i=0;i<k;i++){
            leftRotateArrayByOne(nums, n);
        }
    }

    private static void leftRotateArrayByOne(int[] nums, int n){
        int temp=nums[0];
        for(int i=1;i<n;i++){
            nums[i-1]=nums[i];
        }
        nums[n-1]=temp;
    }


    /*
        Time Complexity:The time complexity is O(n), since we traverse the array a constant number of times, specifically 3 times (initialization and 2 shifts).
        Space Complexity:The space complexity is O(k), since we use an additional array of size k to store the elements that are being rotated.
     */
    // Better
    private static void leftRotateArrayByKII(int[] nums, int k) {
        int n= nums.length;
        if(n==1) return;
        k = k%n;
        int[] temp = new int[k];
        int j=0;
        for(int i=0;i<k;i++){
            temp[j++]=nums[i];
        }
        j=0;
        for(int i=k;i<n;i++){
           nums[j++]=nums[i];
        }
        // n-k here is equal to previous value of j
        for(int i=n-k;i<n;i++){
            nums[i]=temp[i-(n-k)];// can also introduce a variable here that will start from 0 till rem-1 instead of rem-i+1
        }
    }

    /*
        Time Complexity:O(n) where n is the length of the array, due to three reverse operations each taking linear time
        Space Complexity:O(1) as the algorithm uses a constant amount of extra space
    */
    // Optimized
    private static void leftRotateArrayByKIII(int[] nums, int k) {
        int n=nums.length;
        if(n==1)return;
        k=k%n;

        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);
    }
    public static void reverseWillNotWorkForSubArrays(int[] nums, int start, int end){
        end=end+1;
        for(int i=start;i<end/2;i++){
            int temp=nums[i];
            nums[i]=nums[end-1-i];
            nums[end-1-i]=temp;
        }
    }

    public static void reverse(int[] nums, int start, int end){
        int temp=-1;
        while(start<end){
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
