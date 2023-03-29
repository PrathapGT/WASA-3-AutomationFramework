package vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {

	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	
	private WebElement createcontactlookupimg;
	
	
	public Contactpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreatecontactlookupimg() {
		return createcontactlookupimg;
	}
	
	
	//Business Libraries
	
	public void ClickonCreateContactimg() {
		
		createcontactlookupimg.click();
	}
}
