package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.utils.TestUtil;

public class GetAPITest extends TestBase{
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
	
	@Test(priority=1)
	public void getTest() throws ClientProtocolException, IOException{
		restclient=new RestClient();
		closeableHttpResponse =restclient.get(url);
		

		//Status Code
		int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code ----->"+statuscode);
		
		Assert.assertEquals(statuscode, RESP_STATUS_CODE_200,"Status code is not 200!!");
		
		//Json String
		String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject jsonObject=new JSONObject(responseString);
		System.out.println("Response json from API ---->"+jsonObject);
		
		String perPageValue=TestUtil.getValueByJsonPath(jsonObject,"/per_page");
		System.out.println("perPageValue--->"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);
		
		//
		String totalValue=TestUtil.getValueByJsonPath(jsonObject,"/total");
		System.out.println("perPageValue--->"+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//JSONArray
		String last_name=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/last_name");
		String id=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/id");
		String avatar=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/avatar");
		String first_name=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/first_name");
		System.out.println("Last_name is---->"+last_name);
		System.out.println("id is---->"+id);
		System.out.println("avatar is---->"+avatar);
		System.out.println("first_name is---->"+first_name);
		
		//All Headers
		Header[] headerarrray=closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allHeaders=new HashMap<String,String >();
		for(Header header:headerarrray){
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array ----->"+allHeaders);
	}
	
	
	@Test(priority=2)
	public void getApiTestwithHeaders() throws ClientProtocolException, IOException{
		restclient=new RestClient();
		HashMap<String,String> headerMap=new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("username", "test@1234");
		
		closeableHttpResponse =restclient.get(url,headerMap);
		

		//Status Code
		int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code ----->"+statuscode);
		
		Assert.assertEquals(statuscode, RESP_STATUS_CODE_200,"Status code is not 200!!");
		
		//Json String
		String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject jsonObject=new JSONObject(responseString);
		System.out.println("Response json from API ---->"+jsonObject);
		
		String perPageValue=TestUtil.getValueByJsonPath(jsonObject,"/per_page");
		System.out.println("perPageValue--->"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);
		
		//
		String totalValue=TestUtil.getValueByJsonPath(jsonObject,"/total");
		System.out.println("perPageValue--->"+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//JSONArray
		String last_name=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/last_name");
		String id=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/id");
		String avatar=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/avatar");
		String first_name=TestUtil.getValueByJsonPath(jsonObject, "/data[0]/first_name");
		System.out.println("Last_name is---->"+last_name);
		System.out.println("id is---->"+id);
		System.out.println("avatar is---->"+avatar);
		System.out.println("first_name is---->"+first_name);
		
		//All Headers
		Header[] headerarrray=closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allHeaders=new HashMap<String,String >();
		for(Header header:headerarrray){
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array ----->"+allHeaders);
	}
	

}
