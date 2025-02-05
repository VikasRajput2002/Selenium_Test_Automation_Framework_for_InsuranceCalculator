package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class SelectPriceOption_Page extends Base {
	
	@FindBy(id="nextsendquote")
	WebElement btn_Next;
	
	
	
	//init 
	public SelectPriceOption_Page() {
		PageFactory.initElements(driver,this);
	}
	
	
	// to get Price based on selected plan
	public String getPriceForSelectedOption(String plan) {
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='" +plan +"']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
	}
	
	// radio button
	public void selectPriceOption(String plan)
	{
		String dataXpath = 	"//input[@name='Select Option' and @value='" + plan +"']/parent::label";
		driver.findElement(By.xpath(dataXpath)).click();
	}
	
	// click on next
	public void clickOnNextButton() {
		btn_Next.click();
	}
}
