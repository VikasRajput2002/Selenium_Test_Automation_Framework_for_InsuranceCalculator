package insuranceCalculation_Motorcycle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.Base;

public class ErrorTests_motorcycle extends Base{
	
	
	@Test(enabled =  false)
	public void errorMessage_PayLoadField() {
		// click on the motorcycle link
		homePage.clickOnMotorCycleLink();
		
		// enter cyclinder capacity
		vehicleDataPage.enterCylinderCapacity("10001");
		
		// to log information in the reprot
		test.log(Status.PASS, "Cylinder capacity is filled with data: 10001");
		
		//verify error message
		String actualErrorMessage = vehicleDataPage.getErrorMessageOnCylinderCapacity();
		// expected error message
		String expectedErrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"Error message is not as expected on cylinder capacity field");
	}
	
	
	@Test(enabled = false)
	public void errorMessage_PayLoadField1() {
		// click on the motorcycle link
		homePage.clickOnMotorCycleLink();
		
		// enter cyclinder capacity
		vehicleDataPage.enterCylinderCapacity("10001");
		
		// to log information in the reprot
		test.log(Status.PASS, "Cylinder capacity is filled with data: 10001");
		
		//verify error message
		String actualErrorMessage = vehicleDataPage.getErrorMessageOnCylinderCapacity();
		// expected error message
		String expectedErrorMessage = "Must be a number between 1 and 30000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"Error message is not as expected on cylinder capacity field");
	}
		
	
	@Test(enabled = true)
	public void verifyModelDropdownOptions() {
		// compare the dropdown
		// click on the motorcycle link
		homePage.clickOnMotorCycleLink();
		// get dropdown content
		List<String> actualValues = vehicleDataPage.getDropdownOption_model();
//		test.log(Status.INFO, "Actual dd content for model dd is: "+ actualValues);
		
		// expected value
		List<String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped", "Motorcycle");
		test.log(Status.INFO, "Actual dd content for model dd is: "+ expectedValues);
		
		// compare - assert
		Assert.assertEquals(actualValues, expectedValues,"Error in Dropdown options compare at Model Dropdown");
		
		
	}
	

}
