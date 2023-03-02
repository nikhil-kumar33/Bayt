package Bayt.com;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class LoginPage {

private static WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get("https://www.bayt.com/en/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Email Address or Username']")
	private static WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private static WebElement password;
	
	@FindBy(xpath="//button[contains(text(), 'Log in')]")
	private static WebElement login;
	
	
	public void login(String userId, String password) {
		BaseClass bc= new BaseClass(driver);
		bc.hardWait(3000);
		bc.sendKeys(userName, userId);
		bc.hardWait(3000);
		bc.sendKeys(this.password, password);
		bc.hardWait(3000);
		bc.takeScreenShot("LoginPage");
		bc.hardWait(3000);
		bc.clickUsingJavaScript(login);
	}
	
	
	
}
