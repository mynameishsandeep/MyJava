package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/description/
 * 
 * Analysed Image is given in "US Problems Folder" "Minimal Triangle.jpg"
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 *input triangle : [[1], [2, 3], [4, 5, 6], [7, 8, 9, 10], [11, 12, 13, 14, 15]]
 *output triangle: [[1], [3, 4], [7, 8, 10], [14, 15, 17, 20], [25, 26, 28, 31, 35]]
 *
 */
public class MinimumWeightPathInTriangle {

	public static int minimumPathTotal(List<List<Integer>> triangle) {
		System.out.println(triangle);

		List<Integer> prev = triangle.get(0);
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> curr = triangle.get(i);

			// Add the prev row first column with current row first column
			curr.set(0, prev.get(0) + curr.get(0));

			// Add the prev row last column with current last column
			curr.set(curr.size() - 1, prev.get(prev.size() - 1) + curr.get(curr.size() - 1));

			// For 1 to n-1 do the below operation
			for (int j = 1; j < curr.size() - 1; j++) {
				// 1) Get the current row column value
				int d = curr.get(j);
				// 2) Get the minimum of previous row value
				int prevD = Math.min(prev.get(j - 1), prev.get(j));
				curr.set(j, d + prevD);
			}
			// Set the current row to previous row
			prev = curr;

		}
		System.out.println(triangle);
		return Collections.min(triangle.get(triangle.size() - 1));
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(4, 5, 6));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(7, 8, 9, 10));
		List<Integer> l5 = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));
		List<List<Integer>> l = new ArrayList<>();
		l.add(l1);
		l.add(l2);
		l.add(l3);
		l.add(l4);
		l.add(l5);

		System.out.println(minimumPathTotal(l));

	}
}
