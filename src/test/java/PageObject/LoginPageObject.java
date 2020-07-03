package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver driver;
	@FindBy(xpath="//input[@id='email::content']")
	public WebElement Email;
	@FindBy(xpath="//input[@id='password::content']")
	public WebElement Password;
	@FindBy(xpath="//input[@id='retypePassword::content']")
	public WebElement Retype_password;
	@FindBy(xpath="//input[@id='companyName::content']")
	public WebElement Company_Name	;
	@FindBy(xpath="//input[@id='firstName::content']")
	public WebElement Name;
	@FindBy(xpath="//input[@id='lastName::content']")
	public WebElement Last_Name;
	@FindBy(xpath="//input[@id='jobTitle::content']")
	public WebElement Title;
	@FindBy(xpath="//input[@id='workPhone::content']")
	public WebElement Work_Phone;
	
	public LoginPageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enteremail(String email) throws InterruptedException{
		Email.clear();
		Thread.sleep(500);
		Email.sendKeys(email);
	}
	
	public void enterpassword(String password) throws InterruptedException{
		Password.clear();
		Thread.sleep(500);
		Password.sendKeys(password);
	}
	
	public void Retype_password(String password) throws InterruptedException{
		Retype_password.clear();
		Thread.sleep(500);
		Retype_password.sendKeys(password);
	}
	
	
	public void Company_Name(String Company_name) throws InterruptedException{
		Company_Name.clear();
		Thread.sleep(500);
		Company_Name.sendKeys(Company_name);
	}
	
	
	public void Name(String name) throws InterruptedException{
		Name.clear();
		Thread.sleep(500);
		Name.sendKeys(name);
	}
	
	public void enterlastName(String name) throws InterruptedException{
		Last_Name.clear();
		Thread.sleep(500);
		Last_Name.sendKeys(name);
	}
	

	public void enterJobtitle(String job) throws InterruptedException{
		Title.clear();
		Thread.sleep(500);
		Title.sendKeys(job);
	}
	
	public void enterWorkphone(String phone) throws InterruptedException{
		Work_Phone.clear();
		Thread.sleep(500);
		Work_Phone.sendKeys(phone);
	}
}
