package com.sample.datastructure.recursion;

import java.util.Arrays;

/*
 * Merge Sort is a Divide and Conquer algorithm. 
 * It splits input array in two halves, 
 * calls itself for the two halves and then merges the two sorted halves
 * 
 * Note: during split process it creates too many memory spaces. 
 * 
 * https://www.geeksforgeeks.org/merge-sort/
 */
public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 6, 1, 8, 5, 7 };
		System.out.println(Arrays.toString(arr));
		split(arr);
	}

	private static int[] copyArray(int source[], int startIndex, int endIndex) {
		int[] destination = new int[endIndex - startIndex +1];
		for (int i = startIndex, j = 0; i <= endIndex; i++) {
			destination[j++] = source[i];
		}
		return destination;
	}

	public static int[] split(int inputArr[]) {
		int leftIndex = 0;
		int rightIndex = inputArr.length - 1;
		if (rightIndex <= leftIndex) {
			return inputArr;
		}
		int mid = leftIndex + rightIndex / 2;

		// Copy left side data from 0 to mid
		int leftArr[] = copyArray(inputArr, leftIndex, mid);
		// Copy right side data from mid to end
		int rightArr[] = copyArray(inputArr, mid + 1, rightIndex);

		split(leftArr);
		split(rightArr);
		merge(leftArr, rightArr, inputArr);
		return inputArr;
	}

	public static int[] merge(int left[], int right[], int result[]) {
		int i, j, k = 0;
		for (i = 0, j = 0, k = 0; i < result.length; i++) {
			if (j == left.length) {
				result[i] = right[k];
				k++;
			} else if (k == right.length) {
				result[i] = left[j];
				j++;
			} else if (left[j] < right[k]) {
				result[i] = left[j];
				j++;
			} else {
				result[i] = right[k];
				k++;
			}
		}
		System.out.println(Arrays.toString(result));
		return result;
	}

}
