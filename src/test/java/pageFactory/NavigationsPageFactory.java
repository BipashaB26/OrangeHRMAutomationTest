package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationsPageFactory {

	@FindBy(xpath="//*[@id=\"mainMenuFirstLevelUnorderedList\"]/li[2]")         // PIM in the Menu of the Home Page
	WebElement piminmenubar;
	
	@FindBy(id="menu_pim_Configuration")                                       // Configuration Tab under PIM in Home Page
	WebElement configurationofpim;
	
	@FindBy(id="menu_pim_configurePim")                        // Optional Fields under Configuration Tab under PIM in Home Page
	WebElement configurepim_optionalfields;	
	
	WebDriver driver;
	
	public NavigationsPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	///// Select PIM from Menu, then select Configuration Tab under PIM, then click on Optional Fields to go to Configure PIM Page
		public void configurepimpage()                                    
	{
		new Actions(driver).moveToElement(piminmenubar).perform();
		WebElement configurationtab = new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(configurationofpim));
		new Actions(driver).moveToElement(configurationtab).perform();
		WebElement optionalfields = new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(configurepim_optionalfields));
		optionalfields.click();
	}
	
}
