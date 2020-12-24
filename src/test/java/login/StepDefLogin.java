package login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.cucumber.java.en.*;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

public class StepDefLogin {

	WebDriver driver = null;
	LoginPageFactory login;
	HomePageFactory home;

	@Test
	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("Browser is open");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}

	@Test
	@And("user is on login page")
	public void user_is_on_login_page() {

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		assertEquals(expectedTitle, actualTitle);
		System.out.println("user is on login page");
	}
	
	@Test
	@When("^user has entered (.*) and (.*) which are valid$")
	public void user_has_entered_admin_and_admin123_which_are_valid(String validUsername, String validPassword) {
		login = new LoginPageFactory(driver);
		login.enterusernamelogin(validUsername);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login.enterpasswordlogin(validPassword);
	}
	
	@Test
	@And("Login button is clicked")
	public void login_button_is_clicked() {
		login = new LoginPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login.clickloginbutton();
	}
	
	@Test
	@Then("navigation to Dashboard in the Home Page takes place")
	public void navigation_to_dashboard_in_the_home_page_takes_place() {
		home = new HomePageFactory(driver);
		try
		{
			home.showwelcometaghomepage();
			System.out.println("Login is successful with valid credentials");
		}
		catch(Exception e)
		{
			fail("login is not possible even with valid credentials");
		}
		
		driver.close();
	}
	
	@Test
	@When("^invalid credentials are entered as (.*) and (.*)$")
	public void invalid_credentials_are_entered_as_admin_and_admin1234(String invalidUsername, String invalidPassword) {
		login = new LoginPageFactory(driver);
		login.enterusernamelogin(invalidUsername);
		login.enterpasswordlogin(invalidPassword);
	}
	
	@Test
	@Then("error message is displayed on the same screen")
	public void error_message_is_displayed_on_the_same_screen() {
		
		login = new LoginPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
			login.showerrormessagelogin();
			System.out.println("Login is not possible with invalid credentials");
		}
		catch(Exception e)
		{
			fail("login is getting possible with invalid credentials");
		}
		driver.close();
	}
}
