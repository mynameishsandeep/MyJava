package com.sample.basics;

public class StringFormatSameValue {

  public static void main(String[] args) {
    String hello = "Hello";
    System.out.println(
        String.format(
            "ctx._source.taxes.addAll(params.%1$s);ctx._source.%1$s=ctx._source.%1$s.stream().distinct().collect(Collectors.toList())",
            hello));
  }
}
