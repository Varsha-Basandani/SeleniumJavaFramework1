package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch_TestNG2 {
	WebDriver driver=null;
	
	@BeforeTest
	public void setUpTest()
	{
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	
	@Test
	public void googleSearch2()
	{  //go to google.com
		driver.get("https://google.com");

		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("India");
		
		//click on search button
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		
		}
	@Test
	public void googleSearch3()
	{  //go to google.com
		driver.get("https://google.com");

		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("India");
		
		//click on search button
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
	}	
	
	@AfterTest
	public void tearDownTest()
	{//close browser
		driver.close();
		driver.quit();
		
		System.out.println("Test completed successfully");
		
	}
	

}
