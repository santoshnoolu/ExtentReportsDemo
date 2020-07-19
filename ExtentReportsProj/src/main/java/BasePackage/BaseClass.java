package BasePackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ReportHandling.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
@BeforeSuite
public void beforeSuite()
{
ExtentManager.setExtent();	
}
@AfterSuite
public void afterSuite()
{
ExtentManager.endReport();	
}
@BeforeMethod
public void beforeMethod()
{
	System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"//src//main//java//Resources//operadriver.exe");
	
	//  WebDriverManager.chromedriver().setup();
	  driver= new OperaDriver();
	  driver.manage().window().maximize();
	  driver.get("https://google.com");
	  
}
@AfterMethod
public void afterMethod()
{
	driver.quit();
	}
public static String screenshot(WebDriver driver,String filePath)
{
	String date= new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String dest=System.getProperty("user.dir")+"/Screenshots/"+filePath+date+".png";
	File destFile=new File(dest);
	try{
		FileUtils.copyFile(src, destFile);
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	return dest;
	}
public static String getCurrentTime()
{
	String Currentdate= new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());
	return Currentdate;
}
}
