package com.ck.graph.medium;

import java.util.ArrayList;
import java.util.List;

// LC - 797 : All Paths From Source to Target - Directed Acyclic Graph
// https://leetcode.com/problems/all-paths-from-source-to-target/
public class AllPathsSourceToTargetDAG {

	public static void main(String[] args) {
		System.out.println(allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> list = new ArrayList<>();
		getAllPaths(graph, new ArrayList<>(), list, 0);
		return list;
	}

	public static void getAllPaths(int[][] graph, List<Integer> crntList, List<List<Integer>> finalList,
			int crntElement) {

		crntList.add(crntElement);
		for (int j : graph[crntElement]) {
			getAllPaths(graph, crntList, finalList, j);
		}
		if (crntList.size() > 0 && crntList.get(crntList.size() - 1) == graph.length - 1) {
			finalList.add(new ArrayList<>(crntList));
		}
		crntList.remove(crntList.size() - 1);
	}

}
