package vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Genericutilities.WebdriverUtility;

public class createneworganizationpage extends WebdriverUtility {

	
	@FindBy(name="accountname")
	
	private WebElement orgnameedt;
	
	
	@FindBy(name="industry")
	
	private WebElement industrydroopdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	
	private WebElement savebtn;
	
	
	public createneworganizationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getAccountnameedt() {
		return orgnameedt;
	}


	public WebElement getIndustrydroopdown() {
		return industrydroopdown;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}
	
	//Business Libraries
	
	
	/**
	 * This method will create orgnanization with orgname
	 * @param orgname
	 */
	public void createorganization(String orgname) {
		
		orgnameedt.sendKeys(orgname);
		savebtn.click();
	}
	
	public void createorganization(String orgname, String industryType) {
		orgnameedt.sendKeys(orgname);
		handleDropdown(industrydroopdown, industryType);
		savebtn.click();
		
		
	}
	
}
