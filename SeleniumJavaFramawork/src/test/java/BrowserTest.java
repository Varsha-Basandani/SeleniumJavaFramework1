import javax.swing.SingleSelectionModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	public static void main(String[] args) {
     	String projectPath=System.getProperty("user.dir");
		
		
		/*System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
     	
     	System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
     	System.setProperty("webdriver.ie.driver", projectPath+"\\drivers\\iedriver\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		*/
     	WebDriverManager.chromedriver().setup();
     	WebDriver driver=new ChromeDriver();
		driver.get("http://google.com/");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
		}

}
