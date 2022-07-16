package com.ck.linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, DoublyLinkedList> map;
	int capacity;

	DoublyLinkedList head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new DoublyLinkedList();
		tail = new DoublyLinkedList();
		head.next = tail;
		tail.prev = head;
	}

	class DoublyLinkedList {

		int key;
		int value;

		DoublyLinkedList next;
		DoublyLinkedList prev;
	}

	private void addFirst(DoublyLinkedList node) {
		DoublyLinkedList temp = head.next;
		node.next = temp;
		node.prev = head;

		temp.prev = node;
		head.next = node;
	}

	private void removeNode(DoublyLinkedList node) {
		DoublyLinkedList prevNode = node.prev;
		DoublyLinkedList nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;

		node.next = null;
		node.prev = null;
	}

	private void moveToFront(DoublyLinkedList node) {
		removeNode(node);
		addFirst(node);
	}

	public int get(int key) {
		if (map.get(key) != null) {
			System.out.println("current value = " + map.get(key).value);
			moveToFront(map.get(key));
			return map.get(key).value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.size() == capacity) {
			if (map.get(key) == null) {
				map.remove(tail.prev.key);
				removeNode(tail.prev);

				System.out.println("map = " + map + " key = " + key);
			}
		}
		DoublyLinkedList node = new DoublyLinkedList();
		node.key = key;
		node.value = value;

		if (map.get(key) == null) {
			addFirst(node);
		} else {
			moveToFront(map.get(key));
		}
		map.put(key, node);
	}

	public static void main(String[] args) {

		LRUCache lru = new LRUCache(2);
		lru.put(2, 1);
		lru.put(2, 2);
		System.out.println(lru.get(2));
		lru.put(1, 1);
		lru.put(4, 1);
		System.out.println(lru.get(2));
	}

	/**
	 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
	 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
	 */

}
