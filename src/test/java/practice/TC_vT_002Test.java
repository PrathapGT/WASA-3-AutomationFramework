package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_vT_002Test {

	
	@Test(groups="smokesuite")
	public void createcontactTest()
	{
// step 1:Launch the browser
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		
		
		driver.get("http://localhost:8888/");
		
		//step 2:Login to application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//step3:Navigate To contact Link
driver.findElement(By.linkText("Contacts")).click();
		
		//step4:click on create contact look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//step5: create contact with mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys("prathap");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification of contact
		
		String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(contactheader.contains("prathap"))
		{
			
			System.out.println(contactheader+"---pass---");
		}
		
		else
		{
			System.out.println("---Fail---");
		}
		//step7 Logout of application
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		Actions act=new Actions(driver);
		
		act.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("signout successful");
	}

}
