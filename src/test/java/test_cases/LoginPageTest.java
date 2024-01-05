package test_cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class LoginPageTest extends TestBase 
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialzation();
		login= new LoginPage();
		invent =new Inventory_Page();
		login.loginToAppliction();
	}
	@Test
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExel(0, 0);//"Swag Labs"(0,0);
		String actTitle=login.verifyTitleOfApplication();
		 Assert.assertEquals(expTitle, actTitle);
	}
	@Test(groups = {"Sanity"})
	//Run | Debug
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExel(0,1);//"https://www.saucedemo.com/"(0,1)
		String actURL=login.verifyURLOfApplication();
		Assert.assertEquals(actURL, expURL); 
	}
	@Test(groups= {"Sanity","Regression"})
	public void loginToAppliction() throws IOException
	{
		String expURL=ReadData.readExel(0, 2);//"https://www.saucedemo.com/inventory.html";(0,2)
		String actURL=login.loginToAppliction();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After Login inventery Page should be come "+ actURL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		{
			if(it.FAILURE==it.getStatus())
				ScreenShot.screenshot(it.getName());
		}
		driver.close();
	}
	

}
