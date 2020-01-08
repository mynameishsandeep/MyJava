package com.sample.basics;

import java.util.stream.IntStream;

public class Pring100RandomNumbers {
  public static void main(String[] args) {
    IntStream.range(1, 10).boxed().parallel().forEach(System.out::println);
  }
}
