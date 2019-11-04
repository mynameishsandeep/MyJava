package com.interview.leetcode.amazon.easy;

public class PrintInOrder2 {
  private volatile boolean oneDone = false;
  private volatile boolean twoDone = false;

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    oneDone = true;
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (!oneDone) {
      Thread.currentThread().sleep(1);
    }
    twoDone = true;
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (!twoDone) {
      Thread.currentThread().sleep(1);
    }

    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}
