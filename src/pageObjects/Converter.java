package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Converter extends utils.Driver {
	public Converter(WebDriver Driver, WebDriverWait Wait){
		super();
	}
	
	private WebElement searchBox(){
		return driver.findElement(By.id("youtube-url"));	
	}
	
	private WebElement downloadLink(){
		return driver.findElement(By.linkText("Download"));
	}
	
	private WebElement searchButton(){
		return driver.findElement(By.id("submit"));	
	}
	
	public void OpenConverter(){
		driver.get(utils.Links.converterURL);	
	}
	
	public void EnterURL(String url){
		searchBox().clear();
		searchBox().sendKeys(url);
		searchButton().click();
	}
	
	public void DownloadVideo(){
		downloadLink().click();
	}
}
