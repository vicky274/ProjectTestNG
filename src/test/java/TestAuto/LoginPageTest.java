/*package TestAuto;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ExtentManager.Driverhandle;
import Listeners.Listeners;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import PageObject.LoginPageObject;
import TestData.TestDataFromExcel;
import Utility.Capturescreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest extends Listeners{
	
	LoginPageObject LoginPageObject;
	static WebDriver driver;
	static ExtentTest test;
	static SoftAssert s;
   @BeforeSuite
   public void beforeSuite() throws IOException 
   {
	   System.out.println("Before Suite");
	     Driverhandle Driverhandle=new Driverhandle();
	     driver = Driverhandle.setup();
   }

   @BeforeMethod
   public void before() throws Exception {
 	  
	   Reporter.log("Before method",true);
	   LoginPageObject=new LoginPageObject(driver);
	  
   }
   
   @Test(priority=0)
   public void test() throws Exception{
	    //TestDataFromExcel.getCellData("Sheet3");
	   //TestDataFromExcel.setCellData("Sheet2");
	    test = Listeners.test;
	    test.log(Status.INFO, "Data to be set in Excel Sheet");
	    //TestDataFromExcel.setCellDatafrommapvalue("Sheet3");
	    test.log(Status.INFO, "Data written in Excel Sheet");
	  
   }
  
  @Test(priority=1)
   public void DataforTest() throws Exception				
   {	
	  test = Listeners.test;
	  Object[][] data = TestDataFromExcel.getCellData("Sheet1");
		String[][] a = new String[data.length][data[0].length];
		
		 for (int i = 0; i < data.length; ++i) {
		        for(int j = 0; j < data[i].length; ++j) {
		          a[i][j]=data[i][j].toString();
		          System.out.println(a[i][j]);
		        }
		     }
		 
	  Markup m = MarkupHelper.createTable(a);
      test.pass(m);
	   //s = new SoftAssert();					
       //s.assertTrue(false);			
      
   }
   

   @DataProvider(name="dataprovider")
   public Object[][] oracledata() throws Exception {
     return TestDataFromExcel.getCellData("Sheet1");
   
   }
   
   
  @Test(priority=2, dataProvider="dataprovider")
  public void TestOracle(String email,String password,String retype,String name,String Last_name,String job,String phone,String company_name) throws Exception {
	  test = Listeners.test;
	  test.log(Status.INFO, "Enter Email");
	  LoginPageObject.enteremail(email);
	  test.log(Status.INFO, "Enter password");
	  LoginPageObject.enterpassword(password);
	  test.log(Status.INFO, "Enter retype password");
	  LoginPageObject.Retype_password(retype);
	  LoginPageObject.Name(name);
	  LoginPageObject.enterlastName(Last_name);
	  LoginPageObject.Company_Name(company_name);
	  LoginPageObject.enterJobtitle(job);
	  LoginPageObject.enterWorkphone(phone);
	  
	  
  }
  

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
	  //s.assertAll();
	  //driver.quit();
  }
  
  
  @AfterMethod
  public void tearDown(ITestResult result)
  {
  	
  if(ITestResult.FAILURE==result.getStatus())
  {
  	try {
  		Capturescreenshot.capturescreenshot(result.getName(), driver);
  	} catch (IOException e) {
  		e.printStackTrace();
  	}
  }

  }


}
*/