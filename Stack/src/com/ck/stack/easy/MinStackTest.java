package com.ck.stack.easy;

public class MinStackTest {

	public static void main(String[] args) {
		MinStack stk = new MinStack();
		stk.push(-2);
		stk.push(0);
		stk.push(-3);
		printStk(stk);
		System.out.println("Min is " + stk.getMin());
		System.out.println("Removed "+stk.top());
		stk.pop();
		System.out.println("Top is " + stk.top());
		System.out.println("Min is " + stk.getMin());
		printStk(stk);
	}

	private static void printStk(MinStack stk) {
		
		System.out.println("Printing Stack : ");
		for (int i = 0; i <= stk.topIdx; i++) {
			System.out.print(stk.arr[i] + " ");
		}
		System.out.println();
	}

}
