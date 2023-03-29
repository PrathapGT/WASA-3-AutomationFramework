package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("edgedriver")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		driver.get(URL);
	}

}
