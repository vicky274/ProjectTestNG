package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.Module.SetupContext;

import ExtentManager.BrowserFactory;

public class Capturescreenshot {

	public  static String capturescreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dest = "./Screenshot/"+screenshotName+timestamp()+".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
 
        return dest;
    }
	
	public static String timestamp() {
	    return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	
}
