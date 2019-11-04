package com.altimetrik.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamSumEvenAndOddNumber {

  public static void main(String[] args) {
    List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    Map<Boolean, Integer> result =
        inputList
            .stream()
            .collect(
                Collectors.partitioningBy(
                    x -> x % 2 == 0, Collectors.summingInt(Integer::intValue)));
    System.out.println(result);
    
    inputList
    .stream()
    .collect(
        Collectors.partitioningBy(
            x -> x % 2 == 0, Collectors.summingInt(Integer::intValue)));
  }
}
