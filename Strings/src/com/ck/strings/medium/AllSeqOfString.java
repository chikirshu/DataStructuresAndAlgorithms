package com.ck.strings.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AllSeqOfString {

	public static void main(String[] args) {
		System.out.println(findAllSeq("abcd"));
	}
	private static List<String> findAllSeq(String s){
		List<String> res = new ArrayList<>();
		String crnt="";
		int len = s.length();
		int n = (int)Math.pow(2, len)-1;
		for(int i=1;i<=n;i++) {
			crnt="";
			for(int j=0;j<len;j++) {
				if(BigInteger.valueOf(i).testBit(j)) {
					crnt+=String.valueOf(s.charAt(j));
				}
			}
			res.add(crnt);
		}
		System.out.println(BigInteger.valueOf(4).testBit(0));
		System.out.println(BigInteger.valueOf(4).testBit(1));
		return res;
	}

}
