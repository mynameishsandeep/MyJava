package com.sample.tricky;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
 *
 * 1) Find Largest Number using priority queue
 * 2) Find Largest Number using Quick select
 * algorithm Image is Present on US Problems folder "Quick Select.jpg"
 *
 * 1) Partition meant arranging "one" data in set of data.
 * 2) Partition in quick select picks a pivot (either randomly or first/last element).
 * 3) This logic picks last element.
 * 4) Then it rearranges the list in a way that all elements greater than pivot are on left side of pivot and others on right.
 * 5) It then returns index of the element upto which is sorted.
 */
public class FindKthLargestNumberQuickSelect {
  /*
   * http://codingrecipies.blogspot.com/2015/07/algo-121-quick-select-algorithm.html
   *
   * <p>O(N) guaranteed running time + O(1) space... Worst Case O(N log k)
   *
   * <p>By default quick select finds kth Smallest element. Less than symbol is changed in partition
   * to change the function to kth Largest element
   */
  public int findKthLargest(int[] nums, int k) {
	  int left= 0;
	  int right = nums.length - 1;
    return findKthLargest(nums, left, right, nums.length - k);
  }

  private int findKthLargest(int[] nums, int tempLeft, int right, int k) {
    int pivot = nums[right]; 
    int left = tempLeft;
    for (int i = left; i < right; i++) {
      if (nums[i] <= pivot) swap(nums, left++, i); // Put numbers < pivot to pivot's left
    }
    swap(nums, left, right); // Finally, swap A[end] with A[left]

    if (left == k) return nums[left]; // Found kth smallest number
    else if (left < k) return findKthLargest(nums, left + 1, right, k); // Check right part
    else return findKthLargest(nums, tempLeft, left - 1, k); // Check left part
  }

  void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    int a[] = {3, 2, 1, 5, 6, 4};
    System.out.println(new FindKthLargestNumberQuickSelect().findKthLargest(a, 2));
  }
}
