package vTiger.contactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.Genericutilities.Baseclass;
import vTiger.objectRepository.ContactInfopage;
import vTiger.objectRepository.Contactpage;
import vTiger.objectRepository.CreatenewContactPage;
import vTiger.objectRepository.Homepage;
import vTiger.objectRepository.Organizationinfopage;
import vTiger.objectRepository.Organizationspage;
import vTiger.objectRepository.createneworganizationpage;

@Listeners(vTiger.Genericutilities.Listnersimplimentation.class)
public class CreatecontactwithorganizationTest2 extends Baseclass{

	
	@Test
	
	public void createcontactwithorganizationTest_002() throws EncryptedDocumentException, IOException {
		
		/*Read data from excel--Testdata*/
		String ORGNAME = eUtil.readdatafromexcel("contacts", 4, 2);
		String LASTNAME = eUtil.readdatafromexcel("contacts", 4, 3);
		
		Homepage hp=new Homepage(driver);
		hp.clickonorganizationlnk();
		
		
  Organizationspage op=new Organizationspage(driver);
  op.createorgLookupimg();
  
  
  createneworganizationpage cnop=new createneworganizationpage(driver);
  
  cnop.createorganization(ORGNAME);
  
  
  Organizationinfopage oip=new Organizationinfopage(driver);
  String orgheader = oip.Orgheadertxt();
  
  Assert.assertTrue(orgheader.contains(ORGNAME));
  
  System.out.println("organization created");
  
  
  hp.clickoncontactlnk();
  
  
  Contactpage cp=new Contactpage(driver);
  
  cp.ClickonCreateContactimg();
  
  
  CreatenewContactPage cnc=new CreatenewContactPage(driver);
  cnc.createNewContact(LASTNAME, driver, ORGNAME);
  
  ContactInfopage cip=new ContactInfopage(driver);
  
 String contactheader = cip.getcontactheader();
 
 Assert.assertTrue(contactheader.contains(LASTNAME));
 
 System.out.println("contacted created");
	}
	
	
}
