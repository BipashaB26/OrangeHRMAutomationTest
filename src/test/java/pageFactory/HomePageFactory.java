package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	@FindBy(id="welcome")                         // Welcome tag in Home Page
	WebElement welcometaghomepage;
	
	WebDriver driver;
	
	public HomePageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, LoginPageFactory.class);
	}
	
	public void showwelcometaghomepage()                            //// Display the Welcome tag once user reaches Home Page
	{
		welcometaghomepage.isDisplayed();
	}
	
}
