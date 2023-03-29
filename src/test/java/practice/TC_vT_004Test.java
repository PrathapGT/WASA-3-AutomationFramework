package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_vT_004Test {

	
	@Test(groups="regessionsuite")
	
	public void TestcasevT04Test()
	 {

		//step1:Launch the browser
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("http://localhost:8888/");
		
		//step2:Login to application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		
		//step3 Navigate to organization
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys("Geeth");
		
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='industry']")));	
		
		sel.selectByValue("Chemicals");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			if(header.contains("Geeth")) {
				
				System.out.println("---pass---");
			}
			else {
				System.out.println("---Fail---");
			}
				

			
			
			
			

				
			}
		
			
		
		
			
			

				
			
	
			
		
	}		
			


