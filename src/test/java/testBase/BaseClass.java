package testBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
      public WebDriver driver;
     
  	@BeforeTest
  	public void initialiseBrowser()  {
  		
  		
  		ChromeOptions options= new ChromeOptions();
  		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
  		
     	//Launching the Chrome driver
  		WebDriverManager.chromedriver().setup();
  	    driver = new ChromeDriver();      
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  		 
  	}
  	
  	@AfterTest
  	public void Teardown() {
  		
  		
  		driver.quit(); ////closing the browser 
  		
  	}  
  	
  	@Parameters("url")
  	@Test()
  	public void LaunchApp(String url) throws Exception 
  	{
  		
  		driver.get(url);   ////Input the Web URL from XML page
  		
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
  		
  	}  	
  	
  	@Parameters({"username", "password"})
  	@Test
  	public void EnterLogindetails(String userName, String Password) throws Exception
  	{
  		
  		driver.findElement(By.id("username")).sendKeys(userName);  //Input the username from XML file
  		
		driver.findElement(By.id("password")).sendKeys(Password);   //Input the password from XML file
		
		driver.findElement(By.id("sign-in")).click();
		
  		
  	} 
  	
  	
  	
	
}
   



