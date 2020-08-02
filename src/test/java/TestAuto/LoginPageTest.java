package TestAuto;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ExtentManager.BrowserFactory;
import ExtentReportListener.ExtentReportManager;
import ExtentReportListener.ExtentTestManager;
import PageObject.LoginPageObject;
import TestData.TestDataFromExcel;

/*@Listeners(TestNgListeners.TestStatusListeners.class)*/
public class LoginPageTest {

	LoginPageObject LoginPageObject;
	private static SoftAssert s;
	private WebDriver driver;
	private BrowserFactory BrowserFac;

	@BeforeTest
	public void Initializedriver() {
		try {
			BrowserFac = BrowserFactory.getinstance();
			System.out.println(BrowserFac.getvalue("url"));
			BrowserFac.setup();
			this.driver = BrowserFac.getDriver();
			driver.get(BrowserFac.getvalue("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void initializeObject() throws Exception {
		LoginPageObject = new LoginPageObject(driver);
	}

	@Test(priority = 2)
	public void TableDataforTest() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "TableDataforTest Started");
		Object[][] data = TestDataFromExcel.getCellData("Sheet1");
		String[][] a = new String[data.length][data[0].length];

		for (int i = 0; i < data.length; ++i) {
			for (int j = 0; j < data[i].length; ++j) {
				a[i][j] = data[i][j].toString();
				System.out.println("The data is :" + a[i][j]);
			}
		}

		Markup m = MarkupHelper.createTable(a);
		Markup m1 = MarkupHelper.createCodeBlock("<Emp>Vicky</Emp>" + "<Salary>2000</Salary>", CodeLanguage.XML);
		ExtentTestManager.getTest().pass(m);
		ExtentTestManager.getTest().pass(m1);
	}

	@DataProvider(name = "dataprovider")
	public Object[][] oracledata() throws Exception {
		return TestDataFromExcel.getCellData("Sheet1");

	}

	@Test(priority = 1, dataProvider = "dataprovider")
	public void TestOracleWebPage(String email, String password, String retype, String name, String Last_name,
			String job, String phone, String company_name) throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "TestOracleWebPage Step Execution Started");
		ExtentTestManager.getTest().log(Status.INFO, "Enter Email");
		LoginPageObject.enteremail(email);
		ExtentTestManager.getTest().log(Status.INFO, "Enter password");
		LoginPageObject.enterpassword(password);
		ExtentTestManager.getTest().log(Status.INFO, "Enter retype password");
		LoginPageObject.Retype_password(retype);
		LoginPageObject.Name(name);
		LoginPageObject.enterlastName(Last_name);
		LoginPageObject.Company_Name(company_name);
		LoginPageObject.enterJobtitle(job);
		LoginPageObject.enterWorkphone(phone);

	}

	@AfterTest
	public void CloseBrowser() {
		try {
			Thread.sleep(2000);
			driver.close();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	/*
	 * @Test(priority=0) public void test() throws Exception{
	 * //TestDataFromExcel.getCellData("Sheet3");
	 * //TestDataFromExcel.setCellData("Sheet2"); test = Listeners.test;
	 * test.log(Status.INFO, "Data to be set in Excel Sheet");
	 * //TestDataFromExcel.setCellDatafrommapvalue("Sheet3");
	 * test.log(Status.INFO, "Data written in Excel Sheet");
	 * 
	 * }
	 */

}
