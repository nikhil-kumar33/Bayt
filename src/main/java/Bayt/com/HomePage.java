package Bayt.com;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.BaseClass;

public class HomePage {

	private static WebDriver driver;

	public HomePage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get("https://bayt.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	

	@FindBy(xpath = "//a[contains(text(), 'About Us')]")
	private static WebElement aboutUs;

	@FindBy(xpath = "//*[@id='text_search1']")
	private static WebElement jobTitle;

	@FindBy(xpath = "//*[@id='search_country2__r']")
	private static WebElement country;

	@FindBy(xpath = "(//button[contains(text(),'Search')])[2]")
	private static WebElement searchButton;

	@FindBy(xpath = "(//a[contains(text(),'Easy')])[3]")
	private static WebElement easyApply;

	public void clickAboutUsElement() {
		BaseClass bc = new BaseClass(driver);
		// bc.wait(aboutUs,10);
		bc.scrollToElement(aboutUs);
		bc.wait(aboutUs, 10);
		bc.takeScreenShot("HomePage");
		bc.clickUsingJavaScript(aboutUs);

	}

	public void searchForJobAndApply(String title, String country) {
		BaseClass bc = new BaseClass(driver);
		Actions action = new Actions(driver);
		bc.hardWait(6000);
		action.moveToElement(jobTitle).click().pause(Duration.ofSeconds(5)).sendKeys(title).sendKeys(Keys.ENTER).build()
				.perform();
		bc.hardWait(4000);
		action.moveToElement(this.country).click().pause(Duration.ofSeconds(5)).sendKeys(country)
				.pause(Duration.ofSeconds(5)).sendKeys(Keys.ENTER).build().perform();
		bc.hardWait(4000);
		action.moveToElement(driver.findElement(By.xpath("//b[contains(text(),'"+country+"')]"))).click().build()
				.perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		bc.hardWait(4000);
		bc.takeScreenShot("HomePage2");
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//button[contains(text(),'Search')])[2]")));
		bc.hardWait(4000);
		bc.takeScreenShot("HomePage3");
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[contains(text(),'Easy')])[3]")));
	}

}
