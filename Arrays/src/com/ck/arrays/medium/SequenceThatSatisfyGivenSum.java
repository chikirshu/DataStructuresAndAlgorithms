package com.ck.arrays.medium;

import java.math.BigInteger;
import java.util.Arrays;

public class SequenceThatSatisfyGivenSum {

	public static void main(String[] args) {
		System.out.println(numSubseqI(new int[] {3,5,6,7}, 9));
	}
	
	// Naive brute force approach; but on LC it will give TLE
	public static int numSubseqI(int[] nums, int target) {
        int start=-1,end=-1,cnt=0,n=nums.length, mod=(int)1e9+7;
        
        Arrays.sort(nums);
        int bitSize = (int)Math.pow(2,n);
        // find all subsequence
        // refer for more - https://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/
        for(int i=1;i<bitSize;i++){
            for(int j=0;j<n;j++){
                if(BigInteger.valueOf(i).testBit(j)){
                    if(start==-1)start=j;
                    if(end==-1 || nums[j]>=nums[end]) end=j;
                    
                }
            }
            //checking all sequence that will satisfy sum condition
            if(start!=-1 && end!=-1 && (nums[start]+nums[end])<=target)cnt++;
            start=-1;
            end=-1;
        }
        return cnt%mod;
    }

}
