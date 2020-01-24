package com.sample.tricky;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * It is a graph traversal problem. Connect all the nodes. One at the top will be boss
 */
public class FindEmployeeManager {
  public static void main(String[] args) {
    Map<Integer, Integer> empMap = new HashMap<>();
    empMap.put(1, 2);
    empMap.put(2, 3);
    empMap.put(3, 4);
    empMap.put(4, 5);
    empMap.put(5, 6);
    empMap.put(6, 7);
    empMap.put(100, 4);
    System.out.println(findBoss(empMap, 100, 7));
    System.out.println(findBoss(empMap, 100, 1));
    System.out.println(findCommonBoss(empMap, 2, 100));
    System.out.println(findCommonBoss(empMap, 2, 3));
  }

  public static void getHierarchy(
      Map<Integer, Integer> empMap, Integer emp, Set<Integer> empHierarchy) {
    empHierarchy.add(emp);
    while (true) {
      Integer boss = empMap.get(emp);
      if (null == boss) {
        break;
      } else {
        empHierarchy.add(boss);
        emp = boss;
      }
    }
  }

  public static Integer findCommonBoss(Map<Integer, Integer> empMap, Integer emp1, Integer emp2) {
    Set<Integer> emp1Hierarchy = new LinkedHashSet<>();
    getHierarchy(empMap, emp1, emp1Hierarchy);
    Set<Integer> emp2Hierarchy = new LinkedHashSet<>();
    getHierarchy(empMap, emp2, emp2Hierarchy);
    for (Integer boss : emp1Hierarchy) {
      if (emp2Hierarchy.contains(boss)) {
        return boss;
      }
    }
    return null;
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
