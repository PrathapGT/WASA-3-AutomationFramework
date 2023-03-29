package vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	
	private WebElement createorgLookupimg;
	
	
	public  Organizationspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateorgLookupimg() {
		return createorgLookupimg;
	}
	
	
	//Business Libraries
	
	/**
	 * This method will perform action on createlookupimg
	 */
	public void createorgLookupimg() {
		createorgLookupimg.click();
	}
}
