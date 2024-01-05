package utility;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class ScreenShot extends TestBase{

	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYY  ss-mm-HH").format(new Date());
	}
	
	public static void screenshot(String nameOFmethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Victus\\eclipse-workspace\\Project_Selenium\\screenshot"+ nameOFmethod+"---------"+getDate()+".jpeg");
		FileHandler.copy(source,dest);
	}
	
}
  	