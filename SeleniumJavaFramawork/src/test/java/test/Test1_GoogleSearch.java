package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {
	public static void main(String[] args) {
		googleSearch();
		
	}
	
	public static void googleSearch()
	{
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//go to google.com
		driver.get("https://google.com");

		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("India");
		
		//click on search button
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//close browser
		driver.close();
		
		System.out.println("Test completed successfully");
		}

}
