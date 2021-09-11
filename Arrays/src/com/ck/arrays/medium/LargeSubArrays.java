package com.ck.arrays.medium;

import java.util.Scanner;
// Large sub-arrays - open
// https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/large-sub-arrays-5bd8005b/?utm_source=header&utm_medium=search&utm_campaign=he-search
public class LargeSubArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int idx = 0, start = 0, sum = 0, res = 0;
			int[] arr1 = new int[n];
			int[] arr2 = new int[n * 2];

			for (int j = 0; j < n; j++) {
				arr1[idx++] = sc.nextInt();
			}

			for (int j = 0; j < n; j++) {
				arr2[j] = arr1[j];
				arr2[j + n] = arr1[j];
			}
			// sum+=arr2[start];
			for(int j=0;j<arr2.length;j++){
                for(int p=j;p<arr2.length;p++){
                    if(sum+arr2[p]<=k){
                        sum+=arr2[p];
                        res++;
                    }
                    else{
                        sum=0;
                        break;
                    }
                 }
            }
            System.out.println(res);
        }

	}

}
