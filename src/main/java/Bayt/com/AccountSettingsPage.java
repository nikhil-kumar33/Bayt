package Bayt.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class AccountSettingsPage {

WebDriver driver;
	
	public AccountSettingsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Delete My Account')]")
	WebElement deleteAccount;
	
	@FindBy(xpath="//button[contains(text(),'Yes, Delete My Account')]")
	WebElement confirmDeleteAccount;	
	
	
	@FindBy(xpath="(//button[contains(text(),'Yes')])[2]")
	WebElement reConfirmDeleteAccount;	
	
	public void deleteAccount() {
		BaseClass bc= new BaseClass(driver);
		bc.clickUsingJavaScript(deleteAccount);
		bc.hardWait(3000);
		bc.clickUsingJavaScript(confirmDeleteAccount);
		bc.hardWait(3000);
		bc.takeScreenShot("AccountSettingsPage");
		bc.clickUsingJavaScript(reConfirmDeleteAccount);
	}
}
