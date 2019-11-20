package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.Log4jDemo;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class GoogleSearch_TestNG {
	WebDriver driver=null;
	int count=0;
	private static Logger logger=LogManager.getLogger(Log4jDemo.class);
	
	@BeforeTest
	public void setUpTest()
	{
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 logger.info("Browser started");
	}
	
	@Test
	public void googleSearch()
	{  //go to google.com
		driver.get("https://google.com");
		 logger.info("Navigated to google.com");
		

		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("India");
		
		//click on search button
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		}
	@Test
	public void DivideByZero()
	{
		System.out.println("Inside  DivideByZero");
		//int i=1/0;
	}
	@Test(retryAnalyzer=listeners.RetryAnalyzer.class)
	public void testRetry2()
	{   count++;
		System.out.println("Inside testRetry2");
		Assert.assertTrue(2<=count);
	}
	@Test
	public void newGoogleSearch()
	{
		driver.get("https://google.com");
		Assert.assertEquals("Expected title", driver.getTitle());
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws JiraException
	{//If test case fails then log a ticket in jira
		if(result.getStatus()==ITestResult.FAILURE)
		{
			BasicCredentials creds=new BasicCredentials("varshabasandani3996", "Testuser@123");
			JiraClient jira=new JiraClient("http://localhost:8081/",creds);
			Issue issueName=jira.createIssue("TES", "Bug").field(Field.SUMMARY, result.getMethod().getMethodName()+" is failed due to "+result.getThrowable().toString()).field(Field.DESCRIPTION, "Test Description").execute();
		    System.out.println("Issue is created in JIRA with issue key :"+issueName.getKey());
		}
		
	}
	
	@AfterTest
	public void tearDownTest()
	{//close browser
		driver.close();
		driver.quit();
		
		System.out.println("Test completed successfully");
		
	}
	

}
