package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v124.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class Popup_Page extends Base{
	
	@FindBy(xpath = "//button[@class='confirm']")
	WebElement btn_OK;
	
	
	public Popup_Page() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnOkButton() {
		btn_OK.click();
	}
}
