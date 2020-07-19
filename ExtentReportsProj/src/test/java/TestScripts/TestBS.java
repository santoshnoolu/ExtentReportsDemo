package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.*;

public class TestBS {
	public static final String USERNAME = "santoshkumarnool2";
	public static final String AUTOMATE_KEY = "eaf5kQrtqtiHw9JQ3tTv";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void test() throws MalformedURLException
	{
	DesiredCapabilities caps = new DesiredCapabilities();
    
	caps.setCapability("os", "Windows");
	caps.setCapability("os_version", "10");
	caps.setCapability("browser", "Chrome");
	caps.setCapability("browser_version", "70");
	caps.setCapability("name", "santoshkumarnool2's First Test");
	WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	driver.get("https://google.com");
	driver.quit();
	}
	}

