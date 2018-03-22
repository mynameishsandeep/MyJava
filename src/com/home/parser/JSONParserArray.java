package com.home.parser;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParserArray {
	public static void main(String[] args) {
		new JSONParserArray().fun();
	}

	public void fun() {
		JSONObject top = new JSONObject();
		JSONArray array = new JSONArray();

		JSONObject j = new JSONObject();
		j.put("id", "value");
		j.put("id1", "value1");
		array.put(j);
		// array.remove(array.length());
		System.out.println("JSONArray" + array.toString());
		top.put("results", array);
		System.out.println(top.toString());

		updateJSONArray(array);
		System.out.println("Array after updation " + array.toString());
		System.out.println(top.getJSONArray("results").getJSONObject(0).get("id"));

	}

	public void updateJSONArray(JSONArray array) {
		array = new JSONArray();
	}

}
