package Bayt.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class SpecificJobPage {

private WebDriver driver;
	
	public SpecificJobPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(), 'Easy apply')]")
	WebElement easyApply;
	
	public void applyForFirstJob() {
		BaseClass bc= new BaseClass(driver);
		bc.waitforElement(easyApply);
		bc.takeScreenShot("SpecificJobPage");
		bc.clickUsingJavaScript(easyApply);
	}
}
