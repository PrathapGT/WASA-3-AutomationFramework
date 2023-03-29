package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_vT_005Test {

 @Test(groups="regessionsuite")
 public void testcasevT05test()
 
 {

		//step1:Launch the browser
		
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		
		//step 2 open application with valid credentials
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		
		
		//navigate to organization link
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//create organization
		
		driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys("qlearn");
		
		

		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
		
		sel.selectByValue("Energy");
		


		
 		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String header= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(header.contains("qlearn")) {
			
			System.out.println("----pass---");
		}
		
		else {
			
			System.out.println("---Fail---");
		}
	}

}
