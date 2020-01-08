package com.home.parser;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONNullDataType {

  public static void main(String[] args) {
    JSONObject customer = new JSONObject();

    JSONObject name = new JSONObject();
    name.put("firstName", "");
    String nullMiddleName = null;
    name.put("middName", nullMiddleName);
    name.put("middleName", JSONObject.NULL);

    name.put("lastName", "Prabhu");
    customer.put("name", name);

    List<String> list = List.of("A", "B");
    customer.put("list", list);

    JSONArray jList = new JSONArray();
    jList.put("C");
    jList.put("C");
    customer.put("jList", jList);

    for (Map.Entry<String, Object> requestMapEntry : customer.toMap().entrySet()) {

      if (requestMapEntry.getValue() instanceof List) {
        System.out.println("=====List======");
      } else if (requestMapEntry.getValue() instanceof JSONArray) {
        System.out.println("=====JSONArray======");
      } else if (requestMapEntry.getValue() instanceof Map) {
        System.out.println("=====Map======");
      } else if (requestMapEntry.getValue() instanceof JSONObject) {
        System.out.println("=====JSONObject======");
      } else {
        System.out.println("=====Simple DataType======");
      }

      System.out.println(requestMapEntry.getKey());
      System.out.println(requestMapEntry.getValue());
    }
  }
}
