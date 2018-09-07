package com.sample.datastructure;

/*
 * If we use "int mid =(low + high) / 2;"
 *  
 * Then if the sum of low and high is greater than the maximum positive int value (2^31 - 1). 
 * The sum overflows to a negative value, and the value stays negative when divided by two. 
 * Then code throws ArrayIndexOutOfBoundsException.
 * 
 * So use "int mid = low + ((high - low) / 2);"
 */
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
		int low = 0;
		int high = arr.length;
		int mid = high / 2;
		while (low <= high) {
			if (search == arr[mid]) {
				System.out.println("Element Found at location " + mid);
				return mid;
			} else if (search > arr[mid]) {
				low = mid;
				mid = (mid + high) / 2;
			} else {
				high = (low + high) / 2;
				mid = high / 2;
			}
		}
		return -1;
	}

	public static int binarySearchRec(int arr[], int low, int high, int search) {
		if (low <= high) {
			int mid = low + ((high - low) / 2);
			if (search > arr[mid]) {
				return binarySearchRec(arr, mid + 1, high, search);
			} else if (search < arr[mid]) {
				return binarySearchRec(arr, low, mid - 1, search);
			} else {
				return mid;
			}
		}
		return -1;
	}

	/* For the search key, if duplicate is found on the input array. Get the index of last duplicate.
	
	 Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}    
	 x = 5
	 Output : Last Occurrence = 5
	 */
	public static int binarySearchRecFindLast(int arr[], int low, int high, int search) {
		if (low <= high) {
			//System.out.println("low = " + low + " high " + high);
			int mid = low + (high - low) / 2;
			if (search > arr[mid]) {
				return binarySearchRecFindLast(arr, mid + 1, high, search);
			} else if (search < arr[mid]) {
				return binarySearchRecFindLast(arr, low, mid - 1, search);
			} else {
				return binarySearchRecFindLast(arr, mid + 1, high, search);
			}
		}
		if (arr[high] == search) {
			return high;
		}
		return -1;
	}

	/* For the search key, if duplicate is found on the input array. Get the index of first duplicate.
	
	Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}    
	x = 5
	Output : First Occurrence = 2
	 */
	public static int binarySearchRecFindFirst(int arr[], int low, int high, int search) {
		if (low <= high) {
			//System.out.println("low = " + low + " high " + high);
			int mid = low + (high - low) / 2;
			if (search > arr[mid]) {
				return binarySearchRecFindFirst(arr, mid + 1, high, search);
			} else if (search < arr[mid]) {
				return binarySearchRecFindFirst(arr, low, mid - 1, search);
			} else {
				return binarySearchRecFindFirst(arr, low, mid - 1, search);
			}
		}
		if (arr[high] == search) {
			return high;
		}
		return -1;
	}

}
