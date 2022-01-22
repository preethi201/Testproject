package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Titlepagesourse {
	
WebDriver driver;
	public String readdata(String key) throws IOException {
		Properties Properties = new Properties();
		FileInputStream fileinputstream = new FileInputStream("D:\\workspace\\AutomationTesting\\Dropdown.properties");
		Properties.load(fileinputstream);
		String value=Properties.getProperty(key);
		return value;
		
	}
	@BeforeTest
	public String function() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
	       driver = new ChromeDriver();
 driver.manage().window().maximize();
 Thread.sleep(2000);
	
		
		 driver.navigate().to(readdata("url2"));
		return null;
	
	}
	public String title() {
	return	driver.getTitle();
	}
	public String getcurrent() {
		return driver.getCurrentUrl();
	}
	public String pagesource() {
		return driver.getCurrentUrl();
	}
	@Test
	public void test() {
		System.out.println("title of the page"+driver.getTitle());
		Reporter.log(title());
		System.out.println("title of the page url"+driver.getCurrentUrl());
		Reporter.log(getcurrent());
		System.out.println("pagesource"+driver.getPageSource());
		Reporter.log(pagesource());
	
	}}