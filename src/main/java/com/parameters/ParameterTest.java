package com.parameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;
	@Test
	@Parameters({"url","email"})
	public void yahaoologintest(String url,String email){
		System.setProperty("webdriver.chrome.driver",".//mavenproject//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println(url);
		System.out.println(email);
		System.out.println("****$$$");
	}
}
