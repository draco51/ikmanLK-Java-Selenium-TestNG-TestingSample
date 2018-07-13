package automationIkmanLK;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainComps {

	public void navigateApp(WebDriver driver) throws InterruptedException {
		//navigation
		driver.get("https://ikman.lk/");
		
		//findElement Property
		driver.findElement(By.linkText("Property")).click();
		
		//findElement Houses
		driver.findElement(By.xpath("//a[@href='/en/ads/sri-lanka/houses?categoryType=ads&categoryName=Property']")).click();

		//findElement Colombo
		driver.findElement(By.xpath("//a[@href='/en/ads/colombo/houses?categoryType=ads&categoryName=Houses&type=for_sale']")).click();

		driver.get("https://ikman.lk/en/ads/colombo/houses?categoryType=ads&categoryName=Houses&type=for_sale");
		//findElement Price
		driver.findElement(By.linkText("Price (Rs)")).click();
		//Fill min value
		driver.findElement(By.id("filters[0][minimum]")).sendKeys("5000000");
		//Fill max value
		driver.findElement(By.id("filters[0][maximum]")).sendKeys("7500000");
		
		//Click Apply Button
		driver.findElement(By.xpath("//button[@class='ui-btn is-standard btn-apply']")).click();
		
		//Click on Beds
		driver.findElement(By.linkText("Beds")).click();
		//Tick beds as 3
		driver.findElement(By.id("filters2values-3")).click();
		
		

	}
	
	public void getproductprice(WebDriver driver) throws InterruptedException{
		//Getting the Ads results count and prinitng it
				String result = driver.findElement(By.xpath("//span[@class='t-small summary-count']")).getText();
				String[] parts = result.split(" ");
				System.out.println("Number of Ads : "+ parts[3]);
				int noOfPages = (Integer.parseInt(parts[3]))/25;
				int pageNo = 0;  
			
				while( pageNo < noOfPages ) {
					List<WebElement> allElements = driver.findElements(By.xpath("//p[@class='item-info']/strong"));
					for (WebElement element: allElements) {
						String priceResult = element.getText();
						String[] parts2 = priceResult.split("( )|(\\,)");
						int price = Integer.parseInt(parts2[1]+parts2[2]+parts2[3]);
						//System.out.println(price>= 5000000 && price<=7500000? "" : price+ " Not in the price range");
						Assert.assertTrue(price>= 5000000 && price<=7500000, " Not in the price range");
						//System.out.println(price);
					}
					System.out.println("-----Page No:"+(pageNo+1)+ "-----"); 
			        pageNo++;
			        driver.findElement(By.linkText("Next")).click();
			      }

				driver.close();
		
	}
}
	

	
