package bayt.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Bayt.com.AccountSettingsPage;
import Bayt.com.ApplyJobsPage;
import Bayt.com.CompleteCVPage;
import Bayt.com.DuplicateEmailErrorException;
import Bayt.com.HomePage;
import Bayt.com.LoginPage;
import Bayt.com.ProfilePage;
import Bayt.com.RegistrationPage;
import Bayt.com.SpecificJobPage;

public class TestClass {

	WebDriver driver;
	
	@BeforeMethod
	public void beforeMEthod() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");

		
		
	}
	
	// Test Case with duplicate email id
	@Test(dataProvider="data", enabled=true,priority=1)
	public void createProfile(String firstName, String lastName, String email, String password, String mobile) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		HomePage hpage= new HomePage(driver);
		hpage.clickAboutUsElement();
		ApplyJobsPage apage= new ApplyJobsPage(driver);
		apage.applyForFirstJob();
		Set<String> windows = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>();

		for (String window : windows)
			windows1.add(window);

		driver.switchTo().window(windows1.get(1));
		SpecificJobPage spage= new SpecificJobPage(driver);
		
		spage.applyForFirstJob();
		RegistrationPage rpage= new RegistrationPage(driver);
		rpage.fillForm(firstName, lastName, email, password, mobile);
		try {
			rpage.applyNow();
		} catch (DuplicateEmailErrorException e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(false,"Enter correct mail");
			
		}
		
		CompleteCVPage cvpage= new CompleteCVPage(driver);
		cvpage.fillJobPreference("Senior Quality Engineer", mobile);
		
	}
	
	@DataProvider(name="data")
	public Object[][] data(){
		//uncomment below to check the validity of email
		Object[][] ob= {/*{"Test", "Data", "nikhilmishra01091998@gmail.com", "TestData@1976", "123456789"},*/
				{"Test", "Data", "TestData235@gmail.com", "TestData@1976", "123456789"}};
		
		return ob;
		
	}
	
	
	@Test(dependsOnMethods="createProfile")
	public void deleteProfile() {
		driver = new ChromeDriver();
		LoginPage lpage= new LoginPage(driver);
		lpage.login("TestData235@gmail.com", "TestData@1976");
		ProfilePage ppage= new ProfilePage(driver);
		ppage.clickAccountSettings();
		AccountSettingsPage apage= new AccountSettingsPage(driver);
		apage.deleteAccount();
	}
	
	@Test(enabled=true,priority=2)
	public void applyOnMobilePage() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=400,800");
		Map<String, Object> mobileEmulation = new HashMap<String, Object>();
		mobileEmulation.put("deviceName", "iPhone 6");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		driver = new ChromeDriver(options);
		HomePage hpage= new HomePage(driver);
		hpage.searchForJobAndApply("Quality Assurance Engineer", "United Arab Emirates");
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
