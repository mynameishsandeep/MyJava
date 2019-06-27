package com.home.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.OrderedJSONObject;
import org.apache.wink.json4j.compat.JSONException;

public class JSONRemoveNullAndEmptyRecursively2 {
	private static String DEFAULT_NULL_VALUE = "SYSTEM_NULL";
	private static String DEFAULT_EMPTY_VALUE = "SYSTEM_EMPTY";

	public static void main(String[] args)
			throws FileNotFoundException, org.apache.wink.json4j.JSONException, JSONException {
		File file = new File("/Users/chandrasekhar/projects/MyJava/resources/upsWithStatic.json");

		InputStream inputStream = new FileInputStream(file);
		String fileString = new BufferedReader(new InputStreamReader(inputStream)).lines()
				.collect(Collectors.joining("\n"));
		//System.out.println(fileString);

		JSONRemoveNullAndEmptyRecursively2 jj = new JSONRemoveNullAndEmptyRecursively2();
		jj.print(fileString);

		//JSONObject j = new JSONObject (fileString);
		//System.out.println(jj.fromJSON(j));

	}

	public void print(final String fileString) throws org.apache.wink.json4j.JSONException, JSONException {
		OrderedJSONObject o = new OrderedJSONObject(fileString);

		OrderedJSONObject updatedJSON = new OrderedJSONObject();
		Iterator it = o.getOrder();
		while (it.hasNext()) {
			Object obj = it.next();
			Object val = o.get(obj);
			if (val != null) {
				Object oo = getJavaObject(val);
				updatedJSON.put(obj.toString(), oo);
			} else {
				updatedJSON.put(obj.toString(), DEFAULT_NULL_VALUE);
			}
		}
		System.out.println(updatedJSON);
	}

	public static Object getJavaObject(final Object obj) throws JSONException, org.apache.wink.json4j.JSONException {
		if (obj == null) {
			return DEFAULT_NULL_VALUE;
		} else if (obj instanceof JSONArray) {
			JSONArray jarray = (JSONArray) obj;
			JSONArray response = new JSONArray();
			for (int i = 0; i < jarray.length(); i++) {
				response.add(getJavaObject(jarray.get(i)));
			}
			return response;
		} else if (obj instanceof OrderedJSONObject) {

			OrderedJSONObject o = (OrderedJSONObject) obj;
			Iterator order = o.getOrder();
			OrderedJSONObject response = (OrderedJSONObject) obj;
			while (order.hasNext()) {
				String key = (String) order.next();
				Object value = getJavaObject(o.get(key));
				response.put(key, value);
			}
			return response;

		} else if (obj instanceof String) {
			return "".equals(obj.toString()) ? DEFAULT_EMPTY_VALUE : obj.toString();
		} else {
			return obj;
		}
	}
}
