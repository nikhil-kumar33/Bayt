package Bayt.com;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class HomePage {
	
	private static WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get("https://bayt.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@FindBy(xpath="//a[contains(text(), 'About Us')]")
	private static WebElement aboutUs;
	
	
	
	
	
   public  void clickAboutUsElement() {
	   BaseClass bc= new BaseClass(driver);
	  // bc.wait(aboutUs,10);
	   bc.scrollToElement(aboutUs);
	   bc.wait(aboutUs,10);
	   bc.takeScreenShot("HomePage");
	   bc.clickUsingJavaScript(aboutUs);
	  
   }

}
