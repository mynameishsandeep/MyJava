package com.home.parser;

import org.json.JSONObject;

public class JSONTest {
public static void main(String[] args) {
	JSONObject j = new JSONObject();
	j.put("1", "1");
	j.put("1", "2");
	j.put("2", "3");
	
	j.remove("2");
	System.out.println(j.toString());
}
}
