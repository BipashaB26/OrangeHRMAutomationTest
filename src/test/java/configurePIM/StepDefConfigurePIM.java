package configurePIM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import pageFactory.ConfigurePIMPageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.NavigationsPageFactory;

public class StepDefConfigurePIM {

	WebDriver driver = null;
	LoginPageFactory login;
	ConfigurePIMPageFactory configurepim;
	NavigationsPageFactory gotoconfigurepage;
	
	@Test
	@Given("user has logged in")
	public void user_has_logged_in() { 
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		assertEquals(expectedTitle, actualTitle);
		
		login = new LoginPageFactory(driver);
		login.enterusernamelogin("Admin");
		login.enterpasswordlogin("admin123");
		login.clickloginbutton();	
		System.out.println("user has logged in successfully");
	}

	@Test
	@And("user reaches Configure PIM Page from Home Page")
	public void user_reaches_configure_pim_page_from_home_page() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTitle, expectedTitle);
	
		gotoconfigurepage = new NavigationsPageFactory(driver);
		gotoconfigurepage.configurepimpage();
		System.out.println("user is on the Configure PIM Page");
	}
	
	@Test
	@When("user clicks on Edit button")
	public void user_clicks_on_edit_button() {
		configurepim = new ConfigurePIMPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		configurepim.clicksavebutton();	
		
	}

	@Test
	@Then("all the disabled checkboxes get enabled")
	public void all_the_disabled_checkboxes_get_enabled() {
		configurepim = new ConfigurePIMPageFactory(driver);
		configurepim.allfieldschosen();
	}

	@Test
	@And("Save button appears")
	public void save_button_appears() {
		configurepim = new ConfigurePIMPageFactory(driver);
		configurepim.showsavebutton();	
	}
	
	@Test
	@When("user clicks on Save button")
	public void user_clicks_on_save_button() {
		configurepim = new ConfigurePIMPageFactory(driver);
		configurepim.clicksavebutton();
	}
	
	@Test
	@Then("all the fields are successfully saved")
	public void all_the_fields_are_successfully_saved() {
		configurepim = new ConfigurePIMPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
			configurepim.showsuccessfulmessage();
			System.out.println("Successfully saved all the configure PIM fields at a go");
		}
		catch(Exception e)
		{
			fail("successful message not displayed for all configure pim fields");
		}
		driver.close();
	}
	
	@Test
	@When("user deselects any of the selected fields and selects accoring to wish")
	public void user_deselects_any_of_the_selected_fields_and_selects_accoring_to_wish() {
		configurepim = new ConfigurePIMPageFactory(driver);
		configurepim.deselectallfields();
		configurepim.selectanyfield();
	}
	
	@Test
	@And("clicks on Save button")
	public void clicks_on_save_button() {
		configurepim = new ConfigurePIMPageFactory(driver);
		configurepim.clicksavebutton();
	}
	
	@Test
	@Then("selected fields are successfully saved")
	public void selected_fields_are_successfully_saved() {
		configurepim = new ConfigurePIMPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
			configurepim.showsuccessfulmessage();
			System.out.println("Successfully saved selected configure PIM fields");
		}
		catch(Exception e)
		{
			fail("successful message not displayed for selected configure pim fields");
		}
		driver.close();
	}
	
	@Test
	@When("user deselects all the checkboxes")
	public void user_deselects_all_the_checkboxes() {
		configurepim = new ConfigurePIMPageFactory(driver);
		configurepim.deselectallfields();
	}
	
	@Test
	@Then("error message is displayed or user is prompted that no field is chosen")
	public void error_message_is_displayed_or_user_is_prompted_that_no_field_is_chosen(){
		configurepim = new ConfigurePIMPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		try {
			
				configurepim.showsuccessfulmessage();
				fail("When user does not select any checkbox to save, still shows successful message on click");
			
		}
		catch(Exception e)
		{
			System.out.println("Proper execution of configure pim functionality");
		}
		
		driver.close();
	}	
}
