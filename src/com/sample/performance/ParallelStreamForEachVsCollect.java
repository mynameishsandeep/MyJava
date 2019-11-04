package com.sample.performance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamForEachVsCollect {
  public static void main(String[] args) {
    ParallelStreamForEachVsCollect p = new ParallelStreamForEachVsCollect();
    // Order will not change
    p.testParallelStreamCollect();
    // Order will change
    p.testParallelStreamForEach();
  }

  public void testParallelStreamCollect() {
    System.out.println("Parallel Stream...");
    List<String> source = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    List<String> destination = source.parallelStream().collect(Collectors.toList());
    System.out.println(destination);
  }

  public void testParallelStreamForEach() {
    System.out.println("Regular Stream...");

    List<String> alpha = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    alpha.parallelStream().forEach(System.out::println);
  }
}
