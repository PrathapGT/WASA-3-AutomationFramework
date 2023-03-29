package vTiger.OrganizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.Genericutilities.Baseclass;
import vTiger.objectRepository.Homepage;
import vTiger.objectRepository.Organizationinfopage;
import vTiger.objectRepository.Organizationspage;
import vTiger.objectRepository.createneworganizationpage;


@Listeners(vTiger.Genericutilities.Listnersimplimentation.class)
public class Createorganizationtest extends Baseclass{
@Test

public void createorganizationTest_001() throws EncryptedDocumentException, IOException {
	
	/*read data from excel sheet */
	
	String ORGNAME = eUtil.readdatafromexcel("organizations", 1, 2);
	
	Homepage hp=new Homepage(driver);
	
	hp.clickonorganizationlnk();
	
	Reporter.log("click on organization link successful");
	
	Organizationspage op=new Organizationspage(driver);
	
	op.createorgLookupimg();
	
	Reporter.log("createorgLookupimg successful");
	createneworganizationpage nop= new createneworganizationpage(driver);
	nop.createorganization(ORGNAME);
	
	Organizationinfopage oip= new Organizationinfopage(driver);
	
	String ORGHEADER = oip.Orgheadertxt();
	
	Assert.assertTrue(ORGHEADER.contains(ORGNAME));
	
	
}
@Test
	public void dempscript() {
Reporter.log("demo script failed");		
	
	}
	
	
	
}
