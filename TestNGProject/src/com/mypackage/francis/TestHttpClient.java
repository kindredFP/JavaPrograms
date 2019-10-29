package com.mypackage.francis;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestHttpClient {

    public final static String MY_URL = "https://api.github.com";

    HttpClient myClient = HttpClientBuilder.create().build();

    @Test
    public void getCall(){
        HttpGet getCall = new HttpGet(MY_URL);
        try {
            HttpResponse myResponse = myClient.execute(getCall);
            Assert.assertEquals(200,myResponse.getStatusLine().getStatusCode(),"Expected status codes not matching");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
