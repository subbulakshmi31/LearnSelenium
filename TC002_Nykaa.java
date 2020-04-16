package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//1) Go to https://www.nykaa.com/
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();

			//2) Mouseover on Brands and Mouseover on Popular
			WebElement BrandMouseHover = driver.findElementByXPath("//a[text()='brands']");
			Actions builder = new Actions(driver);
			builder.moveToElement(BrandMouseHover).perform();
			WebElement PopularMouseHover = driver.findElementByXPath("//a[text()='Popular']");
			builder.moveToElement(PopularMouseHover).perform();
			 try{
		          driver.switchTo().alert().dismiss();
		          //return true;
		      }catch(NoAlertPresentException ex){
		          //return false;
		      }
		
		
		
			//3) Click L'Oreal Paris
			
			driver.findElementByXPath("(//li[@class='brand-logo menu-links'])[5]").click();

			//4) Go to the newly opened window and check the title contains L'Oreal Paris
			Set<String> winSet = driver.getWindowHandles();
			List<String> winList = new ArrayList<String>(winSet);
			driver.switchTo().window(winList.get(1));
			System.out.println(driver.getTitle());
			if (driver.getTitle().contains("L'Oreal Paris")) {
				System.out.println("The title contains L'Oreal Paris");
			} else {
				System.out.println("The title doesnt contain L'Oreal Paris");
			}
			 try{
		          driver.switchTo().alert().dismiss();
		          //return true;
		      }catch(NoAlertPresentException ex){
		          //return false;
		      }
			
			
			//5) Click sort By and select customer top rated
			
			driver.findElementByXPath("//span[text()='popularity']").click();
			driver.findElementByXPath("//span[text()='customer top rated']").click();
			Thread.sleep(2000);

			//6) Click Category and click Shampoo
			
			driver.findElementByXPath("//div[text()='Category']").click();
			driver.findElementByXPath("(//span[contains(text(), 'Shampoo')])[1]").click();

			//7) check whether the Filter is applied with Shampoo
			String filVal = driver.findElementByXPath("//li[text()='Shampoo']").getText();
			System.out.println(filVal);
			if (filVal.contains("Shampoo")) {
				System.out.println("The Filteration is Done Correctly");
			} else {
				System.out.println("The Filteration is not successful");
			}

			//8) Click on L'Oreal Paris Colour Protect Shampoo
			driver.findElementByXPath("(//img[contains(@alt,'Colour Protect')])[1]").click();

			//9) GO to the new window and select size as 175ml
			Set<String> winSetnew = driver.getWindowHandles();
			List<String> winListnew = new ArrayList<String>(winSetnew);
			driver.switchTo().window(winListnew.get(2));
			driver.findElementByXPath("//span[text()='175ml']").click();

			//10) Print the MRP of the product
			String price = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
			System.out.println("The price of the 175ml Loreal paris color protect Shampoo is " +price);
			

			//11) Click on ADD to BAG
			driver
.findElementByXPath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();

			//12) Go to Shopping Bag 
			driver.findElementByClassName("AddBagIcon").click();

			//13) Print the Grand Total amount
			//driver.findElementByClassName("value medium-strong").getText();
			String grandTotal =  driver.findElementByXPath("//div[@class='value medium-strong']").getText();
			System.out.println(grandTotal);
			Thread.sleep(2000);
			
			//14) Click Proceed
			driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
			

			//15) Click on Continue as Guest
			driver.findElementByXPath("//button[@class='btn full big']").click();

			//16) Print the warning message (delay in shipment)
			String msg = driver.findElementByXPath("//div[@class='message']").getText();
			System.out.println(msg);

			//17) Close all windows
			driver.close();
			driver.quit();


	}

}
