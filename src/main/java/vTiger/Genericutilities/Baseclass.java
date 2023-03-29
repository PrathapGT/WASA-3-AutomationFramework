package vTiger.Genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.objectRepository.Homepage;
import vTiger.objectRepository.Loginpage;

/**
 * This class consists of Basic configuration annotations of Testng
 * @author home
 *
 */
public class Baseclass {

	
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public Excelfileutility eUtil=new Excelfileutility();
	public WebdriverUtility wUtil=new WebdriverUtility();
	public JavaUtility jUtil=new JavaUtility();
	public static WebDriver sDriver;
	
	
	public WebDriver driver;
	
	@BeforeSuite(groups= {"smokesuite" ,"regressionsuite"})
	
	public void bsconfig() {
		
		System.out.println("-----Database connection successful-----");
	}
	
	
 // @Parameters("browser")
	//@BeforeTest
	
	
	@BeforeClass(groups= {"smokesuite","regressionsuite"})
	
	public void beconfig(/*String BROWSER*/) throws IOException {
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		
		String URL = pUtil.readDataFromPropertyFile("url");
		
		
		if(BROWSER.equalsIgnoreCase("EdgeDriver")) {
			
			WebDriverManager.edgedriver().setup();
			
			 driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			
			System.out.println("invalid browser");
		}
		
		sDriver=driver;
		wUtil.maxmisewindow(driver);
		wUtil.waitforpage(driver);
		driver.get(URL);
		
	
		}
		
	@BeforeMethod(groups= {"smokesuite","regressionsuite"})
	
	public void bmconfig() throws IOException {
		
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		Loginpage lp=new Loginpage(driver);
		lp.logintoapp(USERNAME, BROWSER);
		
		System.out.println("---login to application---");
		
		
	}
    @AfterMethod(groups= {"smokesuite","regressionsuite"})
    
    public void amconfig() {
    	
    Homepage hp=new Homepage(driver);
    
   hp.logoutofapp(driver);
   
   System.out.println("Logout successful");
    }
		
    @AfterClass(groups= {"smokesuite","regressionsuite"})
    
    public void accong() {
    	
    	driver.quit();
    	
    	System.out.println("browser closed successfully");
    }
	 
    @AfterSuite(groups= {"smokesuite","regressionsuite"})
    
    public void ascong() {
    	
    	System.out.println("database closed");
    }
    
	}

		
	

