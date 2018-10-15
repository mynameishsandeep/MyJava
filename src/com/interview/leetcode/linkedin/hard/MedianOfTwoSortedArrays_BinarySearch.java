package com.interview.leetcode.linkedin.hard;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 * 
 */
public class MedianOfTwoSortedArrays_BinarySearch {

	/**
	 *
	 * Solution:
	 * 1) Choose small length array as Array1
	 * 2) Pick equal number of elements in "Array1Left + Array2Left == Array2Right+Array2Right.
	 * Ex: [1,2,3,4,5][6,7,8,9,10,11,12,13,14]--> 5+9 = 14
	 * Since we take Array1 as source. 
	 * mid for Array1 is 5+1/2=3...
	 * Then mid for Array2 should be 4((Array1.length+Array2.length)/2-mid of array1)... 
	 * 
	 * 3) Pick 2 elements from Array1 lets say array1Left, array1Right and 2 elements from Array2 array2Left,array2Right
	
	 * 			array1Left || array2Left
	 *          =========================
	 * 			array2Left || array2Right
	 * 
	 * Do binary Search till array1Left <= array2Right && array2Left <= array1Right
	 * Ex: [2,4,6,8,10][1,3,5,7,9] --> array1Left=6, array1Right=8, array2Left=5, array2Right=7
	 * 
	 * 	6<=7 && 5<=8
	 *  
	 *4) If array1Left > array2Right --> move right
	 *5) If array1Left < array2Right --> move left
	 * 
	 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
	 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
	 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
	 *
	 * Time complexity is O(log(min(x,y))
	 * Space complexity is O(1)
	 *
	 */

	public double findMedianSortedArrays(int array1[], int array2[], int array1LowIndex, int array1HighIndex) {
		if (array1LowIndex <= array1HighIndex) {
			int midOfArray1Index = (array1LowIndex + array1HighIndex) / 2;
			int midOfArray2Index = (array1.length + array2.length + 1) / 2 - midOfArray1Index;

			//if midOfArray1Index is 0 it means nothing is there on left side. Use -INF for array1LeftValue
			//if midOfArray2Index is length of input then there is nothing on right side. Use +INF for minRightX
			int array1LeftValue = (midOfArray1Index == 0) ? Integer.MIN_VALUE : array1[midOfArray1Index - 1];
			int array1RightValue = (midOfArray1Index == array1.length) ? Integer.MAX_VALUE : array1[midOfArray1Index];

			int array2Left = (midOfArray2Index == 0) ? Integer.MIN_VALUE : array2[midOfArray2Index - 1];
			int array2Right = (midOfArray2Index == array2.length) ? Integer.MAX_VALUE : array2[midOfArray2Index];

			if (array1LeftValue <= array2Right && array2Left <= array1RightValue) {
				//We have partitioned array at correct place
				//In case of even length combined array size, get max of left and min of right to get the median 
				if ((array1.length + array2.length) % 2 == 0) {
					return ((double) Math.max(array1LeftValue, array2Left) + Math.min(array1RightValue, array2Right)) / 2;
				} else {//In case of odd length combined array size, get max of array1 left and array2 left .
					return (double) Math.max(array1LeftValue, array2Left);
				}
			} else if (array1LeftValue < array2Right) { //we are too far on left side for partitionX. Go on right side.
				return findMedianSortedArrays(array1, array2, midOfArray1Index + 1, array1HighIndex);
			} else { //we are too far on right side for partitionX. Go on left side.
				return findMedianSortedArrays(array1, array2, array1LowIndex, midOfArray1Index - 1);
			}
		}

		//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
		throw new IllegalArgumentException();
	}

	public double findMedianSortedArrays(int array1[], int array2[]) {
		//if array1 length is greater than array2, then switch them, so that array1 is smaller always
		if (array1.length > array2.length) {
			return findMedianSortedArrays(array2, array1,  0, array2.length);
		}
		return findMedianSortedArrays(array1, array2, 0, array1.length);
	}
	public static void main(String[] args) {
		MedianOfTwoSortedArrays_BinarySearch m = new MedianOfTwoSortedArrays_BinarySearch();
		//System.out.println(m.findMedianSortedArrays(new int[] {1,2,3}, new int[] {6,7,8,9,10,11,12,13,14}));
		//System.out.println(m.findMedianSortedArrays(new int[] {1,2,4,7}, new int[] {3,5,6}));
		//System.out.println(m.findMedianSortedArrays(new int[] { 1, 3, 4, 5 }, new int[] { 2, 6, 7 }));
		System.out.println(m.findMedianSortedArrays(new int[] { 1, 5, 6, 7 }, new int[] { 2, 3, 4 }));

	}
}
