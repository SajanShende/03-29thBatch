package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1  extends TestBase {

	@FindBy(xpath="//input[@id='first-name']") private WebElement firstnameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastnameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement ZipCodeTxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	
	public  CheckOutPage1 ()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifyURL()
	{
		return driver.getCurrentUrl();
	}
	public String inputInfo()
	{
		firstnameTxtBox.sendKeys("sajan");
		lastnameTxtBox.sendKeys("shende");
		ZipCodeTxtBox.sendKeys("440009");
		 continueBtn.click();
		return driver.getCurrentUrl();
	}
		public String  verifytileofurl()
		{
			return driver.getTitle();
		}
	}

