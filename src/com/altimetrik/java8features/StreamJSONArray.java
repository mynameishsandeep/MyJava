package com.altimetrik.java8features;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;

public class StreamJSONArray {
  public static void main(String[] args) {
    JSONArray categoriesJSONArray = new JSONArray();
    String categoriesAttributes = ", ,";
    String[] categoriesArray = categoriesAttributes.split(",");
    Arrays.stream(categoriesArray)
        .parallel()
        .filter(StringUtils::isNotBlank)
        .forEach(
            e -> {
              synchronized (categoriesJSONArray) {
                categoriesJSONArray.put(e);
              }
            });

    System.out.println(categoriesJSONArray.length());
    System.out.println(categoriesJSONArray);
  }
}
