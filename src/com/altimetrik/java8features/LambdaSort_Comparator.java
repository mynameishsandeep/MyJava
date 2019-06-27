package com.altimetrik.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSort_Comparator {

	int data1;
	int data2;

	public String toString() {
		return data1 + " " + data2;
	}

	public LambdaSort_Comparator(int d1, int d2) {
		this.data1 = d1;
		this.data2 = d2;
	}
	// KClosestPointsToOrigin
	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, (p1, p2) -> { 
			int x1 = p1[0];
			int y1 = p1[1];
			int x2 = p2[0];
			int y2 = p2[1];
			return (x1 * x1) + (y1 * y1) - (x2 * x2) - (y2 * y2);
		});
		return Arrays.copyOfRange(points, 0, K);
	}
	public static void main(String[] args) {
		List<LambdaSort_Comparator> lList = new ArrayList<>();
		LambdaSort_Comparator l1 = new LambdaSort_Comparator(5, 30);
		LambdaSort_Comparator l2 = new LambdaSort_Comparator(4, 20);
		LambdaSort_Comparator l3 = new LambdaSort_Comparator(6, 10);
		lList.add(l1);
		lList.add(l2);
		lList.add(l3);
		// Sort by data1;
		Collections.sort(lList, (a, b) -> a.data1 - b.data1);
		lList.forEach(System.out::println);
		// Sort by data2;
		Collections.sort(lList, (a, b) -> a.data2 - b.data2);
		lList.forEach(System.out::println);

	}
}
