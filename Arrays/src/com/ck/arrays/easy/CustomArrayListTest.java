package com.ck.arrays.easy;

public class CustomArrayListTest {

	public static void main(String[] args) {
		CustomArrayList<Integer> list = new CustomArrayList<>();
		list.getCapacity();
		for (int i = 0; i < 12; i++) {
			list.add(i);
		}
		list.getCapacity();
		display(list);
		System.out.println("\nSize of list = " + list.getSize());
		System.out.println("2nd element = " + list.get(1));
		System.out.println("Removing last element");
		list.remove();
		System.out.println("Size of list = " + list.getSize());
		display(list);

	}

	private static void display(CustomArrayList<Integer> list) {
		System.out.println("Printing list");
		for (int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
