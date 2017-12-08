package com.veritas.sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class HttpClientPOST {

	public static void main(String[] args) throws IOException {
		
		ConnectionKeepAliveStrategy c = new ConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				return 999999999;
			}
		};

		CloseableHttpClient client = HttpClients.custom().setKeepAliveStrategy(c).build();
		HttpPost httpPost = new HttpPost("http://localhost:8080/YSBServlet/Sample");
		while (true) {
			
			httpPost.setHeader("Connection", "keep-alive");
			httpPost.setHeader("Keep-Alive", "-1");
			CloseableHttpResponse response = client.execute(httpPost);
			System.out.println(response.getStatusLine().getReasonPhrase());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			if ("end".equals(s)) {
				break;
			}
		}
		client.close();

	}
}
