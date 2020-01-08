package com.home.parser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTest {
  public static void main(String[] args) {
    JSONObject j = new JSONObject();
    j.put("1", "1");
    j.put("1", "2");
    j.put("2", "3");

    j.remove("2");
    j.put("test", new ArrayList<>());
    j.put("test1", new HashMap<>());
    j.put("test3", new HashSet<>());
    Calendar calendar = new GregorianCalendar(2013, 0, 31);
    j.put("calender", calendar);
    for (String key : j.keySet()) {
      Object value = j.get(key);
      if (value instanceof Set) {
        System.out.println("Found Set");
      }

      if (value instanceof HashSet) {
        System.out.println("Found Set");
      }

      if (value instanceof Map) {
        System.out.println("Found Map");
      }

      if (value instanceof HashMap) {
        System.out.println("Found Map");
      }
      if (value instanceof JSONArray) {
        System.out.println("Found JSONArray");
      }
      if (value instanceof JSONObject) {
        System.out.println("Found JSONObject");
      }
      if(value instanceof Calendar) {
    	  System.out.println("Calendar" ); 
      }
    }
    System.out.println(j.toString());
  }
}
