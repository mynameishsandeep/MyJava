package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutations-ii/
 *
 *==========In interview, explains this exactly===========
 *  1 2 2
 *
 *  1
 *  21 12
 *  221(first), (221)middle breaks , (212)already breaked
 *  212(second), 122(Third), (122)last breaks.
 *========================================================
 *  1 2 1
 *
 *  1
 *  21 12
 *  121(first), 211(second), 211(breaks)
 *  112(third), (112)middle breaks, (121)already breaked 
 *
 *===============================
 *  if (k > 0 && nums[i] == oldCombo.get(k - 1)) break;
 *	
 *  k > 0--> avoids NullPointerException 
 * ============
 *  This problem is simpler than subsetsII.
 *  In subsetsII, we need to maintain lastcount, if current and previous duplicate,
 *  do operataion from lastCount to n.
 *
 *
 *
 */
public class PermutationsII {
  public List<List<Integer>> permuteUnique(int[] nums) {
    LinkedList<List<Integer>> queue = new LinkedList<>();
    queue.offer(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        List<Integer> oldCombo = queue.poll();
        for (int k = 0; k <= oldCombo.size(); k++) {
          if (k > 0 && nums[i] == oldCombo.get(k - 1)) break;
          List<Integer> combo = new LinkedList<>(oldCombo);
          combo.add(k, nums[i]);
          queue.offer(combo);
        }
      }
    }
    return queue;
  }
}
