package com.sample.basics;

import java.util.ArrayList;
import java.util.List;

public class ListCopy {
  public static void main(String[] args) {
    copyRightWay();
    copyWrongWay();
  }

  private static void copyRightWay() {
    List<List<Integer>> source = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    row.add(1);
    row.add(2);
    row.add(3);
    source.add(row);

    List<List<Integer>> destination = new ArrayList<>();
    destination.addAll(source);

    destination.get(0).set(0, 100);
    System.out.println(source);
    System.out.println(destination);
  }

  private static void copyWrongWay() {
    List<List<Integer>> source = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    row.add(1);
    row.add(2);
    row.add(3);
    source.add(row);

    List<List<Integer>> destination = new ArrayList<>(source);
    // Still below code is wrong
    //    List<List<Integer>> destination = new ArrayList<>();
    //    destination.addAll(source);

    destination.get(0).set(0, 100);
    System.out.println(source);
    System.out.println(destination);
  }
}
