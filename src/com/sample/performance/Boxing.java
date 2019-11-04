package com.sample.performance;

/*
 * https://dzone.com/articles/java-performance-notes-autoboxing-unboxing
 */
public class Boxing {

  public static void main(String[] args) {

    Boxing b = new Boxing();
    b.longRunning();
    b.shortRunning();
  }

  private void longRunning() {
    long t = System.currentTimeMillis();
    Long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
    System.out.println("total:" + sum);
    System.out.println("processing time: " + (System.currentTimeMillis() - t) + " ms");
  }

  private void shortRunning() {
    long t = System.currentTimeMillis();
    // Long sum = 0L;
    long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
    System.out.println("total:" + sum);
    System.out.println("processing time: " + (System.currentTimeMillis() - t) + " ms");
  }
}
