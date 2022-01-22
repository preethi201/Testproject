package Testcases;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Dropdown {

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
    driver.navigate().to(readdata("url"));
    
	}
	
	public String gettitle() {
		return driver.getTitle();
		
			}
	public String geturl() {
		return driver.getCurrentUrl();
	}
	
	
	@Test
    public void sample() throws IOException {
    	
    
    WebElement colour1 =driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
    Select doc= new Select(colour1);
    doc.selectByVisibleText(readdata("colour"));
    System.out.println(gettitle());
    Reporter.log(gettitle());
    System.out.println(geturl());
    Reporter.log(geturl());
  }
	
	
			
		
		

		
	}
	
		
	
	
	

	



