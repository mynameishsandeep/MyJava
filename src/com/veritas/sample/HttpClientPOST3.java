package com.veritas.sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.http.HttpEntity;
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
import org.apache.http.util.EntityUtils;

public class HttpClientPOST3 {

	public static void main(String[] args) throws IOException {

		
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

		CloseableHttpClient client = HttpClients.custom()
		        .setConnectionManager(cm).setKeepAliveStrategy(c)
		        .build();
		
	    final HttpContext context = HttpClientContext.create();
	    
		
		HttpPost httpPostRequest = new HttpPost("http://localhost:8080/YSBServlet/Sample");

		while (true) {
//			httpPostRequest.setHeader("Connection", "keep-alive");
//			httpPostRequest.setHeader("Keep-Alive", "999999999999999");
			CloseableHttpResponse response = client.execute(httpPostRequest, context);
//		    HttpEntity entity = response.getEntity();
//		    EntityUtils.consume(entity);
			System.out.println(response.getStatusLine().getReasonPhrase());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			Scanner scan = new Scanner(System.in);
			httpPostRequest.reset();// release the connection to pool
			//response.close();
			String s = scan.nextLine();
			if ("end".equals(s)) {
				break;
			}
		}
		client.close();
	}
}
