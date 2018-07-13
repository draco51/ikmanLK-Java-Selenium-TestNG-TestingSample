package automationIkmanLK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTest extends MainComps{
	WebDriver driver = null;
	@BeforeMethod
	public void beforemethod() throws InterruptedException {
		//Set the Location of the webDriver
		System.setProperty("webdriver.chrome.driver","D:\\selnm\\chromedriver.exe"); 
		//Create an object of webdriver
		driver = new ChromeDriver();

	}
	
	@Test(priority = 1)
	public void testcase() throws InterruptedException {
		navigateApp(driver);
		getproductprice(driver);
			
	}
	
	@AfterMethod
	public void aftertest() throws InterruptedException{
		driver.close();	
	}

}
