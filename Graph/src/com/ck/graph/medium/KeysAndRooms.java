package com.ck.graph.medium;

import java.util.ArrayList;
import java.util.List;

// LC - 841 : Keys and Rooms
// https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRooms {

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		List<Integer> room = new ArrayList<>();
		room.add(1);
		room.add(3);
		rooms.add(room);
		room = new ArrayList<>();
		room.add(3);
		room.add(0);
		room.add(1);
		rooms.add(room);
		room = new ArrayList<>();
		room.add(2);
		rooms.add(room);
		room = new ArrayList<>();
		room.add(0);
		room.add(1);
		rooms.add(room);
		System.out.println(canVisitAllRooms(rooms));
	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

		boolean[] visited = new boolean[rooms.size()];
		visited[0] = true;
		visitRoom(rooms, visited, 0);
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	public static void visitRoom(List<List<Integer>> rooms, boolean[] visited, int crntRoom) {
		for (int room : rooms.get(crntRoom)) {
			if (!visited[room]) {
				visited[room] = true;
				visitRoom(rooms, visited, room);
			}
		}
	}

}
