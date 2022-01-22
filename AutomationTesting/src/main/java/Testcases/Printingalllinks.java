package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Printingalllinks {
	
	 WebDriver driver;
		public String readdata(String key) throws IOException {
			Properties Properties = new Properties();
			FileInputStream fileinputstream = new FileInputStream("D:\\workspace\\AutomationTesting\\Dropdown.properties");
			Properties.load(fileinputstream);
			String value=Properties.getProperty(key);
			return value;
			
		}
		@BeforeTest
	public void launchingbrowser() throws InterruptedException, IOException {
			System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
		       driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 Thread.sleep(2000);
	 driver.navigate().to(readdata("url10"));
		}
		public String title() {
			return driver.getTitle();
		}
		public String currenturl() {
			return driver.getCurrentUrl();
		}
		
		
	@Test
    public void alllinks() throws IOException {
	List<WebElement> alllinks=driver.findElements(By.tagName("a"));
	System.out.println(alllinks.size());
    for(int i=0;i<alllinks.size();i++) {
    	
		Reporter.log(alllinks.get(i).getText(), true);
       
    }
    Reporter.log(title());
	
	Reporter.log(currenturl());
		
		
	
	}
		
	
	@AfterTest
     public void closebrowser() {
		 driver.quit();
	
}

	}
