package com.sample.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsContainsAny {

  public static void main(String[] args) {

	  List<String> list = new ArrayList<>();
    Set<String> l1 = new HashSet<>();
    l1.add("a");
    l1.add("b");
    l1.addAll(list);
    
    new HashSet<>(list);

    Set<String> l2 = new HashSet<>();
    l2.add("b");
    l2.add("c");

    System.out.println(l1.stream().anyMatch(l2::contains));
  }
}
