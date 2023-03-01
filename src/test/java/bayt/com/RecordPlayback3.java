package bayt.com;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecordPlayback3 {
	static int n=0;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");

		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--window-size=400,800"); 
		 Map<String, Object> mobileEmulation = new HashMap<String, Object>();
		    mobileEmulation.put("deviceName", "iPhone 6");
		    //mobileEmulation.put("Dimensions", "Responsive");
		    options.setExperimentalOption("mobileEmulation", mobileEmulation);
		 
		driver = new ChromeDriver(options);
		driver.get("http://www.bayt.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
	

		
		Actions action = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		Thread.sleep(4000);
		action.moveToElement(driver.findElement(By.id("text_search1"))).click().pause(Duration.ofSeconds(5)).sendKeys("Quality Assurance Engineer").sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.id("search_country2__r"))).click().pause(Duration.ofSeconds(5)).sendKeys("United Arab Emirates").pause(Duration.ofSeconds(5)).sendKeys(Keys.ENTER).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//b[contains(text(),'United')]"))).click().build().perform();
	
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//button[contains(text(),'Search')])[2]")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//a[contains(text(),'Easy')])[3]")));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,0.10*document.body.scrollHeight)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[contains(@id,'Register')]")).isDisplayed();
		
	}

}
