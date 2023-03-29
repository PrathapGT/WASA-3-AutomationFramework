package practice;

import java.io.IOException;

import vTiger.Genericutilities.Excelfileutility;
import vTiger.Genericutilities.JavaUtility;
import vTiger.Genericutilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {

			PropertyFileUtility Putil=new PropertyFileUtility();
			
			String URL = Putil.readDataFromPropertyFile("url");
			System.out.println(URL);
			
			Excelfileutility eUtil=new Excelfileutility();
			
			String value = eUtil.readdatafromexcel("Organizations", 1, 2);
		
			System.out.println(value);
			
			System.out.println(eUtil.getRowCount("contacts"));
			
			JavaUtility Jutil=new JavaUtility();
			
			System.out.println(Jutil.getsystemDate());
			
			System.out.println(Jutil.getsystemDateInFormat());
	}

}
