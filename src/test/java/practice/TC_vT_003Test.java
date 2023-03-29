package practice;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_vT_003Test{

	@Test(groups="smokesuite")
	
	public void createorganizationtest()
	{

      
		//step1: Launch The browser
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("http://localhost:8888/");
		
		//step2:Login To The Application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//step3:Navigate to organization Link
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//step4:Click on Lookup Image Link
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//step5:create organization with mandatory fields
      
      
    	  

		driver.findElement(By.xpath("//input[@type='text'  and @name='accountname']")).sendKeys("YSR");
      
      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      
        //step6:verification
      
        String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

      if(header.contains("YSR")) {
    	   
    	   System.out.println(header+ "---pass---");
       }
       else
       {
    	   System.out.println(header+ "---Fail---");
       }
        	
        	System.out.println("name  already exists");
      
      
       //step6:Logout of application
       
        	
        
        	
        
      WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
      
     Actions act=new Actions(driver);
      
      act.moveToElement(ele).perform();
       
     driver.findElement(By.linkText("Sign Out")).click();
     
      
      System.out.println("signout successful");
      }
      }
	

