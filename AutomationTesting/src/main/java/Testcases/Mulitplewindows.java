package Testcases;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Mulitplewindows {
	
	//learning automation testing in selenium
	//progarmming laungauge is java
	WebDriver driver;
	public String readdata(String key) throws IOException {
		Properties Properties = new Properties();
	FileInputStream fileinputstream = new FileInputStream("D:\\workspace\\AutomationTesting\\Dropdown.properties");
	Properties.load(fileinputstream);
	String value= Properties.getProperty(key);
	return value;
	}
	@BeforeTest
	public void launch() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
	       driver = new ChromeDriver();
driver.manage().window().maximize();
Thread.sleep(2000);
driver.navigate().to(readdata("url6"));
	}
	
	@Test
	public void windows() throws InterruptedException, IOException {
		driver.navigate().to(readdata("url6"));
	String parentwindow=driver.getWindowHandle();
		String title=driver.getTitle();
	 
	    Reporter.log(title, true);
	    String currenturl=driver.getCurrentUrl();
	   
	    Reporter.log(currenturl, true);
	
	driver.findElement(By.xpath("//div[@class='mui-container']/ul/li[2]/a")).click();
	Thread.sleep(2000);
	Set<String> allwindows=driver.getWindowHandles();
	  ArrayList<String> alltabs= new ArrayList<String>(allwindows);
		for(int i=0;i<alltabs.size();i++)
			driver.switchTo().window(alltabs.get(i));
			System.out.println(driver.getTitle());
	String title1=driver.getTitle();
   Reporter.log(title1, true);
    String currenturl1=driver.getCurrentUrl();
    Reporter.log(currenturl1, true);
    Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='mui-container']/ul/li[3]/a")).click();
	Thread.sleep(2000);
    String title11=driver.getTitle();
   System.out.println(title11);
   Reporter.log(title11, true);
    String currenturl11=driver.getCurrentUrl();
   System.out.println(currenturl11);
    Reporter.log(currenturl11, true);
	driver.findElement(By.xpath("//div[@class='mui-container']/ul/li[4]/a")).click();
	Thread.sleep(2000);
	String title111=driver.getTitle();
    System.out.println(title111);
  Reporter.log(title111, true);
   String currenturl111=driver.getCurrentUrl();
   System.out.println(currenturl111);    Reporter.log(currenturl111, true);
		Set<String> allwindows=driver.getWindowHandles();
		
	    ArrayList<String> alltabs= new ArrayList<String>(allwindows);
	    		for(int i=0;i<alltabs.size();i++)
	    			driver.switchTo().window(alltabs.get(i));	   
	    		System.out.println(driver.getTitle());	
	    		

}}
