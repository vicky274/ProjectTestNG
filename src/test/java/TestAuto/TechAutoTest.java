package TestAuto;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ExtentManager.Driverhandle;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Listeners(TestNgListeners.Listeners.class)
public class TechAutoTest {
	
public static WebDriver driver;
Driverhandle handle;
SoftAssert s= new SoftAssert();
	@BeforeClass
	public void beforeMethod() {
		try {
			handle = new Driverhandle();
			System.out.println(Driverhandle.getvalue("demo-url"));
			driver = Driverhandle.setup(Driverhandle.getvalue("demo-url"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

	@Test(priority = 0)
	public void AdditionTest() {
		int sum = 0;
		int a = 5;
		int b = 7;
		sum = a + b;
		System.out.println(sum);
	}

	@Test(priority = 1)
	public void SubractionTest() {
		System.out.println("Test case has been failed");
		s.assertTrue(false,"Not as Expected");
		s.assertAll();
	}
  


	  @AfterClass
	  public void quit() throws InterruptedException{
		 Thread.sleep(3000);
	 	 driver.quit();
	  }

	  
}
