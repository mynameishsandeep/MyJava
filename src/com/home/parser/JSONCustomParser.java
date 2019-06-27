package com.home.parser;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONCustomParser {
	public static void main(String[] args) {
		JSONObject j = new JSONObject();
	
		JSONArray jA = new JSONArray();
		jA.put("some");
		j.put("k", jA);
		JSONArray jA1 = new JSONArray();
		jA1.put("some1");
		j.put("k", jA1);
		//j.put("k", "2");
		System.out.println(j);
		
		String v = j.optString("k", null);
		System.out.println("Result K" + v);
		if(StringUtils.isEmpty(v)) {
			System.out.println("Blank");
		}
		
		String value = j.optString("a", null);
		System.out.println("Result A" + value);
		if(StringUtils.isEmpty(value)) {
			System.out.println("Blank");
		}
		int val =-1;
		val = j.optInt("NotPresent" );
		System.out.println("optInt default is "+val);
		

	}
}
