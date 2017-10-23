package com.sample.datastructure;

public class FindLargestElementInCircularArray {

	public static void main(String[] args) {

		Integer[] i = {7,8,9,1,2,3,4};
		System.out.println(findLargest(i));
	}

	public static Integer findLargest (Integer[] A)
	{
		if (A.length == 0)
			return -1;
		Integer l = 0;
		Integer h = A.length - 1;
		
		while (A[l].compareTo(A[h]) > 0) {
			int m = l + (h - l) / 2;
			if (A[l].compareTo(A[m]) < 0)
				l = m + 1;
			else
				h = m;
		}
		return h;
	}
}
