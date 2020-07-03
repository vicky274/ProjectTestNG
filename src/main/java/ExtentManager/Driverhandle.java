package ExtentManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Driverhandle {
    
	private static final String path="./src/main/resources/config.properties";
	FileInputStream fis=null;
	private static Map<String,String> hashmap;
	public static WebDriver driver;
	Properties prop;
	static ChromeDriverService service;
	
	public Driverhandle() {
		prop= new Properties();
		hashmap = new HashMap<String,String>();
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			prop.load(fis);
			for(Entry<Object, Object> entry: prop.entrySet()){
				
				hashmap.put((String)entry.getKey(),(String) entry.getValue());
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static String getvalue(String key){
		return hashmap.get(key);
	}
	
	public static WebDriver setup(String url) throws IOException{
	
		try{
		switch(getvalue("browser"))
		{
		case "chrome":
			service = new ChromeDriverService.Builder()
			.usingDriverExecutable(new File(getvalue("jarfile"))).usingAnyFreePort().withSilent(true).build();
			service.start();
			driver = new ChromeDriver(service);
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	

}
