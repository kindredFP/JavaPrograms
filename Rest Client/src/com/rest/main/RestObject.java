package com.rest.main;

import java.util.HashMap;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RestObject {

	public HttpResponse getRequest(String url, String request_format) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet getReq = new HttpGet(url);

            getReq.addHeader("Authorization", "Basic cHJvdmlzaW9uX2ljcnM6cHJvdmlzaW9uX2ljcnM=");
            
            // default icrs get request headers
            getReq.addHeader("Content-Type", request_format);
            //getReq.addHeader("Version", version);
            getReq.addHeader("Accept", request_format);

            getReq.addHeader("name", "Test");

            HttpResponse response = client.execute(getReq);
            return response;

        } catch (Exception e) {
            e.printStackTrace();

        }
        // return nothing if we didn't receive a proper response
        return null;
    }
 
}
