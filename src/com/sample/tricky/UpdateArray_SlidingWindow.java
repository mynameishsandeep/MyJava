package com.sample.tricky;

import java.util.Arrays;

public class UpdateArray_SlidingWindow {

	public int[] replace_bruteForce(final int[] input) {
		int result[] = new int[input.length];
		for(int i=0; i<input.length; i++) {
			result[i] = input[i];
			for (int j=i+1; j<input.length; j++) {
				if(input[j-1]<input[j]) {
					result[i]+= input[j];
				}
			}
		}
		return result;
	}
	public int[] replace_SlidingWindow(final int[] input) {
		int currentSum = input[0];
		for(int i=0, j=1; j<input.length; ) {
			if(input[j-1]< input[j]) {
				currentSum += input[j];
				j++;
			} else {
				if(i+1 == j) {
					i++;
					j++;
				} else {
					int temp = input[i];
					input[i++] = currentSum;
					currentSum -= temp;
				}
			}
		}
		return input;
	}
	
	public int[] replace_SlidingWindow_IterateFromLast(final int[] input) {
		int result[] = new int[input.length];
		result[input.length-1] = input[input.length-1];
		for(int i=input.length-1; i>0; i-- ) {
			if(input[i-1]<input[i]) {
				result[i-1] = result[i] + input[i-1]; 
			} else {
				result[i-1] = input[i-1];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		UpdateArray_SlidingWindow u = new UpdateArray_SlidingWindow();
		System.out.println(Arrays.toString(u.replace_bruteForce(new int[] {1,2,3,4,5})));
		System.out.println(Arrays.toString(u.replace_bruteForce(new int[] {5,4,3,2,1})));
		System.out.println(Arrays.toString(u.replace_SlidingWindow(new int[] {1,2,3,4,5,4})));
		System.out.println(Arrays.toString(u.replace_SlidingWindow(new int[] {5,4,3,2,1})));
		System.out.println(Arrays.toString(u.replace_SlidingWindow_IterateFromLast(new int[] {1,2,3,4,5,4})));
		System.out.println(Arrays.toString(u.replace_SlidingWindow_IterateFromLast(new int[] {5,4,3,2,1})));

	}
	
}
