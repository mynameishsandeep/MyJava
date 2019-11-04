package com.sample.performance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamThreadIssue {
  private static List<Integer> source = new ArrayList<>();

  public static void main(String[] args) {
    ParallelStreamThreadIssue p = new ParallelStreamThreadIssue();
    for (int i = 1; i <= 5000; i++) {
      source.add(i);
    }
    try {
      p.parallelStreamWrongWay();
    } catch (Exception e) {
      System.out.println("Exception Occurred" + e);
    }
    p.parallelStreamStillWrongWay();
    p.parallelStreamRightWay();
  }

  /*
   * Parallel Stream Spawns 4 thread and list add method will be called by each of them.
   * list add method is not synchronized. So 2 issues can happen now
   * 1) some threads may overwrite values. So source and destination values are not equal
   * 2) when list is full, it will recreate new list by copying previous values.
   * While one threads does that, other threads can try writing to it.
   * So it will cause "java.lang.ArrayIndexOutOfBoundsException"
   */
  public void parallelStreamWrongWay() {
    System.out.println("==========Parallel Stream Totaly Wrong=============....");
    List<Integer> destination = new ArrayList<>();
    source.parallelStream().forEach(destination::add);
    System.out.println(source.size() + " " + destination.size());
  }

  /*
   * Parallel Stream Spawns 4 thread and list add method will be called by each of them.
   * list add method is synchronized now. This is not efficient way. Because now it is
   * like running single stream. i.e at any time only one thread can do the job. Other
   * threads will be blocked.
   */
  public void parallelStreamStillWrongWay() {
    System.out.println("==========Parallel Stream Still Wrong=============....");
    long startTime = System.currentTimeMillis();
    List<Integer> destination = Collections.synchronizedList(new ArrayList<>());
    source.parallelStream().forEach(destination::add);
    System.out.println("Total Time Took " + (System.currentTimeMillis() - startTime));
    System.out.println(source.size() + " " + destination.size());
  }

  /*
   * Parallel Stream Spawns 4 thread and list add method will be called by each of them.
   * All threads will write values in their own list and finally values are aggregated.
   */
  public void parallelStreamRightWay() {
    System.out.println("==========Parallel Stream Right Way of doing it=============....");
    List<Integer> destination = source.parallelStream().collect(Collectors.toList());
    long startTime = System.currentTimeMillis();
    System.out.println("Total Time Took " + (System.currentTimeMillis() - startTime));
    System.out.println(source.size() + " " + destination.size());
  }
}
