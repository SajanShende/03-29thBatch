package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.HandDropDown_ListBox;

public class Inventory_Page extends TestBase{
//object Repository
	//add xpath
	@FindBy(xpath="//span[text()='Products']") private WebElement productLable;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement bikelightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement shirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement tshirtredProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesiteProduct;
	//remove xpath 
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement backRemoveProductpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement bikeRemoveProductLight;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement  boltTshirtRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement jacketRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")private WebElement labonesiteRemoveProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement tshirtRemoveProduct;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private 	WebElement cartCount;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//a[text()='Twitter']")private WebElement twitterIMG;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookIMG;
	@FindBy(xpath="//a[text()='LinkedIn']")private WebElement linkedINIMG;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement productDropDown;
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifyProductLable() 
	{
		 
		return productLable.getText();
	} 
	
	public boolean verifyTwitterIMG() 
	{
		 return twitterIMG.isDisplayed();
		
	}
	public String add6Product()
	{
      HandDropDown_ListBox.handleSelectClass(productDropDown, "Price (low to high)");
      backpackProduct.click();
      bikelightProduct.click();
      shirtProduct.click();
      jacketProduct.click();
      onesiteProduct.click();
      tshirtredProduct.click();
      return cartCount.getText();
      
}
	public String remove2Product()
	{
		add6Product();
		backRemoveProductpack.click();
		bikeRemoveProductLight.click();
		return cartCount.getText();
	}
	public void clickcartIcon()
	{
		cartIcon.click();
	}
}