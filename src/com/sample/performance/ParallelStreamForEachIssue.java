package com.sample.performance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * =====Problem=========
 * 1) Use parallel stream with forEach to add data to list.
 * 2) Issue data will be overridden
 * 3) Ex: source has 100 data. between 50 to 80 only will be copied
 *=====================
 */
public class ParallelStreamForEachIssue {
  public static void main(String[] args) {
    ParallelStreamForEachIssue p = new ParallelStreamForEachIssue();
    // Right Approach
    p.testParallelStreamCollect();
    // Some data will be overridden
    p.testParallelStreamForEach();
    // Right Approach
    p.testParallelStreamCollectWithMap();
    // Some data will be overridden
    p.testParallelStreamForEachWithMap();
  }

  // Right Approach
  public void testParallelStreamCollect() {
    System.out.println("Parallel Stream Collect Right Approach...");
    List<Integer> source = IntStream.range(0, 100).boxed().collect(Collectors.toList());
    List<Integer> destination = source.parallelStream().collect(Collectors.toList());
    System.out.println("Size " + destination.size());
  }

  // Wrong Approach. Some data will be overridden
  public void testParallelStreamForEach() {
    System.out.println("Parallel Stream forEach Wrong Approach...");
    List<Integer> destination = new ArrayList<>();
    List<Integer> source = IntStream.range(0, 100).boxed().collect(Collectors.toList());
    source.parallelStream().forEach(e -> destination.add(e));
    // Every-time we run the program we will find different size for the destination
    System.out.println("Size " + destination.size());
  }

  // Wrong Approach. Some data will be overridden
  public void testParallelStreamForEachWithMap() {
    System.out.println("Parallel Stream forEach Wrong Approach...");
    Map<Integer, Integer> destination = new HashMap<>();
    List<Integer> source = IntStream.range(0, 100).boxed().collect(Collectors.toList());
    source.parallelStream().forEach(e -> destination.put(e, e));
    // Every-time we run the program we will find different size for the destination
    System.out.println("Size " + destination.size());
  }

  // Right Approach.
  public void testParallelStreamCollectWithMap() {
    System.out.println("Parallel Stream Collect Right Approach...");
    List<Integer> source = IntStream.range(0, 100).boxed().collect(Collectors.toList());
    Map<Integer, Integer> destination =
        source.parallelStream().collect(Collectors.toMap(e -> e, e -> e));
    System.out.println("Size " + destination.size());
  }
}
