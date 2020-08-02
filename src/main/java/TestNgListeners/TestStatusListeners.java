package TestNgListeners;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import ExtentManager.BrowserFactory;
import ExtentReportListener.ExtentReportManager;
import ExtentReportListener.ExtentTestManager;
import Utility.Capturescreenshot;

public class TestStatusListeners  implements ITestListener ,ISuiteListener{
	
	//private static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	//private Capturescreenshot Capturescreenshot=new Capturescreenshot();

	private BrowserFactory BrowserFac;
	
	@Override
	public void onFinish(ITestContext Context) {
     
		
	}

	@Override
	public void onStart(ITestContext Context) {
		System.out.println("--------------------"+Context.getName()+"---------------------------");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
			 ExtentTestManager.getTest().fail(MarkupHelper.createLabel(result.getThrowable().getMessage(), ExtentColor.RED));
			//test.fail(result.getThrowable().getMessage());
			 ExtentTestManager.getTest().fail(result.getName()+" Failed", MediaEntityBuilder.
					createScreenCaptureFromPath(Capturescreenshot.capturescreenshot(BrowserFac.getDriver(),result.getMethod().getMethodName()))
					.build());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("----------------------"+result.getName()+"--------------------------");
		ExtentTestManager.CreateTest(result.getName());
		ExtentTestManager.getTest().log(Status.INFO, MarkupHelper.createLabel(result.getName()+" Started Test Case Execution", ExtentColor.INDIGO));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
		
			 ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			 ExtentTestManager.getTest().pass(result.getName()+" Passed", 
			MediaEntityBuilder.createScreenCaptureFromPath(Capturescreenshot.capturescreenshot(BrowserFac.getDriver(),result.getName())).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		ExtentTestManager.endTest();	
	}

	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("----------------------On Suite Starts--------------------------");
		ExtentTestManager.CreateInstance();
		BrowserFac=BrowserFactory.getinstance();
	}

}
