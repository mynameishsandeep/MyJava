package com.home.parser;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {
	public static void main(String[] args) {
		JSONObject j = new JSONObject("{\"Reason\":\"Queue Interrupted\"}");
		System.out.println(j);

		j.put("a", j.opt("a") + "_append");
		System.out.println(j.get("a"));

		j.put("c", "[\"a1\",\"a2\"]");
		// Querying for key which is not present
		System.out.println(j.opt("c"));

		JSONArray array = new JSONArray();
		array.put("a1");
		array.put("a2");
		j.put("array", array);

		JSONArray sizes = j.optJSONArray("array");
		if(null !=sizes) {
		for (int i = 0; i <  sizes.length(); i++) {
			System.out.println("size " + sizes.get(i));
		}
		}

		System.out.println(j.toString());

		// Invalid JSON string will throw error when new JSONObject is called.
//		s = "{\"a\":\"b}";
//		j = new JSONObject(s);
//		System.out.println(j);
		
		int intVal  = j.optInt("someKey");
		System.out.println(intVal);
		
		JSONObject pr = new JSONObject();
		
		JSONArray colorValue = new JSONArray();
		colorValue.put("Red");
		colorValue.put("Green");
		
		JSONArray sizeValue = new JSONArray();
		sizeValue.put(7);
		sizeValue.put(8);

		JSONObject child = new JSONObject();
		child.put("color", colorValue);
		child.put("size", sizeValue);
		pr.put("variants", child);

		System.out.println(pr);
		
		System.out.println(child.getJSONObject("color"));

	}
}
