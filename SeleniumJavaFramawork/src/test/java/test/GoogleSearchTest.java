package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;

public class GoogleSearchTest {
	private static WebDriver driver=null;
	public static void main(String[] args) {
		googleSearch();
		
	}
	
	public static void googleSearch()
	{
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		
		/*//go to google.com
		driver.get("https://google.com");

		//enter text in search text box
		GoogleSearchPage.textbox_search(driver).sendKeys("India");
		
		//click on search button
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);*/
		
		 
		 GoogleSearchPageObjects searchPageObj=new GoogleSearchPageObjects(driver);
		 driver.get("https://google.com");
		 searchPageObj.setTextInSearchBox("India");
		 GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
		 
		 
		 
		 
		 
		//close browser
		driver.close();
		
		System.out.println("Test completed successfully");
		}

}
