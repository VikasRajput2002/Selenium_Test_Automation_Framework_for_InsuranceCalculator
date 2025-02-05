package insuranceCalculation_Motorcycle;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Generic.ExcelOperations;
import testBase.Base;

public class EndToEndTests_motorcycle extends Base{
	
	ExcelOperations excelOperations = new ExcelOperations("InsurancePremium");
	
	@Test(dataProvider = "vehicleData")
	public void insuranceCalculate(Object obj) throws Exception{
		
		HashMap<String, String> testData = (HashMap<String, String>) obj;
//		System.out.println("Test data is :" + testData);
		
		// add data in the report
		test.log(Status.INFO, "Test data used for execution is: "+  testData);

		homePage.clickOnMotorCycleLink();
		vehicleDataPage.enterVehicleData(testData);  
		vehicleDataPage.clickOnNextButton();  // click on next after entering data 
		insurantDataPage.enterInsuranceData(testData);
		insurantDataPage.clickOnNextButton();   // click on next after entering data 
		productDataPage.enterProductData(testData);
		productDataPage.clickOnNextButton();   // click on next after entering data
		
		
		
//		Assert.assertEquals(selectPriceOptionPage.getPriceForSelectedOption("Gold"), testData.get("PriceValidation_Gold"),"Pricing for gold plan is not matching.");
//		Assert.assertEquals(selectPriceOptionPage.getPriceForSelectedOption("Silver"), testData.get("PriceValidation_Silver"),"Pricing for silver plan is not matching.");
//		Assert.assertEquals(selectPriceOptionPage.getPriceForSelectedOption("Platinum"), testData.get("PriceValidation_Platinum"),"Pricing for platinum plan is not matching.");
//		Assert.assertEquals(selectPriceOptionPage.getPriceForSelectedOption("Ultimate"), testData.get("PriceValidation_Ultimate"),"Pricing for ultimate plan is not matching.");
//		
//		System.out.println("Select Option = "+ testData.get("SelectOption"));
		selectPriceOptionPage.selectPriceOption(testData.get("SelectOption"));
//		selectPriceOptionPage.selectPriceOption("Silver");
		selectPriceOptionPage.clickOnNextButton();
		
		
		sendQuotePage.enterSendQuoteData(testData);
		sendQuotePage.clickOnSendButton();
		
		
		Thread.sleep(10000);
		popUpPage.clickOnOkButton();
		
	}
	
	
	
	// Dataprovider method - return object array 
	@DataProvider(name = "vehicleData")
	public Object[][] testDataSupplier() throws Exception {
		
		int rowCount = excelOperations.getRowCount();
		Object[][] obj = new Object[rowCount][1];  // [row number][ mp[row number] - data]
		
		for(int i=1; i<=rowCount; i++) {
			HashMap<String, String> testData = excelOperations.getTestDataInMap(i);
//			System.out.println(excelOperations.getTestDataInMap(i));

			obj[i-1][0] = testData;
		}
		return obj;
		
	}
	
	
}
