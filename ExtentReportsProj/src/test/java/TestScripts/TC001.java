package TestScripts;

import org.junit.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class TC001 extends BaseClass {

@Test
public void test1()
{
	String strTitle=driver.getTitle();
	Assert.assertEquals(strTitle,"Google");
}
}
