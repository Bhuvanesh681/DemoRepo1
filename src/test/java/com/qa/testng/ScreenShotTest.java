package com.qa.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListenor.class)
public class ScreenShotTest extends TestBase{
	
	
	
	@BeforeTest
	public void setup(){
		init();
		
		
	}
	@AfterTest
	public void teardown(){
		driver.quit();
		
		
	}
	@Test
	public void takescreenshot(){
		Assert.assertEquals(false, true);
	}
}
