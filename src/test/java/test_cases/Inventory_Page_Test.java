package test_cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialzation();
		login= new LoginPage();
		invent=new  Inventory_Page();
		login.loginToAppliction();
		
	}
	@Test(groups= {"Sanity","Regression"})
	public void verifyProductLable() throws EncryptedDocumentException, IOException
	{
	String expLable=ReadData.readExel(0, 3);//"Products";(0,3)
	String actLable=invent.verifyProductLable();
	Assert.assertEquals(expLable, actLable);
	}
	@Test(groups= {"Sanity"})
	public void verifyTwitterIMG()
	{
		boolean result=invent.verifyTwitterIMG();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of TwitterIMG"+ result);
	}
    @Test(enabled = true ,groups= {"Sanity","Regression"})
    public void add6Product() throws EncryptedDocumentException, IOException
    {
 	   String expCount=ReadData.readExel(0, 4);//"6";
 	   String actCount=invent.add6Product();
 	   Assert.assertEquals(expCount, actCount);
    }
    @Test(enabled = true ,groups= {"Sanity","Regression"})
     public void remove2ProductTest() throws EncryptedDocumentException, IOException
     {
    	String expCount=ReadData.readExel(0, 5);//"4";
    	String actCount = invent.remove2Product();
    	Assert.assertEquals(expCount, actCount);
    	Reporter.log("Number of Product after removing "+ actCount);
     }
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
