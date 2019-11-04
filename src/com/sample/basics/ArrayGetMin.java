package com.sample.basics;

import java.util.Arrays;

public class ArrayGetMin {
	public static void main(String[] args) {
    int[] a = {1,2,3,4,10,5,6,11,8};
    System.out.println(Arrays.stream(a).min());
  }
}
