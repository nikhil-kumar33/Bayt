package Bayt.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class RegistrationPage {

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form[contains(@id, 'Register')]")
	WebElement registrationForm;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@placeholder='Your mobile number']")
	WebElement mobile;

	@FindBy(xpath = "//button[contains(text(), 'Apply Now')]")
	WebElement applyNow;

	public void scrollToRegistrationForm() {
		BaseClass bc = new BaseClass(driver);
		bc.scrollToElement(registrationForm);
	}

	public void fillForm(String fName, String lName, String email, String pass, String mobile) {
		BaseClass bc = new BaseClass(driver);
		bc.scrollToElement(registrationForm);
		bc.sendKeys(firstName, fName);
		bc.sendKeys(lastName, lName);
		bc.sendKeys(this.email, email);
		bc.sendKeys(this.password, pass);
		bc.sendKeys(this.mobile, mobile);

	}

	public void fillEmail(String email) {
		BaseClass bc = new BaseClass(driver);
		bc.sendKeys(this.email, email);
	}

	public void applyNow() throws DuplicateEmailErrorException {
		String url = driver.getCurrentUrl();
		String emailError = "";
		BaseClass bc = new BaseClass(driver);
		bc.takeScreenShot("RegistrationPage");
		bc.clickUsingJavaScript(applyNow);
		if (url.equals(driver.getCurrentUrl())) {
			bc.hardWait(4000);
			try {
				emailError = driver
						.findElement(By.xpath("//input[@placeholder='Email Address']/following-sibling::div"))
						.getText();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		if (emailError.contains("This email is already registered."))
			throw new DuplicateEmailErrorException("Hey buddy why you want to use someone else's email?");
	}

}
