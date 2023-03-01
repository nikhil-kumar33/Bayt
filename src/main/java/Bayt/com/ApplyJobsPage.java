package Bayt.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class ApplyJobsPage {

	private WebDriver driver;
	
	public ApplyJobsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="((//div[@class='row m20y p20y'])[1]/div//a)[1]")
	WebElement firstJob;
	
	public void applyForFirstJob() {
		BaseClass bc= new BaseClass(driver);
		bc.waitforElement(firstJob);
		bc.takeScreenShot("ApplyJobsPage");
		bc.clickUsingJavaScript(firstJob);
	}
	
	
	
	
}
