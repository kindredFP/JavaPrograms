package com.rest.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class MyMainProgram {

	public static void main(String[] args) throws IllegalStateException, IOException {
		RestObject myRestObject = new RestObject();


		HttpResponse myResponse = myRestObject.getRequest("http://public.opencpu.org/ocpu/library/", "application/json");
		Header[] myHeader = myResponse.getAllHeaders();
		
		//Print all the headers
		for (int i = 0; i < myHeader.length;i++){
			System.out.println(myHeader[i]);				
		}	
		
		System.out.println(myResponse.getProtocolVersion().toString());
		System.out.println(myResponse.getStatusLine().getStatusCode());
		System.out.println(myResponse.getStatusLine().getReasonPhrase());
		System.out.println(myResponse.getStatusLine().toString());
		
        String responseContent = "";

        // attempt to read content, but there might not be any...
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(myResponse.getEntity().getContent()));

            String currentLine = br.readLine();
            while (currentLine != null) {
                responseContent += currentLine;
                currentLine = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(new java.util.Scanner(myResponse.getEntity()).useDelimiter("\\A").next());
        System.out.println(responseContent);
		}
			
	

}
