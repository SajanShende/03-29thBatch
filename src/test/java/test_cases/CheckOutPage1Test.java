package test_cases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ScreenShot;

public class CheckOutPage1Test extends TestBase {
	 LoginPage login;
	 Inventory_Page invent;
	 Cart_Page cart;
	CheckOutPage1 check1;
	private WebDriver verifytileofurl;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialzation();
		login= new LoginPage();
		 invent = new Inventory_Page();
		cart =new Cart_Page();
		check1=new CheckOutPage1();
		login.loginToAppliction();
		invent.add6Product();
		invent.clickcartIcon();
		verifytileofurl.getTitle();
		cart.clickOnCheckoutBtn();
		 
		
	}
	
	@Test  
	public void verifyURLTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
				String actURL=check1.verifyURL();
		Assert.assertEquals(expURL, actURL);
				
	}
	@Test
	public void inputInfoTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.inputInfo();
		Assert.assertEquals(expURL, actURL);
	}
	
	public void closeBrowser(ITestResult it) throws IOException
	{
		{
			if(it.FAILURE==it.getStatus())
				ScreenShot.screenshot(it.getName());
		}
		driver.close();
	}
}
