package com.sample.performance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinTest {
  public static void main(String[] args) {
    List<String> alpha = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
    String errorMessage = alpha.stream().parallel().collect(Collectors.joining("|"));
    System.out.println(errorMessage);
  }
}
