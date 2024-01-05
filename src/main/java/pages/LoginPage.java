package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase 
{
	
	//object repository
	@FindBy(xpath = "//input[@id='user-name']") private WebElement usernameTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	public LoginPage() 
		{
		
		PageFactory.initElements(driver, this);  
	}//constructor is used to load data member
	
	public String loginToAppliction() throws IOException
	{
		usernameTxtBox.sendKeys(ReadData.readPropertyFile("username"));
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl();
		
	}
	public String loginToApplicationMultiCreds(String un, String pass)
	
	{
		usernameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
        public String verifyTitleOfApplication()
     {
	       return driver.getTitle();
     }
        
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
		
	}
}
