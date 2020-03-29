package com.mypackage.francis;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Test Class to create an HTTP client
 */
public class TestHttpClient {

    private final static String MY_URL = "https://api.github.com/";

    CloseableHttpClient myClient;
    CloseableHttpResponse myResponse;

    @DataProvider
    private Object[][] values() {
        return new Object[][]{{"rate_limit"}, {""}
        };
    }

    @BeforeMethod
    public void setup() {
        myClient = HttpClientBuilder.create().build();

    }

    @AfterMethod
    public void cleanUp() throws IOException {
        myClient.close();
        myResponse.close();
    }

    @Test(dataProvider = "values")
    public void getCall(String values) {
        HttpGet getCall = new HttpGet(MY_URL + values);
        try {
            myResponse = myClient.execute(getCall);
            System.out.println(values);
            Assert.assertEquals(200, myResponse.getStatusLine().getStatusCode(), "Expected status codes not matching");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
