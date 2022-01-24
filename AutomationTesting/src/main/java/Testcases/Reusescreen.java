package Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusescreen {
	WebDriver driver;
	public void takescreenshot(WebDriver driver,String name) throws IOException {
		
	     TakesScreenshot a = (( TakesScreenshot)driver);
	        File SrcFile = a.getScreenshotAs(OutputType.FILE);
	        File DestFile = new File("D:\\workspace\\AutomationTesting\\Screenshotscreen\\Screenshotscreen"+name+".png");
	        FileUtils.copyFile(SrcFile, DestFile);
	}

}
