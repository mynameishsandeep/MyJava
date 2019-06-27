package com.walmart.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 *
 * https://leetcode.com/problems/permutations/
 *https://www.educative.io/collection/page/5668639101419520/5671464854355968/5720758194012160
 *
 * 1) How the K loop creates permutations.
 * 2) K runs oldCombo + 1 time to create permutation.
 * Note: This is achieved by running from 0 to oldComboTimes...for (int k = 0; k <= oldCombo.size(); k++) {
 * 3) Each Time K loop inserts current value at old combo of various indexes.
 * 4) During the first time for the empty. oldCombo size is 0. so loop run 1 time and insert 0th element
 *

OuterLoop
curr []
[1]
OuterLoop
curr [1]
[2, 1]
[1, 2]
OuterLoop
curr [2, 1]
[3, 2, 1]
[2, 3, 1]
[2, 1, 3]
curr [1, 2]
[3, 1, 2]
[1, 3, 2]
[1, 2, 3]

 * */
public class PermutationOfArray_Queue {

  /*
   * Time Complexity : N*N! ---> i loop N times, j&k loop combinely N!
   * Space complexity N!
   */
  public List<List<Integer>> permute(int[] nums) {
    LinkedList<List<Integer>> queue = new LinkedList<>();
    queue.offer(new ArrayList<>()); // Insert empty at initial
    for (int i = 0; i < nums.length; i++) {
      System.out.println("OuterLoop");
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        List<Integer> curr = queue.poll();
        System.out.println("curr " + curr);
        for (int k = 0; k <= curr.size(); k++) {
          List<Integer> combo = new ArrayList<>(curr);
          combo.add(k, nums[i]);
          System.out.println(combo);
          queue.offer(combo);
        }
      }
    }
    return queue;
  }
}
