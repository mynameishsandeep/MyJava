package com.sample.designpattern;

import java.util.concurrent.CompletableFuture;

/*
 * Without volatile too many instance will be created.
 */
public class SingletonWithoutVolatile {

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 100; i++) {
      final int arg = i;
      CompletableFuture<Integer> future =
          CompletableFuture.supplyAsync(() -> SingletonSample.getInstance(arg).getValue());
      future.thenAccept(System.out::println);
    }
    Thread.currentThread().sleep(2000);
  }
}

final class SingletonSample {
  private static SingletonSample instance;
  private int value;

  private SingletonSample(final int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static SingletonSample getInstance(final int i) {
    System.out.println("Inside " + i);
    if (instance == null) {
      synchronized (SingletonSample.class) {
        System.out.println("Inside Creation " + i);
        try {
          Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
          System.out.println("Exception Occurred " + e);
        }
        instance = new SingletonSample(i);
      }
    }
    return instance;
  }
}
