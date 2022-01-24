package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Daydropscreen extends Reusescreen{
	WebDriver driver;
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver","D:\\automationproject\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
	       driver = new ChromeDriver();
        driver.manage().window().maximize();

	}
	
	public void navigateto(String url) {
		driver.navigate().to(url);
		
	}
	public String gettitle() {
		return driver.getTitle();
		
			}
	public String geturl() {
		return driver.getCurrentUrl();
	}
	@Test
	public void sample() throws InterruptedException, IOException {
		
			driver.navigate().to("https://www.facebook.com");
		
		  driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
	      
	      Thread.sleep(3000);
	      
	      WebElement daydropdown =driver.findElement(By.id("day"));
	      Select obj = new Select(daydropdown);
	      obj.selectByVisibleText(("12"));
	      takescreenshot (driver,"dayprinted");
	      
	   
	      
	}

	
		
	}
	

