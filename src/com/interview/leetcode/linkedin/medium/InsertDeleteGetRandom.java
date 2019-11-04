package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
========================Question=============================
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the "same probability" of being returned.

 * =============Note:==================
 * 1) The key point hashMap supports insert and delete at O(1).
 * 2) But to get random element, I need to have data structure that supports index.
 * Option1: I can use arrayList. But when a element is deleted from hashMap, it needs to be deleted from arrayList too.
 * But if a  element in arrayList is anywhere other than end. Then shuffling needs to be done.
 * To avoid that, we move the element from last index
 * to element to be deleted index and delete last index. Then map also has to updated with the new index.
 * Option2: use 2 hashMap keyMap and valueMap.. But Option1 is best.
===========Removal Operation================
1) take an example after insert 10, 20 ,30 in order
2) valueMap:[10,0][20,1][30,2] value:[10,20,30]
3) lets say we want to remove(10),
4) valueMap of 10 will give 0.
5) So take lastElement from list and move it 0th index.
6) Remove last element from list.
7) Update valueMap 30 with 0. Remove 10 from valueMap.
  =====================
 */
public class InsertDeleteGetRandom {
  private Map<Integer, Integer> valueMap;
  private List<Integer> value;
  private Random rand = new Random();

  public InsertDeleteGetRandom() {
    valueMap = new HashMap<>();
    value = new ArrayList<>();
  }

  public boolean insert(int val) {
    if (valueMap.containsKey(val)) return false;
    valueMap.put(val, value.size());
    return value.add(val);
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!valueMap.containsKey(val)) {
      return false;
    }
    int index = valueMap.get(val);
    if (index == value.size() - 1) { // element found at last in last
      valueMap.remove(val);
      value.remove(value.size() - 1);
    } else {
      int lastIndexValue = value.get(value.size() - 1);
      value.set(index, lastIndexValue);
      valueMap.put(lastIndexValue, index);
      valueMap.remove(val);
      value.remove(value.size() - 1);
    }
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return value.get(rand.nextInt(value.size()));
  }

  public static void main(String[] args) {
    InsertDeleteGetRandom i = new InsertDeleteGetRandom();
    i.insert(1);
    i.remove(2);
    i.insert(2);
    i.getRandom();
    i.remove(1);
    i.insert(2);
    i.getRandom();
  }
}
