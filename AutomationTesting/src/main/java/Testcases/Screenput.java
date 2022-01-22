package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenput {
	
	WebDriver driver;
	public String readdata(String key) throws IOException {
		Properties Properties = new Properties();
		FileInputStream fileinputstream = new FileInputStream("D:\\workspace\\AutomationTesting\\Dropdown.properties");
		Properties.load(fileinputstream);
		String value=Properties.getProperty(key);
		return value;
		}
	
	
@BeforeTest
	
	public void launching() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
	       driver = new ChromeDriver();
      driver.manage().window().maximize();


}
public String gettitle() {
	return driver.getTitle();
	
		}
public String geturl() {
	return driver.getCurrentUrl();
}

    @Test
public void screen() throws IOException, InterruptedException {
	driver.navigate().to(readdata("url9"));
	Homepage s = new Homepage(driver);
	Reuseablescreenshot11 a = new Reuseablescreenshot11(driver);
	 a.takescreenshot(driver, "printdatabefoe");
	s.creatnewaccount();
	Thread.sleep(2000);
	s.enterfirstname(readdata("firstname"));
	
	s.enteringlastname(readdata("lastname"));
    s.enteringmail(readdata("mobileoremail"));
	s.password(readdata("password"));
Reuseablescreenshot11 a1 = new Reuseablescreenshot11(driver);
 a1.takescreenshot(driver, "printdataafter");
	String title=driver.getTitle();
	 System.out.println(title);
	 Reporter.log(title, true);
	 String currenturl=driver.getCurrentUrl();
	 System.out.println(currenturl);
	 Reporter.log(currenturl, true);	
	
}
	


}

