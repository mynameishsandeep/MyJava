package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEmployeeUnderBossGroupByLevel {
	public static void main(String[] args) {
		// An employee cannot come under 2 manager.
		Map<Integer, List<Integer>> empMap = new HashMap<>();
		empMap.put(1, Arrays.asList(2,3,4));
		empMap.put(2, Arrays.asList(21,211,2111));
		empMap.put(3, Arrays.asList(31,311));
		empMap.put(4, Arrays.asList(41,411));
		empMap.put(21, Arrays.asList(2000));
		empMap.put(31, Arrays.asList(3000));
		empMap.put(3000, Arrays.asList(5000));
		System.out.println(getAllChildrenGroupedByLevel(empMap, 1));
		System.out.println(getAllChildrenGroupedByLevel(empMap, 2));
		System.out.println(getAllChildrenGroupedByLevel(empMap, 3));


	}
	
	public static List<List<Integer>> getAllChildrenGroupedByLevel(Map<Integer, List<Integer>> empMap, final Integer empId) {
		int currentIndex = 0;
		List<List<Integer>> employees = new ArrayList<>();
		employees.add(Arrays.asList(empId));
		do {
			List<Integer> employeeList = employees.get(currentIndex++);
			List<Integer> employeeChild = new ArrayList<>();
			for (Integer employee : employeeList) {
				List<Integer> empList = empMap.get(employee);
				if(null==empList) {
					continue;
				}
				for (int i = 0; i < empList.size(); i++) {
					employeeChild.add(empList.get(i));
				}
			}
			if (employeeChild.size() > 0) {
				employees.add(employeeChild);
			} else {
				//System.out.println("Leaf Reached, No more child");
			}
		} while (currentIndex < employees.size());
		return employees;
	}


}
