package practice;

import org.testng.annotations.Test;

public class Readdatafromcmd {

	
	
	@Test
	public void readdata() {
		
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = System.getProperty("url");
		
		System.out.println(URL);
		
		String USERNAME = System.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
	}
}
