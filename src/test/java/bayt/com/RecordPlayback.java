package bayt.com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class RecordPlayback {
	static int n=0;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://bayt.com");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(), 'About Us')]")).click();
		Thread.sleep(4000);

		js.executeScript("window.scrollBy(0,500)", "");

		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[contains(text(), 'Product Marketing Manager')]")).click();

		Thread.sleep(4000);
		Set<String> windows = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>();

		for (String window : windows)
			windows1.add(window);

		driver.switchTo().window(windows1.get(1));

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(), 'Easy apply')]")).click();

		Thread.sleep(4000);

		js.executeScript("window.scrollBy(0,800)", "");

		String url = driver.getCurrentUrl();

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Data");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email Address']"))
				.sendKeys("nikhilmishra01091998@gmail.com");
		// driver.findElement(By.xpath("//input[@placeholder='Email
		// Address']")).sendKeys("TestData@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("TestData@1976");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Your mobile number']")).sendKeys("123456789");
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		WebElement applyNow = driver.findElement(By.xpath("//button[contains(text(), 'Apply Now')]"));

		// new
		// WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(applyNow));
		// act.moveToElement(applyNow).click().build().perform();
		applyNow.click();
		Thread.sleep(1000);
		String emailError = null;
		Thread.sleep(1000);
		if (url.equals(driver.getCurrentUrl()))
			emailError = driver.findElement(By.xpath("//input[@placeholder='Email Address']/following-sibling::div"))
					.getText();

		SoftAssert asser = new SoftAssert();

		if (emailError.contains("This email is already registered."))
			asser.assertTrue(false, emailError);
		
		js.executeScript("window.scrollBy(0,-300)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
//		String num=String.valueOf((int)(Math.random()*1000));
//		System.out.println(num);
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("TestData235@gmail.com");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(), 'Apply Now')]")).click();
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		Thread.sleep(4000);
		Actions action= new Actions(driver);
		
		
		
		js.executeScript("document.body.style.zoom = '0.50'", "");
        Thread.sleep(2000);
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\Screenshot.png"+ ++n));
		 Thread.sleep(2000);
		js.executeScript("document.body.style.zoom = '1.00'", "");
	
		
	}

}
