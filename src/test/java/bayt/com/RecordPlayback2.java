package bayt.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecordPlayback2 {
	static int n=0;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.bayt.com/en/login/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Email Address or Username']")).sendKeys("TestData235@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("TestData@1976");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='yw1']/li[13]//li[7]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Account Settings')]")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,0.60*document.body.scrollHeight)", "");
		Thread.sleep(5000);
		WebElement delete= driver.findElement(By.xpath("//a[contains(text(),'Delete My Account')]"));
		js.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		WebElement yes_delete=driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete My Account')]"));
		js.executeScript("arguments[0].click();", yes_delete);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//button[contains(text(),'Yes')])[2]")));
		
		js.executeScript("document.body.style.zoom = '0.50'", "");
        Thread.sleep(2000);
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShots\\Screenshot.png"+ ++n));
		 Thread.sleep(2000);
		js.executeScript("document.body.style.zoom = '1.00'", "");
		
	}

}
