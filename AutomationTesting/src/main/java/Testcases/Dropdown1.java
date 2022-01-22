package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown1 {
	

	 WebDriver driver;
	public String readdata(String key) throws IOException {
		Properties Properties = new Properties();
		FileInputStream fileinputstream = new FileInputStream("D:\\workspace\\AutomationTesting\\Dropdown.properties");
		Properties.load(fileinputstream);
		String value=Properties.getProperty(key);
		return value;
		
	}
	@BeforeTest
	public void lanchbrowser() throws InterruptedException, IOException {
	
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
	       driver = new ChromeDriver();
   driver.manage().window().maximize();
   Thread.sleep(2000);
  
   
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
	public void dropdown() throws InterruptedException, IOException {
		driver.navigate().to(readdata("url"));
	
	  driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
      
      Thread.sleep(3000);
      
      WebElement daydropdown =driver.findElement(By.id("day"));
      Select obj = new Select(daydropdown);
      obj.selectByVisibleText(readdata("day"));
      
   
      
      
      WebElement monthdropdown =driver.findElement(By.id("month"));
      Select month = new Select(monthdropdown);
      month.selectByVisibleText(readdata("month"));
      
      
      
      WebElement yeardropdown =driver.findElement(By.id("year"));
      Select year = new Select(yeardropdown);
      year.selectByVisibleText(readdata("year"));
	}

}
