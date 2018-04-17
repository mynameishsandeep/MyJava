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
		
		JSONArray jA = new JSONArray();
		jA.put("prod1");
		jA.put("prod2");
		jA.put("prod3");
		
		for(int i=0; i<jA.length(); ) {
			if(i==0) {
				System.out.println(0);
			}
			if(i==1) {
				jA.remove(i);
				continue;
			}
			System.out.println("jA.length()" + jA.length());
			i++;
			if(i==2) {
				System.out.println(2);
			}
		}
		JSONArray jB = new JSONArray();
		jB.put("prod3");
		jB.put("prod4");
		
		
		JSONObject addedDeleted = new JSONObject();
		addedDeleted.put("added", jA);
		addedDeleted.put("deleted", jB);
		
		JSONObject root = new JSONObject();
		root.put("variants", addedDeleted);
		System.out.println(root);
		
		JSONArray nullTest = new JSONArray();
		String s = null;
		nullTest.put(s);
		s = nullTest.getString(0);
		
	}

	public void updateJSONArray(JSONArray array) {
		array = new JSONArray();
	}

}
