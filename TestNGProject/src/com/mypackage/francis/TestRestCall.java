package com.mypackage.francis;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;

public class TestRestCall extends BaseClass {
	String urlGet = "http://jsonplaceholder.typicode.com/";
	String urlPost = "http://jsonplaceholder.typicode.com/posts";
	String urlBasic = "http://func-app-na-01.das.orion.altus.bblabs:8080/icrs/subscriber/FrancisEcoId";
	String urlDigest = "http://func-app-na-01.das.orion.altus.bblabs:8080/icrs-restricted/subscriber/FrancisEcoId";
	String urlHelm = "https://func-jetty-01.das.orion.altus.bblabs:8443/maa/subscriber/AfNRVmHmKJQ%2BWccUU7c1NAs%3D/entitlement?subIDRealm=EBB";
	
	@Test
	public void sendGETRequest() {
		int responseCode = 0;
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet(urlGet);
		HttpResponse response;

		try {
			response = httpClient.execute(httpget);
			responseCode = response.getStatusLine().getStatusCode();
			System.out.println("Response Code : " + responseCode);

		} catch (Exception e) {
		}

		Assert.assertEquals(responseCode, 200);
	}

	@Test
	public void sendPOSTRequest() {
		int responseCode = 0;
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(urlPost);

		HttpResponse response;

		request.setHeader("Content-type", "application/json");
		request.setHeader("Accept", "application/json");

		try {
			response = httpClient.execute(request);
			responseCode = response.getStatusLine().getStatusCode();
			System.out.println("Response Code : " + responseCode);

		} catch (Exception e) {

		}

		Assert.assertEquals(responseCode, 201);
	}

	@Test
	public void sendBasicAuthPOSTRequest() {
		int responseCode = 0;
		String payLoad = "{\"PIN\" : \"2DDDEB1A\"}";

		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
				"icrsuser", "password123");
		provider.setCredentials(AuthScope.ANY, credentials);

		// HttpClient httpClient = HttpClientBuilder.create().build();
		HttpClient httpClient = HttpClientBuilder.create()
				.setDefaultCredentialsProvider(provider).build();

		HttpPost request = new HttpPost(urlBasic);

		HttpResponse response;

		request.setHeader("Content-type", "application/json");
		request.setHeader("Accept", "application/json");
		request.setHeader("Version", "SREG/1.0");
		// request.setHeader("Authorization",
		// "Basic aWNyc3VzZXI6cGFzc3dvcmQxMjM=");

		try {
			request.setEntity(new StringEntity(payLoad));

		} catch (UnsupportedEncodingException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
		try {
			response = httpClient.execute(request);
			responseCode = response.getStatusLine().getStatusCode();
			System.out.println("Response Code : " + responseCode);

		} catch (Exception e) {
			System.out.println(e);
		}

		Assert.assertEquals(responseCode, 204);
	}

	@Test
	public void sendDigestAuthGetRequest() {
		int responseCode = 0;
		String payload = "";

		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
				"icrs-restricted-user", "password123");
		provider.setCredentials(AuthScope.ANY, credentials);

		// HttpClient httpClient = HttpClientBuilder.create().build();
		HttpClient httpClient = HttpClientBuilder.create()
				.setDefaultCredentialsProvider(provider).build();

		HttpGet request = new HttpGet(urlDigest);

		HttpResponse response;

		request.setHeader("Content-type", "application/json");
		request.setHeader("Accept", "application/json");
		request.setHeader("Version", "ICRS-Restricted/2.0");

		try {
			response = httpClient.execute(request);
			responseCode = response.getStatusLine().getStatusCode();
			System.out.println("Response Code : " + responseCode);
			payload = BaseClass.getHttpContent(response.getEntity());
			System.out.println("The Payload contains " + "\n\n\n" + payload
					+ "\n\n\n");
			
		} catch (Exception e) {
			System.out.println(e);
		}


		Assert.assertEquals(responseCode, 200);
	}
	

	
	@Test
	public void queryOracleDb() {
		Connection myConnection = BaseClass.getOracleConnection();
		String query = "Select pin_identifier from devices where pin_identifier = '270A3E07'";
		String deviceId = "";
		if (myConnection == null){
			System.out.println("Null Connections");			
		}
		else {

			deviceId = BaseClass.queryDB(query, myConnection);
		}
	
		Assert.assertEquals(deviceId, "270A3E07");
	
	}

}
