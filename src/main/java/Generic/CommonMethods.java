package Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
	
	// select option from the dropdown
	public void selectDropdownOPtion(WebElement element, String valueToBeSelected) throws Exception 
	{
		Select select = new Select(element);
		try {
		select.selectByVisibleText(valueToBeSelected);
		}catch(Exception e) {
			throw new Exception("Value is not present in dropdown for WebElement: "+element +" Value to be selected is:"+ valueToBeSelected);
		}
	}
	
	// select radio button
	public void selectRadioButton(List<WebElement> list, String valueToBeSelected) {
		for(WebElement webElement:list) {
			if(webElement.getText().equalsIgnoreCase(valueToBeSelected)){
				webElement.click();
				break;
			}
		}
	}
	
	//select checkboxes
	public void selectCheckBoxes(List<WebElement> list, String check) {
		String[] checkArray = check.split(",");
		for (String value : checkArray) {
			for (WebElement element : list) {
				if(element.getText().equalsIgnoreCase(value)) {
					element.click();
					break;
				}
			}
			
		}
	}
	
	
	//get dropdown options as list of string for compare
	public List<String> getDropDownOptionsAsList(WebElement element) {
		Select os = new Select(element);
		List<WebElement> list_webElement_model =  os.getOptions();
		List<String> actualContent = new ArrayList<String>();
		for (WebElement webElement : list_webElement_model) {
			actualContent.add(webElement.getText());
		}
		return actualContent;
	}

}
