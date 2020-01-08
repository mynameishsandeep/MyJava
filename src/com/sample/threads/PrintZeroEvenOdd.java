package com.sample.threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/*
 * https://leetcode.com/problems/print-zero-even-odd/

Input: n = 5
Output: "0102030405"

 1) zero will be printed n number of times.
 2) even and odd will printed n/2 times.
 3) initialize zeroSemphore with 1. So that it can acquire permit first.
 4) initialize oddSemphore and evenSemaphore with 0. So that it can never acquire permit first.
 5) When a zero is printed. Release(add permit to) odd or even semaphore based on current i.

==============Logical Thinking============
1) if even is fired first. Then it will wait at evenSemaphore.acquire. because it has 0 permits.
2) if odd is fired first. Then it will wait at oddSemaphore.acquire. because it has 0 permits.
3) if zero is fired first. It will print 0, then it will "add permit" for either odd or even semaphore
 */
class PrintZeroEvenOdd {
  private int n;
  private Semaphore zeroSemphore, oddSemaphore, evenSemaphore;

  public PrintZeroEvenOdd(int n) {
    this.n = n;
    zeroSemphore = new Semaphore(1);
    oddSemaphore = new Semaphore(0); // zeroSemaphore will add permit at runtime by calling release
    evenSemaphore = new Semaphore(0); // zeroSemaphore will add permit at runtime by calling release
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      zeroSemphore.acquire();
      printNumber.accept(0);
      if (i % 2 == 0) evenSemaphore.release();
      else oddSemaphore.release();
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      evenSemaphore.acquire();
      printNumber.accept(i);
      zeroSemphore.release();
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      oddSemaphore.acquire();
      printNumber.accept(i);
      zeroSemphore.release();
    }
  }
}
