package com.sample.tricky;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargestNumber {
	public static void main(String[] args) {
		// 2,3,5,7,8,9,10
		int a[] = { 7, 3, 9, 2, 5, 10, 8 };

		System.out.println(findKthLargest(a, 3));
		System.out.println(findKthLargetQuickSelect(a, 3));
	}

	public static Integer findKthLargest(int a[], Integer k) {
		Queue<Integer> pQ = new PriorityQueue<Integer>();
		for (Integer data : a) {
			pQ.offer(data);
			if (pQ.size() > k) {
				pQ.poll();
			}
		}
		return pQ.poll();
	}

	public static int findKthLargetQuickSelect(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}

		return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
	}

	public static int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];

		int left = start;
		int right = end;

		while (true) {

			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}

}
