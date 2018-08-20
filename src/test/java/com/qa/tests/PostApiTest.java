package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.http.util.EntityUtils; 
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostApiTest extends TestBase {
	TestBase testbase;
	String api_url;
	String service_url;
	String url;
	RestClient restclient;
	CloseableHttpResponse closeableHttpResponse;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testbase=new TestBase();
		api_url=prop.getProperty("URL");
		service_url=prop.getProperty("serviceURL");
		url=api_url+service_url;
		
	}
	
	@Test
	public void postApiTest() throws JsonGenerationException, JsonMappingException, IOException{
		restclient=new RestClient();
		HashMap<String,String> headerMap=new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		//jackson API
		ObjectMapper mapper=new ObjectMapper();
		Users users=new Users("morpas","leader");
		//object to json
		mapper.writeValue(new File("C://Automation Framework//Maven Project//mavenproject//src//main//java//com//qa//data//users.json"), users);
		
		//object to json in string
		String usersJsonStr=mapper.writeValueAsString(users);
		System.out.println(usersJsonStr);
		closeableHttpResponse =restclient.post(url, usersJsonStr, headerMap);
		
		int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, RESP_STATUS_CODE_201);
		
		String responsestring=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson= new JSONObject(responsestring);
		System.out.println("Response from API:"+responseJson);
		
		Users userobj=mapper.readValue(responsestring, Users.class);
		System.out.println(userobj);
		System.out.println(users.getName().equals(userobj.getName()));
		System.out.println(users.getJob().equals(userobj.getJob()));
		
	}
}
