package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class FirstTestCase extends BaseClass {
		
	@Parameters("Inputname")
	@Test
	public void EquipmentReport(String value) throws Exception {
		
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
		//click on Dashboard
        driver.findElement(By.xpath("//a[@href='/app/dashboard']")).click();;
		
        //click on status Button
		driver.findElement(By.xpath("//a[normalize-space()='Status']")).click();	
        
		
		//Go to reports
		driver.findElement(By.xpath("(//a[contains(@class,'navigationLink')][normalize-space()='Reports'])[1]")).click();
		
		//click on Create a new report
		driver.findElement(By.xpath("//button[@aria-label='Create New Report']")).click();
		
		
		//Get Title name Dynamically from XML file
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys(value);
	
		//Select report type=EQUIPMENT
		driver.findElement(By.xpath("//option[@value='EQUIPMENT']")).click();
		
		//Select Schedule option "No" from dropdown
		driver.findElement(By.xpath("//span[contains(@class,'filter-option pull-left')][normalize-space()='No']")).click();
		
		//click on create Button
		driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
		
		Thread.sleep(2000);
		
		//Obtain the report title from reports to see if the new report has been created.
	    String actual_value =	driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[6]")).getText();
	
		//get the expected value from XML file
	   String exp_value = value;
	
	//Validate if the actual report created with expected report
	Assert.assertEquals(actual_value, exp_value);
 }

}

		
	
	
	
	

