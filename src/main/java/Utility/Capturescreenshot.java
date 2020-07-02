package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ExtentManager.Driverhandle;

public class Capturescreenshot extends Driverhandle{

	public static String capturescreenshot(String screenshotName) throws IOException {
		String dest = "./Screenshot/"+screenshotName+timestamp()+".png";
		
		TakesScreenshot ts = (TakesScreenshot) Driverhandle.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
 
        return dest;
    }
	
	public static String timestamp() {
	    return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	
}
