package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkandradio {
	WebDriver driver;
	public String readdata(String key) throws IOException {
		Properties Properties = new Properties();
		FileInputStream fileinputstream = new FileInputStream("D:\\workspace\\AutomationTesting\\Dropdown.properties");
		Properties.load(fileinputstream);
		String value=Properties.getProperty(key);
		return value;}
@BeforeTest
	
	public void launching() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
	       driver = new ChromeDriver();
 driver.manage().window().maximize();

 
		
	}
	@Test
    public void checkboxradiobutton() throws IOException {
    	driver.navigate().to(readdata("url7"));
		driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12'])[2]/div[2]/label")).click();
		
	Boolean data=	driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12'])[6]/div[2]")).isDisplayed();
	System.out.println(data);
	String title = driver.getTitle();
	System.out.println(title);
	Reporter.log(title, true);
	String url= driver.getCurrentUrl();
	System.out.println(url);
	Reporter.log(url, true);
	Boolean data1=	driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12'])[6]/div[2]")).isEnabled();
	System.out.println(data1);
	String title1 = driver.getTitle();
	System.out.println(title1);
	Reporter.log(title1, true);
	String url1= driver.getCurrentUrl();
	System.out.println(url1);
	Reporter.log(url1, true);
	Boolean data2=	driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12'])[6]/div[2]")).isSelected();
		System.out.println(data2);
		String title11 = driver.getTitle();
		System.out.println(title11);
		Reporter.log(title11, true);
		String url11= driver.getCurrentUrl();
		System.out.println(url11);
		Reporter.log(url11, true);
	}
}
