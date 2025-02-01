package com.ck.striver.array.medium;

// When you forget common sense and try to over optimize things. Felt hard implementation of isJIncremented
public class RearrangeElementsBySign {

    public static void main(String[] args){
        int[] nums={-1,1};
        rearrangeBySign(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    /*
        Time Complexity:O(n^2) due to the nested operations in the doSwaps method and the while loop iterations
        Space Complexity:O(1) only uses a constant amount of additional space for variables
    */
    // without using extra space
    private static void rearrangeBySign(int[] nums) {
        int currentSign=1,i=0,j=1;
        boolean isJIncremented=false;
        while(j<nums.length && i<=j){
            isJIncremented=false;
            if(nums[i]/Math.abs(nums[i]) != currentSign){
                //int replacement = findReplaceableIndexForCurrentSign(nums, i, j);
                if(nums[i]/Math.abs(nums[i]) != nums[j]/Math.abs(nums[j])){
                    doSwaps(nums, i, j);
                    i++;
                    currentSign=currentSign*-1;
                    j=i+1;
                    isJIncremented=true;
                }
                if(!isJIncremented) j++;
            }
            else{
                i++;
                j++;
                currentSign=currentSign*-1;
            }
        }
    }

    private static void doSwaps(int[] nums, int i, int replacement) {
        int temp = nums[i], k=0;
        nums[i] = nums[replacement];

        for(k=replacement;k>i+1;k--){
            nums[k]=nums[k-1];
        }
        nums[k]=temp;
    }

    private static int findReplaceableIndexForCurrentSign(int[] nums, int i, int j) {
        while(j<nums.length){
            if(nums[i]/Math.abs(nums[i]) != nums[j]/Math.abs(nums[j])){
                return j;
            }
            j++;
        }
        return Integer.MIN_VALUE;
    }
}
