package ExtentReportListener;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ExtentManager.BrowserFactory;

public class ExtentReportManager {
	
	private static ExtentReports extent=null;
	private static ExtentHtmlReporter htmlreporter=null;
	
	public static ExtentReports CreateInstance(){
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
	
	public static String reportname(){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
	    Calendar c = Calendar.getInstance();
		return "./AutomationReport/ExtentReport"+format.format(c.getTime())+"/Report.html";
	}
	
}
