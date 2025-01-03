package com.ck.arrays.medium;

import java.util.*;

// LC - 15 : 3Sum
// https://leetcode.com/problems/3sum/description/
public class ThreeSum {

    public static void main(String[] args){
        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{0,0,0};
        System.out.println(threeSumLCSubmitted(nums));
    }

    public static List<List<Integer>> threeSumLCSubmitted(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n=nums.length;

        // If first element of the triplet is positive then it is not possible to get 0 sum. Since the array is sorted
        if(n<3 || nums[0]>0) return ans;

        for(int i=0;i<n-2;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = n-1;

            while(left<right){
                int val = nums[i]+nums[left]+nums[right];
                if(val==0){
                    ans.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else{
                    if(val<0) left++;
                    else right--;
                }
            }
        }
        return ans;
    }

    /*
    Skipping duplicates in the context of the three-sum problem means ensuring that you don't count the same triplet multiple times due to repeated values in the input array. Here's what it means for each element:

        1. **First Element**: When you select the first element of the triplet (let's call it `nums[i]`), if it's the same as the previous element (`nums[i - 1]`), then you skip this element to avoid counting the same triplet again. This ensures that you only start new triplets with unique first elements.

        2. **Second Element**: When you're moving the left pointer (let's say `left`) to find the second element of the triplet, if the next value (`nums[left]`) is the same as the previous value (`nums[left - 1]`), you skip it. This prevents adding the same second element in multiple triplets when the first and third elements are the same.

        3. **Third Element**: Similarly, when you're moving the right pointer (let's say `right`) to find the third element of the triplet, if the next value (`nums[right]`) is the same as the previous value (`nums[right + 1]`), you skip it. This ensures that you don't count the same third element in different triplets.

        ### Example:
        Consider the input array: `[-1, -1, 0, 1, 1, 2]`.

        - If you select `-1` as the first element, you only want to consider it once for forming triplets.
        - If the next element is also `-1`, you skip it to avoid forming the triplet `[-1, -1, 2]` twice.

        By skipping duplicates, you ensure that your result only includes unique triplets, like `[-1, 0, 1]` and `[-1, -1, 2]`, instead of variations that are essentially the same.
     */

    // i decides 1st element; left decide 2nd element; right decides 3rd element
    // for each responsible variables i, left and right we avoid duplicates by discarding their previous value if it is equal to its current value.
    // We are doing this to avoid scenarios where two variables other than the responsible have same value like suppose (-1,-1, 0).
    // If 1st and 2nd element are equal then 3rd element should always be unique. This ensures duplicate triplets are never considered.
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    finalAns.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return finalAns;
    }

    // Will not work; Wrong approach
    public static List<List<Integer>> threeSumWrong(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        Set<Integer> numsSet = new HashSet<>();
        List<Set<Integer>> ans = new ArrayList<>();
        List<List<Integer>> finalAns = new ArrayList<>();

        int n=nums.length;
        for(int i=0;i<n;i++){
            numsMap.put(nums[i], i);
        }

        int start=0, end=1;
        while(start<n && end<n){
            System.out.println("start="+start+" end="+end);
            int key = -1*(nums[start]+nums[end]);
            Integer val = numsMap.get(key);
            if( val!=null && val!=start && val!=end){
                Set<Integer> crntTriplet = new HashSet<>();
                crntTriplet.add(nums[start]);
                crntTriplet.add(nums[end]);
                crntTriplet.add(key);

                if(crntTriplet.size()==3 && checkIfAbsentInAns(crntTriplet, ans)){
                    ans.add(crntTriplet);
                }
                //start++;
            }

            end++;
            if((start!=n-1||start!=n)&&end==n){
                start++;
                end=start+1;
            }
        }

        for(Set<Integer> triplet : ans){
            List<Integer> newTriplet = new ArrayList<>(triplet);
            finalAns.add(newTriplet);
        }

        return finalAns;

    }

    public static boolean checkIfAbsentInAns(Set<Integer> crntTriplet, List<Set<Integer>> ans){
        System.out.println("ans=" + ans+ " crntTriplet = "+ crntTriplet);
        for(Set<Integer> triplet : ans){
            for(Integer i : crntTriplet){
                if(!triplet.contains(i)) return true;
            }
        }
        return ans==null||ans.size()==0;
    }
}
