package com.org.exercises;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RestClassUsingOKHttp3 {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();


    @Test(enabled = false)
    public void testAdd() {
        String str = "TestNG is a working fine";
        assertEquals("TestNG is working fine", str);
    }

    @Test(enabled = false)
    public void sendGetRequest() {
        //System.setProperty("webdriver.chrome.driver", "/Users/fpalattao/Documents/Dropbox/gitRepository/gitHubRepos/JavaPrograms/resourceFiles/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.ca");

    }

    @Test
    public void getRequest() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        Response response = client.newCall(request).execute();
        //System.out.println("Response code=" + response.code());

        JSONArray jsonArray = new JSONArray(response.body().string());
        //System.out.println("first element of the json array=" + jsonArray.getJSONObject(0));

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject myJsonObject = jsonArray.getJSONObject(0);

            System.out.println("id=" + myJsonObject.get("id"));
            System.out.println("title=" + myJsonObject.get("title"));
            System.out.println("body=" + myJsonObject.get("body"));
            System.out.println("***");
        }

    }

    @Test
    void post() throws Exception {
        RequestBody body = RequestBody.create(JSON, "[{\"userId\":1}]");
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
