package ExtentReportListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestManager {

	private static Map<Long, ExtentTest> extentTestMap = new HashMap<Long, ExtentTest>();
	private static ExtentReports extent = null;
	private static ExtentHtmlReporter htmlreporter=null;
	
	public synchronized static  ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get(Thread.currentThread().getId());
	}

	public synchronized static  void endTest() {
		extent.flush();
	}

	public synchronized static  ExtentTest CreateTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put(Thread.currentThread().getId(), test);
		return test;
	}
	
	public synchronized static ExtentReports CreateInstance(){
		  htmlreporter = new ExtentHtmlReporter(reportname());
		  htmlreporter.config().setDocumentTitle("Automation Report");
		  htmlreporter.config().setReportName("Smoke_Report");
		  htmlreporter.config().setTheme(Theme.DARK);
		  htmlreporter.config().setAutoCreateRelativePathMedia(true);
		  htmlreporter.start();
		  extent = new ExtentReports();
		  extent.attachReporter(htmlreporter);
		  extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		  extent.setSystemInfo("Author", System.getProperty("user.name"));
		return extent;
		
	}
	
	public synchronized static String reportname(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
	    Calendar c = Calendar.getInstance();
		return "./AutomationReport/ExtentReport"+format.format(c.getTime())+"/Report.html";
	}
}
