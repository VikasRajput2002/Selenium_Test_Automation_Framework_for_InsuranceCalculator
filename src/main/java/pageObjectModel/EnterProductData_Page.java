package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;


public class EnterProductData_Page extends Base {
	
	
	@FindBy(id="startdate")
	WebElement date_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	
	//optional products;
	@FindBy(xpath = "//input[@name='Optional Products[]']/parent::label")
	List<WebElement> checkbox_optionalproducts;
	
	@FindBy(id="nextselectpriceoption")
	WebElement btn_Next;
	
	
	
	
	public EnterProductData_Page() {
		PageFactory.initElements(driver, this);
	}
	
	// enter product data
	public void enterProductData(HashMap<String,String> testData) throws Exception {
		
		// MM/dd/yyyy - must be more than one month in thefuture
		date_startdate.sendKeys(testData.get("Product_startdate"));
		commonMethods.selectDropdownOPtion(dd_insurancesum, testData.get("Product_insurancesum"));
		commonMethods.selectDropdownOPtion(dd_damageinsurance, testData.get("Product_damageinsurance"));
		commonMethods.selectCheckBoxes(checkbox_optionalproducts, testData.get("Product_OptionalProducts"));
	}
	
	// click on next button
	public void clickOnNextButton() {
		btn_Next.click();
	}

}
