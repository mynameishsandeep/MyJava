package com.sample.datastructure;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		int search = 8;
		int start =0; 
		int end = a.length;
		int mid = end/2;
		while(start<=end) {
			if(search == a[mid]) {
				System.out.println("Element Found at location " + mid);
				break;
			} else if(search>a[mid]) {
				start = mid;
				mid = (mid+end)/2;
			} else {
				end = (start+end)/2;
				mid = end/2;
			}
		}
	}
}
