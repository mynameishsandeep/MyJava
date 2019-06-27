package com.sample.tricky;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lru-cache/
 *
 * Note:
 * 1) Flag accessOrder rearranges the data ones get() is called.
 * So all the time recently visited or inserted will be at head or top.
 *
 * 2) If size goes more than specified then Bottom or tail is removed.
 */
public class LRUCache1 {
  LinkedHashMap<Integer, Integer> cache;

  public LRUCache1(int capacity) {
    cache =
        new LinkedHashMap<Integer, Integer>(capacity, .75F, true) {
          protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
          }
        };
  }

  public int get(int key) {
    if (cache.containsKey(key)) return cache.get(key);
    return -1;
  }

  public void put(int key, int value) {
    cache.put(key, value);
  }
}
