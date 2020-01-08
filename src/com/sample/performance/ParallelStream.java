package com.sample.performance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {
  public static void main(String[] args) {
    ParallelStream p = new ParallelStream();
    p.testParallelStream();
    p.testStream();
    p.testCopyStream();
  }

  public void testParallelStream() {
    System.out.println("Parallel Stream...");
    List<String> alpha2 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    alpha2.parallelStream().forEach(this::printStale);
  }

  public void testCopyStream() {
    System.out.println("Parallel Stream...");
    List<String> alpha2 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    List<String> destination = alpha2.parallelStream().collect(Collectors.toList());
    System.out.println(destination);
  }

  public void testStream() {
    System.out.println("Regular Stream...");

    List<String> alpha = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    alpha.stream().forEach(this::printStale);
  }

  private void printStale(String s) {
    System.out.println(s);
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }
  }
}
