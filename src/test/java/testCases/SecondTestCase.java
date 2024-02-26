package testCases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class SecondTestCase extends BaseClass{
	
	
	@Parameters({"Titlename" , "Code"})
	@Test
	public void SearchResults(String title, String code) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on Dashboard
        driver.findElement(By.xpath("//a[@href='/app/dashboard']")).click();
         
        //click  on Exportbug.MP4                                                                        	
		driver.findElement(By.xpath("//div[@class='thumb-content']")).click();
	
		//click on Create NEW Incident/Event Button
		  driver.findElement(By.xpath("(//a[@aria-label='Create new incident'])[1]")).click();
	//    driver.findElement(By.xpath("//a[@aria-label='Create new event']")).click();
		
		//input the Title of New Event dynamically
		driver.findElement(By.id("inputCustom55")).sendKeys(title);
		
		//click on set to now button
		driver.findElement(By.xpath("//button[normalize-space()='Set to now']")).click();
		
		//input reference code dynamically from XML file
		driver.findElement(By.xpath("//input[@id='inputCustom59']")).sendKeys(code);
		
	    //click on Create Incident/Event button
		driver.findElement(By.xpath("(//button[normalize-space()='Create incident'])[1]")).click();
	//  driver.findElement(By.xpath("//button[normalize-space()='Create event']")).click();
		
		Thread.sleep(1000);  
		
		
		//click on Incidents/Events  button
		driver.findElement(By.xpath("//a[normalize-space()='Incidents']")).click();
	//	driver.findElement(By.xpath("//a[normalize-space()='Events']")).click();
		
		//click on Search Events/Incidents 
		//driver.findElement(By.xpath("//body/div[@class='wrapper']/div[@id='childNavRegion']/div[@class='child-nav-bar']/ul[@role='tablist']/li[3]/a[1]")).click();
		driver.findElement(By.xpath("(//a[contains(@class,'navigationLink')])[9]")).click();

		//Input the New Incident Title Dynamically from XML file
		driver.findElement(By.id("filterCustom55")).sendKeys(title);
		
		//Input Reference code Dynamically from XML file
		driver.findElement(By.xpath("//input[@id='filterCustom59']")).sendKeys(code);
		
		
		//click on Find Incidents/Events
	    driver.findElement(By.xpath("(//button[normalize-space()='Find incidents'])[1]")).click();
	//	driver.findElement(By.xpath("//button[normalize-space()='Find events']")).click();
		
	
		//Get the Title of New Event
		String actual_value =	driver.findElement(By.xpath("//tbody/tr[1]/td[8]")).getText();
		                        
		String exp_value = title;
		
		//Validate NewIncident appears in the Search Incident results
		Assert.assertEquals(actual_value, exp_value, "Newicident appears in search incident results");
	      
			
		}
	
	
	}
	


		
	
	
	
	

