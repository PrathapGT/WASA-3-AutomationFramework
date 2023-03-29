package vTiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Genericutilities.WebdriverUtility;

public class CreatenewContactPage extends WebdriverUtility {

	
	@FindBy(name="lastname")
	
	private WebElement lastnameedt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	
	private WebElement orglookupimg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	
	private WebElement savebtn;
	
	
	@FindBy(name="search_text")
	
	private WebElement searchedt;
	
	@FindBy(name="search")
	
	private WebElement searchbtn;
	
	public CreatenewContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameedt() {
		return lastnameedt;
	}

	public WebElement getOrglookupimg() {
		return orglookupimg;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getSearchedt() {
		return searchedt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	
	//Business Libraries
	
	public void CreateNewContact( String Lastname) {
		lastnameedt.sendKeys(Lastname);
		savebtn.click();
	}
	
	public void createNewContact(String Lastname ,WebDriver driver,String Orgname ) {
		lastnameedt.sendKeys(Lastname);
		orglookupimg.click();
		Switchtowindow(driver, "Accounts");
		searchedt.sendKeys(Orgname);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		Switchtowindow(driver, "Contacts");
		savebtn.click();
		
	}
	
	
}
