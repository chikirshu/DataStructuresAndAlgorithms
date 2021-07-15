package com.ck.strings.easy;

import java.util.Stack;

// LC - 1221 : Split a String in Balanced Strings - Return the maximum amount of split balanced strings.
public class SplitStringInBalancedStrings {

	public static void main(String[] args) {
		/*
		 * Confusing part order of R and L does not matter as it is in RRRLLRLL. Also, all substrings should combine to form s.
		 * Output is not 3 for RL, RL and LR
		 * Input: s = "RLRRRLLRLL"
		 * Output: 2
	     * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
	     */
		System.out.println(balancedStringSplitI("RLRRLLRLRL"));
		System.out.println(balancedStringSplitII("RLRRLLRLRL"));
	}

	// O(N) time & O(N) space
	public static int balancedStringSplitI(String s) {
		Stack<Character> stk = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L' && stk.size() > 0 && stk.peek() == 'R') {
				stk.pop();
			} else if (s.charAt(i) == 'R' && stk.size() > 0 && stk.peek() == 'L') {
				stk.pop();
			} else {
				stk.push(s.charAt(i));
			}
			if (stk.isEmpty()) {
				cnt++;
			}
		}
		return cnt;
	}

	// O(N) time & O(1) space
	public static int balancedStringSplitII(String s) {
		int res = 0, cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			cnt += s.charAt(i) == 'L' ? 1 : -1;
			if (cnt == 0)
				res++;
		}
		return res;
	}

}
