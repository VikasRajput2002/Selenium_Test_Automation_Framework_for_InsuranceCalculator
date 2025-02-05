package pageObjectModel;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class SendQuote_Page extends Base{
	
	@FindBy(id="email")
	WebElement txt_Email;
	
	@FindBy(id="username")
	WebElement txt_UserName;
	
	@FindBy(id="password")
	WebElement txt_Password;
	
	@FindBy(id="confirmpassword")
	WebElement txt_ConfirmPassword;
	
	@FindBy(id="sendemail")
	WebElement btn_Send;
	
	public SendQuote_Page() {
		PageFactory.initElements(driver, this);
	}
	
	
	// enter the data 
	public void enterSendQuoteData(HashMap<String, String> testData) {
		txt_Email.sendKeys(testData.get("SendQuote_Email"));
		txt_UserName.sendKeys(testData.get("SendQuote_Username"));
		txt_Password.sendKeys(testData.get("SendQuote_Password"));
		txt_ConfirmPassword.sendKeys(testData.get("SendQuote_ConfirmPassword"));	
	}
	
	// click on send button
	public void clickOnSendButton() {
		btn_Send.click();
	}
}
