package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/high-five/

Given a list of scores of different students, return the average score of each student's
top five scores in the order of each student's id.

Wrong Data Structure :
        Map<Integer, TreeSet> map = new HashMap<>();
Right Data Structure:
        Map<Integer, List<Integer>> map = new HashMap<>();
        Collections.sort(list, Collections.reverseOrder());
 */
public class HighFive {
  public int[][] highFive(int[][] items) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] item : items) {
      int id = item[0];
      int mark = item[1];
      if (map.containsKey(id)) {
        map.get(id).add(mark);
      } else {
        List<Integer> marks = new ArrayList<>();
        marks.add(mark);
        map.put(id, marks);
      }
    }
    int[][] result = new int[map.size()][2];
    int i = 0;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      result[i][0] = entry.getKey();
      List<Integer> marks = entry.getValue();
      Collections.sort(marks, Collections.reverseOrder());
      int total = 0;
      for (int j = 0; j < 5; j++) {
        total += marks.get(j);
      }
      result[i++][1] = total / 5;
    }
    return result;
  }
}
