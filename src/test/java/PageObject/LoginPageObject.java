package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//page object
public class LoginPageObject {

	WebDriver driver;
	@FindBy(xpath="//input[@name='email']")
	public WebElement Email;
	@FindBy(xpath="//input[@name='phone']")
	public WebElement Phone;
	@FindBy(xpath="//input[@name='address']")
	public WebElement Address;
	@FindBy(xpath="//input[@name='city']")
	public WebElement city	;
	@FindBy(xpath="//input[@name='first_name']")
	public WebElement Name;
	@FindBy(xpath="//input[@name='last_name']")
	public WebElement Last_Name;
	@FindBy(xpath="//input[@name='zip']")
	public WebElement zipCode;
	@FindBy(xpath="//input[@name='website']")
	public WebElement website;
	@FindBy(xpath="//select[@name='state']")
	public WebElement Dropdown;
	@FindBy(xpath="//input[@name='hosting']")
	public WebElement Radiobutton;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement Submit;
	
	public LoginPageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enteremail(String email) throws InterruptedException{
		Email.clear();
		Thread.sleep(500);
		Email.sendKeys(email);
	}
	
	public void enterPhone(String phone) throws InterruptedException{
		Phone.clear();
		Thread.sleep(500);
		Phone.sendKeys(phone);
	}
	
	public void enterAddress(String address) throws InterruptedException{
		Address.clear();
		Thread.sleep(500);
		Address.sendKeys(address);
	}
	
	
	public void entercity(String City) throws InterruptedException{
		city.clear();
		Thread.sleep(500);
		city.sendKeys(City);
	}
	
	
	public void enterfirstName(String name) throws InterruptedException{
		Name.clear();
		Thread.sleep(500);
		Name.sendKeys(name);
	}
	
	public void enterlastName(String name) throws InterruptedException{
		Last_Name.clear();
		Thread.sleep(500);
		Last_Name.sendKeys(name);
	}
	

	public void enterzipCode(String zip) throws InterruptedException{
		zipCode.clear();
		Thread.sleep(500);
		zipCode.sendKeys(zip);
	}
	
	public void enterwebsite(String web) throws InterruptedException{
		website.clear();
		Thread.sleep(500);
		website.sendKeys(web);
	}
	
	public void selectDropdown(String Drop) throws InterruptedException{
		Select s=new Select(Dropdown);
		s.selectByVisibleText(Drop);
	}
	
	public void clickRadiobutton() throws InterruptedException{
		Thread.sleep(500);
		Radiobutton.click();
	}
	
	public void entersubmit(String sub) throws InterruptedException{
		Thread.sleep(500);
		Submit.click();
	}
	
}
