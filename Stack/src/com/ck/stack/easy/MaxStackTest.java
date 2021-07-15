package com.ck.stack.easy;

public class MaxStackTest {

	public static void main(String[] args) {
		MaxStack stk = new MaxStack();
		stk.push(5);
		stk.push(1);
		stk.push(5);
		printStk(stk);
		System.out.println("Top is " + stk.top());
		System.out.println("Pop max " + stk.peekMax());
		stk.popMax();
		System.out.println("Top is " + stk.top());
		System.out.println("Max is " + stk.peekMax());
		System.out.println("Removed " + stk.top());
		stk.pop();
		System.out.println("Top is " + stk.top());
		printStk(stk);
	}

	private static void printStk(MaxStack stk) {

		System.out.println("Printing Stack : ");
		for (int i = 0; i <= stk.topIdx; i++) {
			System.out.print(stk.arr[i] + " ");
		}
		System.out.println();
	}

}
