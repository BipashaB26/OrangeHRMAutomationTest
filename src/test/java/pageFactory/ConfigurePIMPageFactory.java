package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigurePIMPageFactory {

	@FindBy(id="btnSave")                                              // Save button or Edit button in Configure PIM Page
	WebElement savebutton;

	@FindBy(id="configPim_chkDeprecateFields")                         // Check box for Deprecated field in Configure PIM Page
	WebElement deprecatedfieldcheckbox;

	@FindBy(id="configPim_chkShowSSN")                                // Check box for SSN field in Configure PIM Page
	WebElement ssnfieldcheckbox;

	@FindBy(id="configPim_chkShowSIN")                                // Check box for SIN field in Configure PIM Page
	WebElement sinfieldcheckbox;

	@FindBy(id="configPim_chkShowTax")                               // Check box for US Tax field in Configure PIM Page
	WebElement ustaxfieldcheckbox;

	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/script")         // Successful Message displayed for successfully saving the fields
	WebElement successfulmessage;


	WebDriver driver;                                               

	public ConfigurePIMPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	public void clicksavebutton()                        //////// Click on the Save Button or Edit Button in the Configure PIM Page
	{
		savebutton.click();
	}
	public void showsavebutton()                        //////// Show the Save Button or Edit Button in the Configure PIM Page
	{
		savebutton.isDisplayed();
	}
	public void allfieldschosen()                  ////// Check individual field whether selected, if not, then select them individually
	{
		if((deprecatedfieldcheckbox.isSelected())==false)
			deprecatedfieldcheckbox.click();

		if((ssnfieldcheckbox.isSelected())==false)
			ssnfieldcheckbox.click();

		if((sinfieldcheckbox.isSelected())==false)
			sinfieldcheckbox.click();

		if((ustaxfieldcheckbox.isSelected())==false)
			ustaxfieldcheckbox.click();			
	}

	public void showsuccessfulmessage()          //////// Show Successful Message for successfully saving the fields
	{
		successfulmessage.isDisplayed();
	}
	public void deselectallfields()            ////// Check individual field whether selected, if yes, then de select them individually
	{
		if(deprecatedfieldcheckbox.isSelected()==true)
			deprecatedfieldcheckbox.click();

		if(ssnfieldcheckbox.isSelected()==true)
			ssnfieldcheckbox.click();

		if(sinfieldcheckbox.isSelected()==true)
			sinfieldcheckbox.click();

		if(ustaxfieldcheckbox.isSelected()==true)
			ustaxfieldcheckbox.click();			
	}

	public void selectanyfield()              ////// Select any two fields, say first and second
	{
		deprecatedfieldcheckbox.click();         // selects 1st field
		ssnfieldcheckbox.click();                //  selects 2nd field
	}
}
