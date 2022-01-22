package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	
	Homepage(WebDriver driver){
	this.driver=driver;
		
	}
	WebDriver driver;
	By creatnewaccount = By.xpath("//a[text()='Create New Account']");
	By firstname = By.name("firstname");
	By lastname = By.name("lastname");
    By mobileoremail = By.name("reg_email__");
	By password=By.name("reg_passwd__");
	
	public void creatnewaccount() {
		driver.findElement(creatnewaccount).click();
	}
	
	public void enterfirstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
		
	}
	
	public void enteringlastname(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}
	
	public void enteringmail(String email) {
		driver.findElement(mobileoremail).sendKeys(email);
		
	}
	

	public void password(String pass) {
		driver.findElement(password).sendKeys(pass);
		
	}
 
}
