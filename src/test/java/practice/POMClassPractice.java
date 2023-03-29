package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.objectRepository.Loginpage;

public class POMClassPractice {

	public static void main(String[] args) {

		
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888/");
		
		Loginpage lp=new Loginpage(driver);
		
		lp.logintoapp("admin", "admin");
	}

}
