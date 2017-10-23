package com.sample.tricky;
// https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
// https://www.coursera.org/learn/algorithms-part1/lecture/EcF3P/quick-findarr
//1) Union(2, 1) 
//2) Union(4, 3)
//3) Union(8, 4)
//4) Union(9, 3)
public class FindConnectedComponents {

	public static void main(String[] args) {
		Integer arr[] = new Integer[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = i;
		}
	}

	public static void doUnion(Integer arr[], Integer pointA, Integer pointB) {
		arr[pointA] = arr[pointB];
	}

	public static void doFind(Integer arr[], Integer pointA, Integer pointB) {
		
	}
}
