package com.ck.strings.easy;

// LC - 1678 : Goal Parser Interpretation
public class GoalParser {

	public static void main(String[] args) {
		System.out.println(interpretII("G()(al)"));
	}

	public static String interpretI(String command) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'G') {
				sb.append('G');
			} else if (i + 1 < command.length() && command.charAt(i + 1) == ')') {
				sb.append('o');
				i++;
			} else {
				sb.append("al");
				i = i + 3;
			}
		}
		return sb.toString();
	}

	public static String interpretII(String command) {
		String res = command.replace("()", "o");
		res = res.replace("(al)", "al");
		return res;
	}

}
