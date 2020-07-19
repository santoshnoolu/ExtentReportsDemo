package ReportHandling;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BasePackage.BaseClass;

public class ExtentManager {
	@SuppressWarnings("deprecation")
	public static ExtentHtmlReporter htmlRep;
	public static ExtentReports extent;
public static ExtentTest test;
@SuppressWarnings("deprecation")
public static void setExtent()
{
	htmlRep = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport1/"+"MyReport"+BaseClass.getCurrentTime()+".html");
	htmlRep.loadXMLConfig(System.getProperty("user.dir")+"/src/main/java/Resources/extent-config.xml");
	extent= new ExtentReports();
	extent.attachReporter(htmlRep);
	extent.setSystemInfo("Project Name", "My Test Project");
	extent.setSystemInfo("OS","Windows");
	extent.setSystemInfo("Tester","Santosh");
	extent.setSystemInfo("Browser", "Chrome");

}
public static void endReport()
{
extent.flush();	
}
}

