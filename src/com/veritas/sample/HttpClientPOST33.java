package com.veritas.sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

public class HttpClientPOST33 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		// Increase max total connection to 200
		cm.setMaxTotal(5);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(5);
		// Increase max connections for localhost:80 to 50
		HttpHost localhost = new HttpHost("localhost", 8080);
		cm.setMaxPerRoute(new HttpRoute(localhost), 50);

		ConnectionKeepAliveStrategy c = new ConnectionKeepAliveStrategy() {
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				return -1;
			}
		};

		CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).setKeepAliveStrategy(c).build();

		final HttpContext context = HttpClientContext.create();

		HttpPost httpPostRequest = new HttpPost("http://localhost:8080/YSBServlet/Sample");
		HttpPost httpPostRequest2 = new HttpPost("http://localhost:8080/YSBServlet/Sample2");
		HttpPost httpPostRequest3 = new HttpPost("http://localhost:8080/YSBServlet/Sample3");
		HttpPost httpPostRequest4 = new HttpPost("http://localhost:8080/YSBServlet/Sample4");
		CloseableHttpResponse response = null;
		while (true) {
			String s = scan.nextLine();
			if ("end".equals(s)) {
				break;
			} else if ("2".equals(s)) {
				response = client.execute(httpPostRequest2, context);
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(Arrays.toString(response.getAllHeaders()));
				httpPostRequest2.reset();// release the connection to pool
			} else if ("3".equals(s)) {
				response = client.execute(httpPostRequest3, context);
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(Arrays.toString(response.getAllHeaders()));
				httpPostRequest3.reset();// release the connection to pool
			} else if ("4".equals(s)) {
				response = client.execute(httpPostRequest4, context);
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(Arrays.toString(response.getAllHeaders()));
				httpPostRequest4.reset();// release the connection to pool
			} else {
				response = client.execute(httpPostRequest, context);
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(Arrays.toString(response.getAllHeaders()));
				httpPostRequest.reset();// release the connection to pool
			}
		}
		client.close();
	}
}
