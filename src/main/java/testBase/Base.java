package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Generic.CommonMethods;
import Generic.PropertiesOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.EnterInsurantData_Page;
import pageObjectModel.EnterProductData_Page;
import pageObjectModel.EnterVehicleData_Page;
import pageObjectModel.Home_Page;
import pageObjectModel.Popup_Page;
import pageObjectModel.SelectPriceOption_Page;
import pageObjectModel.SendQuote_Page;

public class Base{
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Home_Page homePage;
	public static EnterVehicleData_Page vehicleDataPage;
	public static CommonMethods commonMethods;
	public static EnterInsurantData_Page insurantDataPage;
	public static EnterProductData_Page productDataPage;
	public static SelectPriceOption_Page selectPriceOptionPage;
	public static SendQuote_Page sendQuotePage;
	public static Popup_Page popUpPage;
	
	
	public static WebDriver driver;
	
	
	// lauch browser ang navigate to the url
	public void LaunchBrowserAndNavigate() throws Exception {
		//read prop file and get browser and url
		String browser = PropertiesOperations.getPropertyByKey("browser");
		String url = PropertiesOperations.getPropertyByKey("url");

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		//launch browser
		// navigate to the url
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get(url);

	}

	// -- it will get executed before each test method within current class

	
	@BeforeMethod
	public void setupMethod() throws Exception {
		
		LaunchBrowserAndNavigate();
		
		homePage = new Home_Page();
		vehicleDataPage = new EnterVehicleData_Page();
		commonMethods = new CommonMethods();
		insurantDataPage = new EnterInsurantData_Page();
		productDataPage = new EnterProductData_Page();
		selectPriceOptionPage = new SelectPriceOption_Page();
		sendQuotePage = new SendQuote_Page();
		popUpPage = new Popup_Page();
	}
	
	// for logout
//	@AfterMethod
//	public void cleanUp() {
//		driver.quit();
//	}


}
