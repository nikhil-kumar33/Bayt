package Bayt.com;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class ProfilePage {
	WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='yw1']/li[13]//li[7]/a")
	WebElement threeDots;
	
	@FindBy(xpath="//a[contains(text(),'Account Settings')]")
	WebElement accountSettings;
	
	@FindBy(xpath="//a[contains(text(),'Delete My Account')]")
	WebElement deleteMyAccount;
	
	
	public void clickAccountSettings() {
		BaseClass bc = new BaseClass(driver);
		bc.clickUsingJavaScript(threeDots);
		bc.takeScreenShot("ProfilePage");
		bc.clickUsingJavaScript(accountSettings);
	}
	
	
	
}
