package com.sample.tricky;

import java.util.HashMap;
import java.util.Map;

public class FindEmployeeManager {
	public static void main(String[] args) {
		Map<Integer, Integer> empMap = new HashMap<Integer, Integer>();
		empMap.put(23, 46);
		empMap.put(46, 78);
		empMap.put(78, 101);
		empMap.put(13, 46);
		System.out.println(findIfConnected(empMap, 23, 461));
	}

	public static boolean findIfConnected(Map<Integer, Integer> empMap, Integer emp1, Integer emp2) {

		Integer temp = null;
		while (true) {
			if (empMap.get(emp1) == emp2) {// fail, fail,succeed
				return true;
			} else {
				temp=empMap.get(emp1);
				if( temp==null) {
					return false;
				} else {
					emp1 = temp;
				}

			}
		}

	}
}
