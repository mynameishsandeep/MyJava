package com.sample.basics;

import java.util.BitSet;
import java.util.concurrent.ThreadPoolExecutor;

public class BitSetSample {

	public static void main(String[] args) {
		  BitSet bitset1 = new BitSet(8);
	      BitSet bitset2 = new BitSet(8);

	      // assign values to bitset1
	      bitset1.set(0);
	      bitset1.set(1);
	      bitset1.set(2);

	      // assign values to bitset2
	      bitset2.set(2);
	      bitset2.set(4);
	      bitset2.set(6);

	      // print the sets
	      System.out.println("Bitset1:" + bitset1);
	      System.out.println("Bitset2:" + bitset2);

	      // set more values
	      bitset1.set(1, 10, false);
	      bitset2.set(5, 15, true);

	      // print the sets
	      System.out.println("Bitset1:" + bitset1);
	      System.out.println("Bitset2:" + bitset2);
	      ThreadPoolExecutor exed;
	      
	      String temp[] = {"a","b"};

	}

}
