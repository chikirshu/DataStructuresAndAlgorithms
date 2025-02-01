package com.ck.striver.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/plus/dsa/arrays/faqs-medium/4-sum?tab=submissions
public class FourSum {

    public static void main(String[] args){
        int[] nums = new int[]{87,97,-20,30,-3,-35,99,-96,73,-51,-3,43,-18,61,38,37,-25,51,-76,5,83,44,49,5,-61,82,
                -11,-60,29,19,-93,-44,75,95,-91,49,54,22,-4,70,78,83,60,44,71,-73,-99,74,-58,31,-33,-71,17,-24,-54,
                -37,-51,-54,47,-57,34,67,23,-45,50,26,64,100,82,77,78,-99,21,-34,94,-52,14,100,56,-91,55,16,-33,39,
                -94,29,-42,-27,100};
        int target = 1;
        System.out.println(getFourSum(nums, target));
    }

    /*
        Time Complexity:O(n^3) because it involves three nested loops: the outermost two loops and an inner while loop for the two-pointer approach, leading to roughly cubic complexity.
        Space Complexity:O(n) due to the sorting operation and temporary storage during solution building, but constant if the output list is not considered.
    */
    private static List<List<Integer>> getFourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> crnt = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if(n<4) return new ArrayList<>();
        int i=0, j=1, left=2, right=n-1, val=0;
        for(i=0; i<n-2;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(j=i+1;j<n-1;j++){
                //Note -  check this condition to avoid duplicate combination for same j, but nums[j] and nums[i] can be same
                if(j-1!=i && nums[j]==nums[j-1]) continue;
                left=j+1;
                right=n-1;
                while(left<right){
                    val = nums[i]+nums[j]+nums[left]+nums[right];
                    if(val==target){
                        crnt = new ArrayList<>();
                        crnt.add(nums[i]);
                        crnt.add(nums[j]);
                        crnt.add(nums[left]);
                        crnt.add(nums[right]);
                        ans.add(crnt);
                        while(left<right && nums[left]==nums[left+1])left++;
                        while(left<right && nums[right]==nums[right-1])right--;
                        left++;
                        right--;
                    }
                    else if(val<target){
                        while(left<right && nums[left]==nums[left+1])left++;
                        left++;
                    }
                    else{
                        while(left<right && nums[right]==nums[right-1])right--;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
