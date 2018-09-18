package selenium_test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable1 {
WebDriver driver=null;

@Test
public void setUp(){
	//System.out.println(System.getProperty("user.dir")+"//drivers/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers/chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> list=driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//th"));
	for(WebElement ls:list){
		System.out.println(ls.getText());
	}
	List<WebElement> list1=driver.findElements(By.xpath("//table[@id='customers']//tbody//tr[2]//td"));
	for(WebElement ls:list1){
		System.out.println(ls.getText());
	}
}
}
