package com.sample.tricky;

import java.util.HashMap;
import java.util.Map;

public class FindEmployeeManager {
	public static void main(String[] args) {
		Map<Integer, Integer> empMap = new HashMap<Integer, Integer>();
		empMap.put(1, 2);
		empMap.put(2, 3);
		empMap.put(3, 4);
		empMap.put(4, 5);
		empMap.put(5, 6);
		empMap.put(6, 7);
		empMap.put(100, 4);
		System.out.println(findBoss(empMap, 100, 7));
		System.out.println(findBoss(empMap, 100, 1));
	}

	public static boolean findBoss(Map<Integer, Integer> empMap, Integer emp, Integer mgr) {
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
