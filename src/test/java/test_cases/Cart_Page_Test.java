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
import pages.Cart_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class Cart_Page_Test extends TestBase {
	LoginPage login;
    Inventory_Page invent;
	Cart_Page cart;
	

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialzation();
		login= new LoginPage();
		 invent = new Inventory_Page();
		cart =new Cart_Page();
		login.loginToAppliction();
		invent.add6Product();
		invent.clickcartIcon();
	}
	@Test(groups= {"Retesting"})
	public void verifyCartPageUrlTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExel(0, 6);//https://www.saucedemo.com/cart.html(0.6)
		String actURL= cart.verifyCartPageUrl();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("current page url of cart page= "+ actURL);
	}
	@Test(groups= {"Retesting"})
	public void verifyCartPageLableTest () throws EncryptedDocumentException, IOException
	{
		String expText = ReadData.readExel(0, 7);//Your Cart(0.7)

				String actText= cart.verifyCartPageLable();
		Assert.assertEquals(expText, actText);
		Reporter.log("Cart Page lable ="+ actText);
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

