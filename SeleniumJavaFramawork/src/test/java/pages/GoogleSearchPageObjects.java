package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	WebDriver driver=null;
	By textbox_search=By.name("q");
	
	public GoogleSearchPageObjects(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void setTextInSearchBox(String text)
	{
		driver.findElement(textbox_search).sendKeys(text);
	}

}
