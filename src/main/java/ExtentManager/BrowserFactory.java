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

/*How to create Singleton design pattern?
To create the singleton class, we need to have static member of class, private constructor and static factory method.

Static member: It gets memory only once because of static, itcontains the instance of the Singleton class.
Private constructor: It will prevent to instantiate the Singleton class from outside the class.
Static factory method: This provides the global point of access to the Singleton object and returns the instance to the caller.
*/
public class BrowserFactory {
    
	private final String path="./src/main/resources/config.properties";
	FileInputStream fis=null;
	private  Map<String,String> hashmap;
	private  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() ;
	Properties prop;
	private ChromeDriverService service;
	private static BrowserFactory BrowserFactory;

	private BrowserFactory() {
		prop = new Properties();
		hashmap = new HashMap<String, String>();

		try {
			fis = new FileInputStream(path);
			prop.load(fis);
			for (Entry<Object, Object> entry : prop.entrySet()) {

				hashmap.put((String) entry.getKey(), (String) entry.getValue());
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public  String getvalue(String key){
		
		return hashmap.get(key);
	}
	
	public synchronized static BrowserFactory getinstance(){
		
		if(BrowserFactory==null){
			BrowserFactory=new BrowserFactory();
		}
		return BrowserFactory;
	}
	public void setup() throws IOException{
	
		try{
		switch(getvalue("browser"))
		{
		case "chrome":
			service = new ChromeDriverService.Builder()
			.usingDriverExecutable(new File(getvalue("jarfile"))).usingAnyFreePort().withSilent(true).build();
			service.start();
			driver.set(new ChromeDriver(service));
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public   WebDriver getDriver() {
		return driver.get();
	}
	

}
