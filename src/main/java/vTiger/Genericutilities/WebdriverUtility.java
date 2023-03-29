package vTiger.Genericutilities;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;




/**
 * This class contains Generic methods which belongs to webdriver
 * @author home
 *
 */

public class WebdriverUtility {

	
	/**
	 * This method will maximise the window
	 * @param driver
	 */
	public void maxmisewindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimise the window
	 * @param driver
	 */
	public void minimisewindow(WebDriver driver) {
		
		driver.manage().window().minimize();
	}
	
	/**
	 * This Method will wait for page to load
	 * @param driver
	 */
	public void waitforpage(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	/**
	 * This method will wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void WaitForElementToBeVisible(WebDriver driver,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until element to be clickable
	 * @param driver
	 * @param element
	 */
	public void WaitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * This method will handle dropdown based on index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown based on value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value) {
		
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle dropdown based on visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**
	 * This method will perform mousehoveraction
	 * @param driver
	 * @param element
	 */
	public void MouseHoverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will rightclick on webpage
	 * @param driver
	 */
	public void RightclickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	
	/**
	 * This method will rightclick on webelement
	 * @param driver
	 * @param element
	 */
	public void RightclickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
         act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform doubleclickaction on  webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
act.doubleClick().perform();
	}
	
	/**
	 * This Method will perform doubleclickaction on webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
         act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and dropaction
	 * @param driver
	 * @param srcelement
	 * @param dstelement
	 */
	public void dragandDropAction(WebDriver driver,WebElement srcelement,WebElement dstelement) {
		Actions act=new Actions(driver);
       act.dragAndDrop(srcelement, dstelement).perform();
	}
	
	
	/**
	 * This method will accept the Alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * This method will dismiss the Alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get text from alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		
		  return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle Frame based on index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index) {
		
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle Frame based on nameorid
	 * @param driver
	 * @param nameorid
	 */
	public void handleFrame(WebDriver driver,String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	
	
	
	/**
	 * This method will handle Frame based on webelement
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element) {
		
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch To immediate ParentFrame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		
		driver.switchTo().parentFrame();
	}
	
	
	/**
	 * This method will switch To Default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will handle window based on partial window Title
	 * @param driver
	 * @param partialwintitle
	 */
	public void Switchtowindow(WebDriver driver,String partialwintitle) {
		//step1:capture all window id

		Set<String> Winh = driver.getWindowHandles();
		
		
		//step2:Navigate to each window
		for(String win:Winh) {
			
			//step3:switch to window and capture title
			String wintitle = driver.switchTo().window(win).getTitle();
			
			//step4:compare the Title with partial title
			if(wintitle.contains(partialwintitle)) {
				
				break;
			}
				
		}
	}
	/**
	 * This method will Take screenshot and save it in folder
	 * @param driver
	 * @param Screenshotname
	 * @return
	 * @throws IOException
	 */
	public String Takescreenshot(WebDriver driver, String Screenshotname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshots\\"+ Screenshotname+".png");
		
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();//used for extent reports
		
	}
	/**
	 * This method will scroll downward vertically
	 * @param driver
	 */
	public void scrollaction(WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("window.ScrollBy.(0,500)", " ");
	}
	
	/**
	 * This method will scroll until element is identified in DOM
	 * @param driver
	 * @param element
	 */
	public void scrollaction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.ScrollBy(0,"+y+")", element);
	}
}
