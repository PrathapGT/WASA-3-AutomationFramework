package vTiger.Genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of To read generic methods to read data from property File
 * @author home
 *
 */


public class PropertyFileUtility {
/**
 * This method will read data from property file
 * @return
 * @throws IOException
 */
	
	
	public String readDataFromPropertyFile(String key) throws IOException {
		
FileInputStream fis	=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");	
		Properties pobj=new Properties();
		
pobj.load(fis);	
String value = pobj.getProperty(key);
return value;		
		
		
	}

	
}

