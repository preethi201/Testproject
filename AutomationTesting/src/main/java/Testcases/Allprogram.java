package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Allprogram {
	
	public String readdata(String key) throws IOException {
		Properties Properties = new Properties();
		FileInputStream fileinputstream = new FileInputStream("D:\\workspace\\AutomationTesting\\Dropdown.properties");
		Properties.load(fileinputstream);
		String value=Properties.getProperty(key);
		return value;
		
	}
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	     public  void display(String browser) throws InterruptedException {
			if(browser.equalsIgnoreCase("chrome")) {
	    	 System.setProperty("webdriver.chrome.driver", "D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	 driver.manage().window().maximize();
	    	   }
			else if(browser.equalsIgnoreCase("Firefox")) {
				
		    	System.setProperty("webdriver.gecko.driver", "D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\geckodriver.exe");
		    	 driver = new FirefoxDriver();
		    	 driver.manage().window().maximize();
		    	   }
			else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "D:\\workspace\\AutomationTesting\\src\\main\\java\\Drivers\\IEDriverServer.exe");
		   driver = new InternetExplorerDriver();
		    driver.manage().window().maximize();
		    	   }
	}
			public void navigateto(String url) {
				driver.navigate().to(url);
				
			}
			
	
			
			@Test(priority=0)
		    public void dropdown() throws IOException, InterruptedException {
		    	navigateto(readdata("url"));
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
		    String title=driver.getTitle();
		    System.out.println(title);
		    Reporter.log(title, true);
		    String currenturl=driver.getCurrentUrl();
		    System.out.println(currenturl);
		    Reporter.log(currenturl, true);
		  }
			@Test(priority=1)
			public void Printalllinks() throws IOException {
				navigateto(readdata("url2"));
				List<WebElement> alllinks=driver.findElements(By.tagName("a"));
				System.out.println(alllinks.size());
				for(int i=0;i<alllinks.size();i++) {
						System.out.println(alllinks.get(i).getText());
				}
				String title=driver.getTitle();
		    System.out.println(title);
		    Reporter.log(title, true);
		    String currenturl=driver.getCurrentUrl();
		    System.out.println(currenturl);
		    Reporter.log(currenturl, true);
				
			}
			@Test(priority=2)
			public void Titleurlpagesource() throws IOException {
				navigateto(readdata("url3"));
				String title=driver.getTitle();
			    System.out.println(title);
			    Reporter.log(title, true);
			    String currenturl=driver.getCurrentUrl();
			    System.out.println(currenturl);
			    Reporter.log(currenturl, true);
				
			}
			@Test(priority=3)
			public void scrolling() throws IOException {
				navigateto(readdata("url4"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				driver.findElement(By.xpath("(//a[text()='@frodriguez'])[2]")).click();
				js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
				String title=driver.getTitle();
			    System.out.println(title);
			    Reporter.log(title, true);
			    String currenturl=driver.getCurrentUrl();
			    System.out.println(currenturl);
			    Reporter.log(currenturl, true);
			}
			@Test(priority=4)
			public void mouseover() throws IOException, InterruptedException {
			navigateto(readdata("url5"));
			WebElement mouseover=driver.findElement(By.xpath("//span[text()='Account & Lists']"));
			Actions action = new Actions(driver);
			action.moveToElement(mouseover).build().perform();
			Thread.sleep(2000);
		     WebElement signin =driver.findElement(By.linkText("Sign in"));
		    signin.click();
		    String title=driver.getTitle();
		    System.out.println(title);
		    Reporter.log(title, true);
		    String currenturl=driver.getCurrentUrl();
		    System.out.println(currenturl);
		    Reporter.log(currenturl, true);	      
				     }
			
			@Test(priority=5)
			public void windowhandling() throws IOException, InterruptedException {
				driver.navigate().to(readdata("url6"));
				String parentwindow=driver.getWindowHandle();
				System.out.println(parentwindow);
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
			}
			@Test(priority=6)
		    public void checkboxradiobutton() throws IOException {
		    	driver.navigate().to(readdata("url7"));
		    	  driver.findElement(By.xpath("(//div[@class='checkbox--wrapper'])[1]"));
		           Boolean data = driver.findElement(By.xpath("//input[@id='user_submit']")).isDisplayed();
			System.out.println(data);
			String title = driver.getTitle();
			System.out.println(title);
			Reporter.log(title, true);
			String url= driver.getCurrentUrl();
			System.out.println(url);
			Reporter.log(url, true);
			  
		        Boolean data1 = driver.findElement(By.xpath("//input[@id='user_submit']")).isEnabled();
			System.out.println(data1);
			String title1 = driver.getTitle();
			System.out.println(title1);
			Reporter.log(title1, true);
			String url1= driver.getCurrentUrl();
			System.out.println(url1);
			Reporter.log(url1, true);
			
	        Boolean data2 = driver.findElement(By.xpath("//input[@id='user_submit']")).isSelected();
				System.out.println(data2);
				String title11 = driver.getTitle();
				System.out.println(title11);
				Reporter.log(title11, true);
				String url11= driver.getCurrentUrl();
				System.out.println(url11);
				Reporter.log(url11, true);
			}
			@Test(priority=7)
			public void draganddrop() throws IOException {
				driver.navigate().to(readdata("url8"));
				 WebElement source=driver.findElement(By.id("draggable"));
			     WebElement destination=driver.findElement(By.id("droppable"));
			     Actions actions = new Actions(driver);
			     actions.dragAndDrop(source, destination).build().perform();
			     String title=driver.getTitle();
				 System.out.println(title);
				 Reporter.log(title, true);
				 String currenturl=driver.getCurrentUrl();
				 System.out.println(currenturl);
				 Reporter.log(currenturl, true);	    
			     
			}	
			@Test(priority=8)
			public void screenshot1() throws IOException, InterruptedException {
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
		
			
			@AfterTest
			public void closebrowser() {
				driver.close();
			}
}
