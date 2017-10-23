package com.home.parser;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParserArray {
public static void main(String[] args) {
	JSONObject top = new JSONObject();
	JSONArray array = new JSONArray();
	
	JSONObject j = new JSONObject();
	j.put("id", "value");
	j.put("id1", "value1");
	array.put(j);
	
	top.put("results", array);
	System.out.println(top.toString());
	
	System.out.println(top.getJSONArray("results").getJSONObject(0).get("id"));
	
}
}
