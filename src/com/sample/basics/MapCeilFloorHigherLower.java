package com.sample.basics;

import java.util.TreeMap;

public class MapCeilFloorHigherLower {
  public static void main(String[] args) {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    treeMap.put(1, 11);
    treeMap.put(10, 101);
    treeMap.put(5, 55);
    System.out.println(treeMap.ceilingKey(4));
    System.out.println(treeMap.higherKey(4));
    // The ceilingKey() method returns the least (smallest) key in this map that is greater than or
    // equal to the element passed
    System.out.println(treeMap.ceilingKey(5));
    System.out.println(treeMap.ceilingEntry(5).getValue());
    // The higherKey() method returns the least (smallest) key in this map that is greater than
    // (not equal too) the element passed
    System.out.println(treeMap.higherKey(5));
  }
}
