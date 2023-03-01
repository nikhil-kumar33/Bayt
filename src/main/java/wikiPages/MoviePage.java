package wikiPages;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviePage {
	
	WebDriver driver=null;

	public MoviePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//table[@class='infobox vevent']/tbody")
	WebElement searchBox;

	public String findReleaseDate() {
		String releaseDate=searchBox.findElements(By.tagName("tr")).stream().filter(p -> p.getText().contains("Release date")).collect(Collectors.toList())
		.get(0).findElements(By.tagName("td")).get(0).getText();
		
		return releaseDate;
	}

	public String findCountry() {
		String country=searchBox.findElements(By.tagName("tr")).stream().filter(p -> p.getText().contains("Country")).collect(Collectors.toList())
				.get(0).findElements(By.tagName("td")).get(0).getText();
		return country;
	}

}
