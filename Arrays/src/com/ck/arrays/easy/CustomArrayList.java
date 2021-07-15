package com.ck.arrays.easy;

import java.util.Arrays;

public class CustomArrayList<E> {

	public static final int INITIAL_CAPACITY = 10;
	private Object[] arr;
	private int size;

	CustomArrayList() {
		this.arr = new Object[INITIAL_CAPACITY];
		this.size = 0;
	}

	public boolean add(Object e) {
		if (this.size == this.arr.length)
			checkCapacity();
		this.arr[this.size++] = e;
		return true;
	}

	public boolean remove(int index) {
		for (int i = index; i < this.size; i++) {
			this.arr[i] = this.arr[i + 1];
		}
		this.size--;
		checkCapacity();
		return true;
	}

	public boolean remove() {
		if (isEmpty())
			throw new IndexOutOfBoundsException();
		this.size--;
		return true;
	}

	public Object get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return this.arr[index];
	}

	private void checkCapacity() {
		if (this.size == this.arr.length) {
			this.arr = Arrays.copyOf(this.arr, this.size * 2);
		} else if (this.size < this.arr.length / 2) {
			this.arr = Arrays.copyOf(this.arr, this.arr.length / 2);
		}
	}

	public int getSize() {
		return this.size;
	}

	public void getCapacity() {
		System.out.println("\nList capacity is " + arr.length + "\n");
	}

	public boolean isEmpty() {
		return this.size == 0;
	}
}
