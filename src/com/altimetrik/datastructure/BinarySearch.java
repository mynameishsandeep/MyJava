package com.altimetrik.datastructure;

public class BinarySearch {

	public static void main(String[] args) {
		Integer arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int searchElement = 10;
		int mid = arr.length / 2;
		int upperBound = arr.length;
		int lowerBound = 1;
		while (true) {

			mid = lowerBound + (upperBound - lowerBound) / 2;

			if(upperBound<lowerBound) {
				break;
			}
			if (searchElement == arr[mid]) {
				System.out.println("Element found at index " + mid);
				break;
			} else if (searchElement > arr[mid]) {
				lowerBound = mid + 1;
			} else if (searchElement < arr[mid]) {
				upperBound = mid - 1;
			}
		}
	}
}
