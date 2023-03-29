package vTiger.contactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.Genericutilities.Excelfileutility;
import vTiger.Genericutilities.JavaUtility;
import vTiger.Genericutilities.PropertyFileUtility;
import vTiger.Genericutilities.WebdriverUtility;

@Listeners(vTiger.Genericutilities.Listnersimplimentation.class)
public class CreateContactwithOrganizationTest {

	@Test(groups="smokesuite")
	public void Createcontactwithorganization_TC_01() throws IOException
	{
//step1: create object for all utilities
		PropertyFileUtility pUtil=new PropertyFileUtility();
		Excelfileutility xUtil=new Excelfileutility();
		WebdriverUtility wUtil=new WebdriverUtility();
		JavaUtility jUtil=new JavaUtility();
//step2:read all necessary data
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = xUtil.readdatafromexcel("contacts", 4, 2);
		String LASTNAME = xUtil.readdatafromexcel("contacts", 4, 3);
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("EdgeDriver")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser name");
		}

		wUtil.maxmisewindow(driver);
		wUtil.waitforpage(driver);
		driver.get(URL);
		
		//step3: Login to app
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		
		//step4:click on orgnanization link
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//step5:click on create organization lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step6:create organization with mandatory details
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step7:save
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 8:validation
		String Orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(Orgheader.contains(ORGNAME)){
			
			System.out.println(Orgheader+"organization is created");
		}
		
		else {
			System.out.println("organization not created");
		}
		
		//step 9:navigate to contacts
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//step10:click on contacts lookup image
		
		

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//step11:create contact with mandatory fields
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//step12:click on organization lookup image
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//step13:switch to child window
		
		wUtil.Switchtowindow(driver, "Accounts");
		
		//step14:search for org
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//step15:switch the control back to parent and save
		
		wUtil.Switchtowindow(driver, "Contacts");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Assert.fail();
		
		//step16:validate contact
		
		String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(contactheader.contains(LASTNAME)) {
			
			System.out.println(contactheader+ "--pass--");
		}
		else {
			System.out.println(contactheader+"--Fail--");
		}
		
		//step17:Logout of application
		
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act=new Actions(driver);
	
	act.moveToElement(ele).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	}
	

	//@Test(groups="regressionsuite")
	
	//public void regressiontest() {
		
	//	System.out.println("regression test is passed");
	//}
	
	
	
}
