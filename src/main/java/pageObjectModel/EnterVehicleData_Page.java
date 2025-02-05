package pageObjectModel;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class EnterVehicleData_Page extends Base {
	
	
	@FindBy(id="make")
	WebElement dd_makes;
	
	
	@FindBy(xpath = "//select[@id='model']")
	WebElement dd_model;
	
	
	@FindBy(xpath = "//input[@id='cylindercapacity']")
	WebElement txt_cylindercapacity;
	
	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_cylinderCapacity;
	
	@FindBy(id="engineperformance")
	WebElement txt_engineperformance;
	
	
	@FindBy(id="dateofmanufacture")
	WebElement date_dateofmanufacture;
	
	
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseats;
	
	@FindBy(id="listprice")
	WebElement txt_listprice;
	
	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement btn_Next;
	
	
	// use to initials all the object and elements
	public EnterVehicleData_Page() {
		PageFactory.initElements(driver,this);
	}
	
	// enter cylindercapacity
	public void enterCylinderCapacity(String value) {
		txt_cylindercapacity.sendKeys(value);
	}
	
	// get error message on cylider capacity
	public String getErrorMessageOnCylinderCapacity() {
		return error_cylinderCapacity.getText();
	}
	
	// compare dd content
	public  List<String> getDropdownOption_model() {
		return commonMethods.getDropDownOptionsAsList(dd_model);
	}
	
	
	// for enter vehicle data
	public void enterVehicleData(HashMap<String,String> testData) throws Exception {
		commonMethods.selectDropdownOPtion(dd_makes, testData.get("Vehicle_Make"));
		commonMethods.selectDropdownOPtion(dd_model,testData.get("Vehicle_Model"));
		txt_cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
		txt_engineperformance.sendKeys(testData.get("Vehicle_Engine Performance"));
		date_dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
		
		commonMethods.selectDropdownOPtion(dd_numberofseats, testData.get("Vehicle_No of Seats_motorcycle"));
		txt_listprice.sendKeys(testData.get("Vehicl_ListPrice"));
		txt_annualmileage.sendKeys(testData.get("Vehicle_Annual Mileage"));
	}
	
	// click on next button
	public void clickOnNextButton() {
		btn_Next.click();

	}
	
	
	
}
