package com.sample.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/*
https://leetcode.com/problems/fizz-buzz-multithreaded/

==============Pre-Conditions===========
1) Class will be initialized with "n" FizzBuzz(15);
2) 4 threads will be created out of above instance.
3) 4 threads will call 4 methods.
4) Now result should be 1,2,3,4,5,6 till "n". Change FizzBuzz appropriately.
5) fizz/buzz/fizzbuzz/number method should call run/accept in their own method.

 */
public class FizzBuzzMultithreadedSemaphore {
  private int n;
  private int current;
  private Lock lock;
  private Condition nCond;

  public FizzBuzzMultithreadedSemaphore(int n) {
    this.n = n;
    this.current = 1;
    this.lock = new ReentrantLock();
    this.nCond = this.lock.newCondition();
  }

  private void signalAllThreads() {
    this.nCond.signalAll();
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    while (true) {
      this.lock.lock();
      while (this.current % 15 == 0 || this.current % 3 != 0) {
        if (this.current > n) {
          signalAllThreads();
          this.lock.unlock();
          return;
        }
        this.nCond.await();
      }
      if (this.current > n) {
        signalAllThreads();
        this.lock.unlock();
        return;
      }
      printFizz.run();
      this.current++;
      signalAllThreads();
      this.lock.unlock();
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (true) {
      this.lock.lock();
      while (this.current % 15 == 0 || this.current % 5 != 0) {
        if (this.current > n) {
          signalAllThreads();
          this.lock.unlock();
          return;
        }
        this.nCond.await();
      }
      if (this.current > n) {
        signalAllThreads();
        this.lock.unlock();
        return;
      }
      printBuzz.run();
      this.current++;
      signalAllThreads();
      this.lock.unlock();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (true) {
      this.lock.lock();
      while (this.current % 15 != 0) {
        if (this.current > n) {
          signalAllThreads();
          this.lock.unlock();
          return;
        }
        this.nCond.await();
      }
      if (this.current > n) {
        signalAllThreads();
        this.lock.unlock();
        return;
      }
      printFizzBuzz.run();
      this.current++;
      signalAllThreads();
      this.lock.unlock();
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (true) {
      this.lock.lock();
      while (this.current % 15 == 0 || this.current % 3 == 0 || this.current % 5 == 0) {
        if (this.current > n) {
          signalAllThreads();
          this.lock.unlock();
          return;
        }
        this.nCond.await();
      }
      if (this.current > n) {
        signalAllThreads();
        this.lock.unlock();
        return;
      }
      printNumber.accept(this.current);
      this.current++;
      signalAllThreads();
      this.lock.unlock();
    }
  }
}
