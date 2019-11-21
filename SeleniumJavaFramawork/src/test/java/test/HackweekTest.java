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
import java.util.Iterator;;

public class HackweekTest {
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
	@Test(retryAnalyzer=listeners.RetryAnalyzer.class,groups={"group1"})
	public void googleSearch()
	{  //go to google.com
		driver.get("https://google.com");
		 logger.info("Navigated to google.com");
		

		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("India");
		logger.info("Searched");
		
		//click on search button
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		Assert.assertEquals("Test title", driver.getTitle());
		
		}
	
	@Test(groups={"group2"})
	public void loginTest()
	{  //go to opensource-demo.orangehrmlive.com
		driver.get("https://opensource-demo.orangehrmlive.com/");
		 logger.info("Navigated to opensource-demo.orangehrmlive.com");
		

		//enter  user name
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		 logger.info("entered user name");
		
		//enter password
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		 logger.info("entered password");
		
		//click on login button
		  
	     driver.findElement(By.id("btnLogin")).click();
	     logger.info("Clicked on login button");
	     
	    Assert.assertEquals( driver.getTitle(),"Orange");
	    
	 }
	
	
 @Test(retryAnalyzer=listeners.RetryAnalyzer.class,groups={"group3"})
	public void testRetry()
	{   count++;
		System.out.println("Inside testRetry2");
		Assert.assertTrue(2<=count);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws JiraException
	{//If test case fails then log a ticket in jira
		if(result.getStatus()==ITestResult.FAILURE)
			
		{String str=result.getMethod().getGroups()[0];
			BasicCredentials creds=new BasicCredentials("varshabasandani3996", "Testuser@123");
			JiraClient jira=new JiraClient("http://localhost:8081/",creds);
			
		Issue.SearchResult sr = jira.searchIssues("summary ~ "+result.getMethod().getGroups()[0]+" AND ( status = \"To Do\" OR status = \"Open\" OR status=\"In Progress\" OR status = \"Reopened\")");
		
		
		if(sr.total==1)
		{
			Issue issue = jira.getIssue(sr.issues.get(0).getKey());
			issue.addComment(result.getMethod().getMethodName()+" is failed again......");
		}

		
		else if(sr.total==0)
            
		{	Issue issueName=jira.createIssue("TES", "Bug").field(Field.SUMMARY,result.getMethod().getGroups()[0]+" "+ result.getMethod().getMethodName()+" is failed due to "+result.getThrowable().toString()).field(Field.DESCRIPTION, "Test Description").execute();
		   
			System.out.println("Issue is created in JIRA with issue key :"+issueName.getKey());
		}
		
		
		else{
			System.out.println("\n Multiple bugs logged for same identifier");
		}
		}
	}
	@AfterTest
	public void tearDownTest()
	{//close browser
		driver.close();
		driver.quit();
		logger.info("Test completed successfully");
		}
	

}
