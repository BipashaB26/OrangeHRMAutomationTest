package reportingmethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;


public class StepDefAddReportingMethod {
	
	WebDriver driver = null;
	Properties obj;
	FileInputStream objfile;
	
		@Test
		@Given("user has logged in")
		public void user_has_logged_in() throws IOException {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
			
			String actualTitle = driver.getTitle();
			String expectedTitle = "OrangeHRM";
			assertEquals(expectedTitle, actualTitle);
			
			obj = new Properties();
			objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
			obj.load(objfile);
			driver.findElement(By.id(obj.getProperty("usernamelogin"))).sendKeys("Admin");
			driver.findElement(By.id(obj.getProperty("passwordlogin"))).sendKeys("admin123");
			driver.findElement(By.id(obj.getProperty("loginbutton"))).click();
			System.out.println("user has logged in successfully");
		}

		@Test
		@And("user reaches Reporting Methods Page from Home Page")
		public void user_reaches_reporting_methods_page_from_home_page() {
			
			String actualTitle = driver.getTitle();
			String expectedTitle = "OrangeHRM";
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualTitle, expectedTitle);
			
			new Actions(driver).moveToElement(driver.findElement(By.xpath(obj.getProperty("piminmenubar")))).perform();
			WebElement configurationtab = new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(obj.getProperty("configurationofpim")))));
			new Actions(driver).moveToElement(configurationtab).perform();
			WebElement custfields = new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(obj.getProperty("reportingmethods")))));
			custfields.click();
			System.out.println("Reporting Methods Page");
			
		}
		
		@Test
		@When("user clicks on Add button")
		public void user_clicks_on_add_button() throws IOException {
			obj = new Properties();
			objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
			obj.load(objfile);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id(obj.getProperty("AddButton_reportingmethods"))).click();
		}
		
		@Test
		@And("enters a Name")
		public void enters_a_name() throws IOException {
			obj = new Properties();
			objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
			obj.load(objfile);		
			driver.findElement(By.id(obj.getProperty("Name_reportingmethods"))).sendKeys("Budget");

		}
		
		@Test
		@And("clicks on Save")
		public void clicks_on_save() throws IOException {
			obj = new Properties();
			objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
			obj.load(objfile);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id(obj.getProperty("SaveButton_reportingmethods"))).click();
		}
		
		@Test
		@Then("a new Reporting Method is added as message is displayed")
		public void a_new_reporting_method_is_added_as_message_is_displayed() throws IOException {
			obj = new Properties();
			objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
			obj.load(objfile);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try
			{
				driver.findElement(By.xpath(obj.getProperty("successfulmessage"))).isDisplayed();
				System.out.println("successful message is shown for adding a new reporting method");
			}
			catch(Exception e)
			{
				fail("successful message not shown for reporting method addition");
			}
			driver.close();
		}



}
