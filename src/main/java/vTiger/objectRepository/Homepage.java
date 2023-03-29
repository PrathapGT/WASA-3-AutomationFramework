package vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Genericutilities.WebdriverUtility;

public class Homepage extends WebdriverUtility {

	
	
	@FindBy(linkText="Organizations")
	
	private WebElement organizationlink;
	
	
	@FindBy(linkText="Contacts")
	
	private WebElement contactlink;
	
	
	@FindBy(linkText="Opportunities")
	
	private WebElement Opportunitieslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	
	private WebElement administrationimg;
	
	@FindBy(linkText="Sign Out")
	
	private WebElement signoutlink;
	
	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}

	public WebElement getAdministrationimg() {
		return administrationimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	
	
	//Business libraries
	
	
	/**
	 * This method will perform click action on organizationlink
	 */
	public void clickonorganizationlnk(){
		
		organizationlink.click();
	}
	
	public void clickoncontactlnk() {
		contactlink.click();
	}
	
	public void logoutofapp(WebDriver driver) {
		
		MouseHoverAction(driver, administrationimg);
		
		signoutlink.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
