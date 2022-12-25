  package com.ck.list.medium;

import java.util.ArrayList;
import java.util.List;

public class FruitArrangementInRow {

	public static void main(String[] args) {
		int[] arr = new int[] {5,4,3}; // 2 Apples, 3 Mangoes, 1 Bananas
		fruitArrangement(arr, new ArrayList<>());
	}

	private static void fruitArrangement(int[] arr, List<Integer> ans) {
		
		if(allZeros(arr)) {
			for(Integer i : ans) {
				System.out.print(i==0 ? "M " : i==1 ? "O " : "A ");
			}
			System.out.println();
		}
		
		for(int i=0;i<arr.length;i++) {
			if(ans.size()>0 && ans.get(ans.size()-1)==i) continue;
			if(arr[i]>0) {
				ans.add(i);
				arr[i]--;
				fruitArrangement(arr,ans);
				arr[ans.get(ans.size()-1)]++;
				ans.remove(ans.size()-1);
			}
		}
	}

	private static boolean allZeros(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) return false;
		}
		return true;
	}

}
