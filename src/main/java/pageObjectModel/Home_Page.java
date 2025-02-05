package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Base;

public class Home_Page extends Base{
	
	@FindBy(id="nav_automobile")
	WebElement link_automobile;
	
	@FindBy(id="nav_truck")
	WebElement link_truck;

	@FindBy(id="nav_motorcycle")
	WebElement link_motorcycle;
	
	@FindBy(id="nav_camper")
	WebElement link_camper;
	
	
	
	// constructor - use to initial methods
	// intit - initialize all the object on the class
	public Home_Page() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	// click on motorcycle link on home page
	public void clickOnMotorCycleLink() {
		link_motorcycle.click();
	}
}
