package vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfopage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	
	private WebElement ContactheaderText;
	
	
	public ContactInfopage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getContactheaderText() {
		return ContactheaderText;
	}
	
	//Business Libraries
	
	public String getcontactheader() {
		return ContactheaderText.getText() ;
		
		
	}
}
