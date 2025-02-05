package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class EnterInsurantData_Page extends Base {
	
	@FindBy(id="firstname")
	WebElement txt_firstname;
	
	@FindBy(id="lastname")
	WebElement txt_lastname;
	
	@FindBy(id="birthdate")
	WebElement date_birthdate;
	
	
	// radio buttons
	// gender
	@FindBy(xpath = "//input[@name='Gender']/parent::label")
	List<WebElement> radio_Gender;
	
	@FindBy(id="streetaddress")
	WebElement txt_StreetAddress;
	
	@FindBy(id="country")
	WebElement dd_country;
	
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	
	@FindBy(id="city")
	WebElement txt_city;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	
	
	// checkboxs
	// hobbies
	@FindBy(xpath = "//input[@name='Hobbies']/parent::label")
	List<WebElement> checkbox_hobbies;
	
	
	@FindBy(id="website")
	WebElement txt_website;
	
	@FindBy(id="open")
	WebElement btn_PictureOpenButton;
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_Next;
	
	// constructor 
	public EnterInsurantData_Page() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	// enter insurance data
	public void enterInsuranceData(HashMap<String, String> testData) throws Exception {
		txt_firstname.sendKeys(testData.get("Insurant_FirstName"));
		txt_lastname.sendKeys(testData.get("Insurant_LastName"));
		date_birthdate.sendKeys(testData.get("Insurant_birthdate"));
		commonMethods.selectRadioButton(radio_Gender, testData.get("Insurant_gender"));
		commonMethods.selectDropdownOPtion(dd_country, testData.get("Insurant_country"));
		txt_zipcode.sendKeys(testData.get("Insurant_zipcode"));
		commonMethods.selectDropdownOPtion(dd_occupation, testData.get("Insurant_occupation"));
		
		// select checkbox values
		commonMethods.selectCheckBoxes(checkbox_hobbies, testData.get("Insurant_Hobbies"));
		
		// upload the picture
	}
	
	public void clickOnNextButton() {
		btn_Next.click();
	}

}
