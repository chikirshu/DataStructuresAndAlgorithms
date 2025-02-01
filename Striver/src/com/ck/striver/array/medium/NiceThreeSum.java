package com.ck.striver.array.medium;

import java.util.*;

// https://takeuforward.org/plus/dsa/arrays/faqs-medium/3-sum
public class NiceThreeSum {

    public static void main(String[] args){
        int[] nums={2, -2, 0, 3, -3, 5};
        System.out.println(getTriplets(nums)); // wrong
        System.out.println(getTripletsII(nums));
        System.out.println(getTripletsIII(nums));
    }
    // -1, -1, -1, 2, 3
    /*
        Time Complexity:The time complexity is O(n^2) due to the nested loop structure after sorting, which costs O(n log n).
        Space Complexity:The space complexity is O(n) due to the space required for storing the result list and the space used by the sorting algorithm.
    */
    private static List<List<Integer>> getTripletsII(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> crnt = new ArrayList<>();
        int n = nums.length;
        int left=0, right=n-1, val=0;
        Arrays.sort(nums);
        if(n<3 || nums[0]>0 || nums[n-1]<0) return new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i!=0 && nums[i-1]==nums[i]) continue;
            left = i+1;
            right=n-1;
            while(left<right){
                val = nums[i]+nums[left]+nums[right];
                if(val==0){
                    crnt = new ArrayList<>();
                    crnt.add(nums[i]);
                    crnt.add(nums[left]);
                    crnt.add(nums[right]);
                    ans.add(crnt);
                    while(left<right && nums[left]==nums[left+1])left++;
                    while(left<right && nums[right]==nums[right-1])right--;
                    left++;
                    right--;
                }
                else if(val<0){
                    while(left<right && nums[left]==nums[left+1])left++;
                    left++;
                }
                else{
                    while(left<right && nums[right]==nums[right-1])right--;
                    right--;
                }
            }
        }
        return ans;
    }

    /*
        Time Complexity:The time complexity of the code is O(n^2), considering the nested loops where 'n' is the length of the input array.
        // verify - Space Complexity:The space complexity is O(n) due to the use of a HashSet to store up to 'n' elements in the worst case.
    */
    //Better - without sorting - using hashmap
    private static List<List<Integer>> getTripletsIII(int[] nums){
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> crnt = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            set.clear();
            for(int j=i+1;j<nums.length;j++){
                if(set.contains(-(nums[i]+nums[j]))){
                     //crnt.clear(); Note - crnt.clear will not work because this is also added to ans. On clearing list will clear previous list in our ans
                    crnt = new ArrayList<>();
                    crnt.add(nums[i]);
                    crnt.add(nums[j]);
                    crnt.add(-(nums[i]+nums[j]));
                    Collections.sort(crnt);
                    ans.add(crnt);
                }
                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }

    // Will give TLE. Note how the sorting is working here. Sort the triplets and then add it to the set, which will make
    // sure duplicates are always overriden
    /*
        Time Complexity: O(N3 x log(no. of unique triplets)), where N is size of the array. Using 3 nested loops & inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
        Space Complexity: O(2 x no. of the unique triplets) for using a set data structure and a list to store the triplets.
    */
    public List<List<Integer>> threeSum(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        // Check all possible triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Found a triplet that sums up to target
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        /* Sort the triplet to ensure
                        uniqueness when storing in set*/
                        Collections.sort(temp);
                        tripletSet.add(temp);
                    }
                }
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(tripletSet);

        //Return the ans
        return ans;
    }

    // Will fail if array has duplicates
    private static List<List<Integer>> getTriplets(int[] nums) {
        Map<Integer, List<Integer>> ans = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                Integer k = map.get(-(nums[i]+nums[j]));
                if(k!=null && k!=i && k!=j && !ans.containsKey(i+j+k)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.put((i+j+k), list);
                }
            }
        }
        return new ArrayList<>(ans.values());
    }
}
