package ListenerPackage;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import BasePackage.BaseClass;
import ReportHandling.ExtentManager;

public class ListenerClass extends ExtentManager implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestResult result) {



	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}



	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP)
			test.log(Status.SKIP, "Test case "+result.getName()+" is skipped");

	}

	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.INFO, "Test case execution "+result.getName()+" is started");

	}

	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
			test.log(Status.PASS, "Test case "+result.getName()+" is passed");

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" is failed", ExtentColor.RED));
		String path= BaseClass.screenshot(BaseClass.driver,result.getName());
		try {
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
