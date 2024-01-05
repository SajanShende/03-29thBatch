package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class TestBase {
	public static WebDriver driver;
	public void initialzation() throws IOException, InterruptedException
	{
		String browser = ReadData.readPropertyFile("Browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browser.equals("firebox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("url"));
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
	}

}
