package com.sample.basics;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Sample {
	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> empMap = new HashMap<Integer, Integer>();
		empMap.put(1, 2);
		empMap.put(2, 3);
		empMap.put(3, 4);
		empMap.put(4, 5);
		empMap.put(5, 6);
		empMap.put(6, 7);
		empMap.put(100, 4);
		System.out.println(findBoss(empMap, 100, 2));

	}

	private static boolean findBoss(Map<Integer, Integer> empMap, Integer emp, Integer mgr) {
		while (true) {
			Integer boss = empMap.get(emp);
			if (boss == mgr) {
				return true;
			} else if (null == boss) {
				return false;
			} else {
				emp = boss;
			}
		}
	}
}
