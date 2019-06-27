package com.sample.datastructure;

/*
 * ================
 * If we use "int mid =(low + high) / 2;"
 *  
 * Then if the sum of low and high is greater than the maximum positive int value (2^31 - 1). 
 * The sum overflows to a negative value, and the value stays negative when divided by two. 
 * Then code throws ArrayIndexOutOfBoundsException.
 * 
 * So use "int mid = low + ((high - low) / 2);"
 * ================
 * Iterative solution has same O(logn) runtime complexity as the recursive solution but has better memory complexity.
	Memory Complexity for Iterative : Constant, O(1).
	Memory Complexity for Recursion : O(logn) as recursion consume memory on the stack.
	==================
 */
public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(binarySearchRec(a, 0, 9, 9));
		int nums[] = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10 };
		System.out.println(binarySearchRecFindFirst(nums, 0, nums.length - 1, 5));
		System.out.println(binarySearchRecFindLast(nums, 0, nums.length - 1, 5));
	}

	public static int binarySearchRec(int nums[], int low, int high, int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				return binarySearchRec(nums, low, mid - 1, target);
			} else {
				return binarySearchRec(nums, mid + 1, high, target);
			}
		}

		return -1;
	}

	/* For the search key, if duplicate is found on the input array. Get the index of first duplicate.
	
	Input : arr[] = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10}    
	x = 5
	Output : First Occurrence = 4
	 */
	public static int binarySearchRecFindFirst(int nums[], int low, int high, int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return binarySearchRecFindFirst(nums, low, mid - 1, target);
			} else if (nums[mid] > target) {
				return binarySearchRecFindFirst(nums, low, mid - 1, target);
			} else {
				return binarySearchRecFindFirst(nums, mid + 1, high, target);
			}
		}
		if (nums[low] == target) {
			return low;
		}
		return -1;
	}

	/* For the search key, if duplicate is found on the input array. Get the index of last duplicate.
	
	 Input : arr[] = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10}    
	 x = 5
	 Output : Last Occurrence = 11
	 */
	public static int binarySearchRecFindLast(int nums[], int low, int high, int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return binarySearchRecFindLast(nums, mid + 1, high, target);
			} else if (nums[mid] > target) {
				return binarySearchRecFindLast(nums, low, mid - 1, target);
			} else {
				return binarySearchRecFindLast(nums, mid + 1, high, target);
			}
		}
		if (nums[high] == target) {
			return high;
		}
		return -1;
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

}
