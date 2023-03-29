package vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationinfopage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	
	private WebElement Orgheadertxt;
	
	
	public Organizationinfopage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgheadertxt() {
		return Orgheadertxt;
	}
	
	//Business libraries
	
	public String Orgheadertxt() {
		return Orgheadertxt.getText();
	}
}
