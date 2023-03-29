package vTiger.Genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class contains Generic method related to Excel file
 * @author home
 *
 */
public class Excelfileutility {
	
	
	/**
	 * This method will read data from excel based on row and column
	 * @param Sheet
	 * @param row
	 * @param cel
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readdatafromexcel(String Sheet, int row,int cel) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExceLFilePath);
		
		Workbook wb = WorkbookFactory.create(fis);

		
		 org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(Sheet);
		       Row rw = sh.getRow(row);
		       Cell ce = rw.getCell(cel);
		       String value = ce.getStringCellValue();
			return value;
	
}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExceLFilePath);
		Workbook wb = WorkbookFactory.create(fis);
	 org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheet);
	
	int rowcount = sh.getLastRowNum();
	return rowcount;
		
	}
	
	public Object[][] readMultipleData(String sheetname) throws EncryptedDocumentException, IOException{
		
		
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExceLFilePath);
		
		
	Workbook	wb=WorkbookFactory.create(fis);
	
	org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetname);
	
	int lastrow = sh.getLastRowNum();
	
		return null;
		
		
	}
}
