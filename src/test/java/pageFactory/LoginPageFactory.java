package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	@FindBy(id="txtUsername")                               // User name field in Login Page
	WebElement usernamelogin;
	
	@FindBy(id="txtPassword")                               // Password field in Login Page
	WebElement passwordlogin;
	
	@FindBy(id="btnLogin")                                  // Login button
	WebElement loginbutton;
	
	@FindBy(id="spanMessage")                               // Error message to be displayed on incorrect login
	WebElement errormessagelogin;
	
	WebDriver driver;
	
	public LoginPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterusernamelogin(String username)         /////// Enter User name in Login Page
	{
		usernamelogin.sendKeys(username);
	}
	public void enterpasswordlogin(String password)         /////// Enter Password in Login Page
	{
		passwordlogin.sendKeys(password);
	}
	public void clickloginbutton()                         /////// Login button is clicked
	{
		loginbutton.click();
	}
	public void showerrormessagelogin()                     /////// Error message is displayed on incorrect login
	{
		errormessagelogin.isDisplayed();
	}
 
}
