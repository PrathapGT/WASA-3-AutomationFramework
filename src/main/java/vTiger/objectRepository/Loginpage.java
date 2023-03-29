package vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage { //rule 1 create POM Class for every webpage

//rule 2:identify the webelement byy using @Findby,@Findall,@Findbys
	
@FindBy(name="user_name")
private WebElement usernameedt;


@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']") })

private WebElement passwordedt;


@FindBy(id="submitButton")

private WebElement submitbtn;

//Rule 3:create a constructor to intialize the webelement

public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}

public WebElement getUsernameedt() {
	return usernameedt;
}

public WebElement getPasswordedt() {
	return passwordedt;
}

public WebElement getSubmitbtn() {
	return submitbtn;
}

//Business Libraries-Generic methods specific to current project


/**
 * This method will login to application
 * @param username
 * @param password
 */
public void logintoapp(String username,String password) {
	
	usernameedt.sendKeys("admin");
	passwordedt.sendKeys("admin");
	submitbtn.click();
}










}