package wikiPages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage {
	
WebDriver driver=null;

public WikiHomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(id="searchInput")
WebElement searchBox;

public  void searchMovie(String movieName) {

	searchBox.sendKeys(movieName);
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();
}

public List<String> data(String movieName) {
	searchMovie(movieName);
	String releaseDate= new MoviePage(driver).findReleaseDate();
	String country= new MoviePage(driver).findCountry(); 
	return Arrays.asList(releaseDate,country);
	
}


}
