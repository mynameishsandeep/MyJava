package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {
  /** Initialize your data structure here. */
  public class MyMap {
    private int key;
    private int value;

    MyMap(final int key, final int value) {
      this.key = key;
      this.value = value;
    }
  }

  List<MyMap>[] map = new ArrayList[1000];

  public DesignHashMap() {}

  /** value will always be non-negative. */
  public void put(int key, int value) {
    MyMap m = new MyMap(key, value);
    int hash = hash(key);
    List<MyMap> l = map[hash];
    if (l != null) {
      for (MyMap mm : l) {
        if (mm.key == key) {
          mm.value = value;
          return;
        }
      }
      l.add(m);
    } else {
      List<MyMap> newList = new ArrayList<>();
      newList.add(m);
      map[hash] = newList;
    }
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    List<MyMap> l = map[hash(key)];
    if (l != null) {
      for (MyMap mm : l) {
        if (mm.key == key) {
          return mm.value;
        }
      }
    }
    return -1;
  }

  private int hash(int key) {
    return key % map.length;
  }
  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int hash = hash(key);
    List<MyMap> l = map[hash];
    if (l != null) {
      for (int i = 0; i < l.size(); i++) {
        if (l.get(i).key == key) {
          l.remove(i);
          return;
        }
      }
    }
  }
}
