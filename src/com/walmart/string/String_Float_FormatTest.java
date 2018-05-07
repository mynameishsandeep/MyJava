package com.walmart.string;

public class String_Float_FormatTest {
	public static void main(String[] args) {
		System.out.println(callRemoteService("10", "DummyProduct"));
		System.out.println(String.format("/api/v1/myAPI/product/%s_error","testFile"));
		ozToLitres();
	}

	public static String callRemoteService(String productId, String name) {
		final String url = String.format("/api/v1/myAPI/product/%s/test/%s/value", productId, name);
		return url;
	}
	private static void ozToLitres() {
		final Double ozToLiterConstant = 0.0295735296875;
		final Integer oz =50;
		Double result = ozToLiterConstant * oz;
		System.out.println("Before Format " + result);
		System.out.println("After Format " +String.format("%.2f", result));
	}
}
