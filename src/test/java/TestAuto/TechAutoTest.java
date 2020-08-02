package TestAuto;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ExtentManager.BrowserFactory;
import ExtentReportListener.ExtentTestManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/*@Listeners(TestNgListeners.TestStatusListeners.class)*/
public class TechAutoTest  {

	private WebDriver driver;
	BrowserFactory handle;
	SoftAssert s = new SoftAssert();
	private BrowserFactory BrowserFac;
	
	
	@BeforeTest
	public void Initializedriver() {
		try {
			BrowserFac=BrowserFactory.getinstance();
			System.out.println(BrowserFac.getvalue("demo-url"));
			BrowserFac.setup();
			this.driver = BrowserFac.getDriver();
			driver.get(BrowserFac.getvalue("demo-url"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 0)
	public void AdditionTest() throws InterruptedException {
		Thread.sleep(2000);
		int sum = 0;
		int a = 5;
		int b = 7;
		sum = a + b;
		System.out.println(sum);
	}

	@Test(priority = 1)
	public void SubractionTest() {
		// System.out.println("Test case has been failed Forcefully");
		s.assertTrue(true, "Not as Expected");
		s.assertAll();
	}
	
	@Test(priority = 2)
	public void FindWebElement() {
		driver.findElement(By.xpath("//*[@class='abcd']"));
	}

	
	/*@Test(priority = 2,threadPoolSize = 3, invocationCount = 3, timeOut = 10000)
	public synchronized void testServer() {
		
		System.out.println("Thread is :" + Thread.currentThread().getId());
		
			for(int i=1; i<=3;i++){
				System.out.println("Value of i :"+i);
				ExtentTestManager.getTest().pass("Value of i :"+i);
			}
		
		
		
	}*/
	  
	  @AfterTest
		public void CloseBrowser(){
			try {
				Thread.sleep(2000);
				driver.close();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	 
}
