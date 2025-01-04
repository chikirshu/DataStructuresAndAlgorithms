package com.ck.striver.array.easy;

/*
    Time Complexity:O(n) where n is the length of the input array, since we iterate through the array once
    Space Complexity:O(1) since we use a constant amount of space for variables regardless of input size
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/fundamentals/maximum-consecutive-ones/submissions
public class NiceMaximumConsecutiveOnes {

    public static void main(String[] args){
        int[] nums = {0,0,0,0,0};
        System.out.println("max 1 = "+getMaxConsecutiveOnes(nums));
        System.out.println("max 1 or 0 = "+getMaxConsecutiveOnesOrZeros(nums));
    }

    private static int getMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        int maxOneFreq = 0, crntMaxOneFreq=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                crntMaxOneFreq++;
            }
            else{
                maxOneFreq=Math.max(maxOneFreq, crntMaxOneFreq);
                crntMaxOneFreq=0;
            }
        }
        return Math.max(maxOneFreq, crntMaxOneFreq);
    }

    private static int getMaxConsecutiveOnesOrZeros(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;

        int maxOneFreq = 0, crntMaxOneFreq=0, maxZeroFreq = 0, crntMaxZeroFreq=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                crntMaxOneFreq++;

                maxZeroFreq=Math.max(maxZeroFreq, crntMaxZeroFreq);
                crntMaxZeroFreq=0;
            }
            else{
                crntMaxZeroFreq++;

                maxOneFreq=Math.max(maxOneFreq, crntMaxOneFreq);
                crntMaxOneFreq=0;
            }
        }
        maxZeroFreq=Math.max(maxZeroFreq, crntMaxZeroFreq);
        maxOneFreq=Math.max(maxOneFreq, crntMaxOneFreq);
        return Math.max(maxZeroFreq, maxOneFreq);
    }
}
