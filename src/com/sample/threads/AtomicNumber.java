package com.sample.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicNumber {
  public static void main(String[] args) {
    AtomicInteger i = new AtomicInteger();
    System.out.println(i.get());
  }
}
