package Bayt.com;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class CompleteCVPage {

private WebDriver driver;
	
	public CompleteCVPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[contains(@placeholder,'Head')])[2]")
	WebElement jobTitle;
	
	@FindBy(xpath="//input[contains(@placeholder,'level')]")
	WebElement jobLevel;
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	WebElement save;
	
	public void fillJobPreference(String jobTitle, String level) {
		BaseClass bc= new BaseClass(driver);
		bc.sendKeys(this.jobTitle, jobTitle);
		new Actions(driver).moveToElement(this.jobLevel).click().pause(Duration.ofSeconds(5)).sendKeys(level).sendKeys(Keys.ENTER).build().perform();
		bc.hardWait(4000);
		bc.takeScreenShot("CompleteCVPage");
		bc.clickUsingJavaScript(save);
	}
}
