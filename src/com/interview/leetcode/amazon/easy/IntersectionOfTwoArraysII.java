package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> nums1Set = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums1.length; ++i) {
      nums1Set.put(nums1[i], nums1Set.getOrDefault(nums1[i], 0) + 1);
    }
    // System.out.println(nums1Set);
    for (int i = 0; i < nums2.length; ++i) {
      int val = nums2[i];
      if (nums1Set.containsKey(val)) {
        int count = nums1Set.get(val);
        if (count > 0) {
          res.add(val);
          --count;
          nums1Set.put(val, count);
        }
      }
    }
    // System.out.println(res);
    int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); ++i) {
      result[i] = res.get(i);
    }
    return result;
  }
  
  public static void main(String[] args) {
	  IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
	  int[] nums1 = {4,9,5};
	  int[] nums2 = {9,4,9,8,4};
	  i.intersect(nums1, nums2);
}
}
