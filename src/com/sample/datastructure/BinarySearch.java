package com.sample.datastructure;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(binarySearchWhile(a));
		System.out.println(binarySearchRec(a, 0, 9, 9));
		int a1[] = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10 };
		System.out.println(binarySearchRecFindLast(a1, 0, 16, 5));
		System.out.println(binarySearchRecFindFirst(a1, 0, 16, 5));
	}

	public static int binarySearchWhile(int arr[]) {
		int search = 4;
		int start = 0;
		int end = arr.length;
		int mid = end / 2;
		while (start <= end) {
			if (search == arr[mid]) {
				System.out.println("Element Found at location " + mid);
				return mid;
			} else if (search > arr[mid]) {
				start = mid;
				mid = (mid + end) / 2;
			} else {
				end = (start + end) / 2;
				mid = end / 2;
			}
		}
		return -1;
	}

	public static int binarySearchRec(int arr[], int start, int end, int search) {
		if (start <= end) {
			int mid = start + ((end - start) / 2);
			if (search > arr[mid]) {
				return binarySearchRec(arr, mid + 1, end, search);
			} else if (search < arr[mid]) {
				return binarySearchRec(arr, start, mid - 1, search);
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearchRecFindLast(int arr[], int start, int end, int search) {
		if (start <= end) {
			//System.out.println("start = " + start + " end " + end);
			int mid = start + (end - start) / 2;
			if (search > arr[mid]) {
				return binarySearchRecFindLast(arr, mid + 1, end, search);
			} else if (search < arr[mid]) {
				return binarySearchRecFindLast(arr, start, mid - 1, search);
			} else {
				return binarySearchRecFindLast(arr, mid + 1, end, search);
			}
		}
		if (arr[end] == search) {
			return end;
		}
		return -1;
	}
	
	public static int binarySearchRecFindFirst(int arr[], int start, int end, int search) {
		if (start <= end) {
			//System.out.println("start = " + start + " end " + end);
			int mid = start + (end - start) / 2;
			if (search > arr[mid]) {
				return binarySearchRecFindFirst(arr, mid + 1, end, search);
			} else if (search < arr[mid]) {
				return binarySearchRecFindFirst(arr, start, mid - 1, search);
			} else {
				return binarySearchRecFindFirst(arr, start, mid - 1, search);
			}
		}
		if (arr[end] == search) {
			return end;
		}
		return -1;
	}

}
