package com.home.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListOfStringToJSONArray {
public static void main(String[] args) {
	List<String> input = new ArrayList<>();
	input.add("1");
	input.add("2");
	JSONArray jsonArray = new JSONArray();
	
	jsonArray.put("1");
	jsonArray.put("2");
	String ss = null;
	jsonArray.put( ss);

	JSONObject json = new JSONObject();
	System.out.println(jsonArray.toString());
	json.put("parent", jsonArray);
	String s = null;
	json.put("dummy", s);
	String s1 = "s1";
	json.put("dummy1", s1);
	System.out.println(json.toString());
}
}
