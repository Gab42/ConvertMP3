package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import program.Program;

public class Youtube extends utils.Driver{
		public Youtube(WebDriver Driver, WebDriverWait Wait){
			super();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}	
		
		public String videoURL;
		
		private WebElement searchbar(){
			return driver.findElement(By.id("masthead-search-term"));
		}
		
		private WebElement searchButton(){
			return driver.findElement(By.className("search-button"));
		}
		
		private WebElement videoInList(){
			return driver.findElement(By.cssSelector("span.yt-thumb-simple > img"));
		}
		
		private WebElement videoOpened(){
			return driver.findElement(By.id("watch-uploader-info"));
		}
		
		public void OpenYoutube(){
			driver.get(utils.Links.youtubeURL);	
		}
		
		public void FindVideo(String songName){
			wait.until(ExpectedConditions.visibilityOf(searchbar()));
			searchbar().sendKeys(songName);
			searchButton().click();
		}
		
		public void OpenVideo() throws InterruptedException{
			while (driver.getCurrentUrl() == "https://www.youtube.com/")
			{
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
			videoInList().click();
		}
		
		public void CopyURL(){
			videoURL = driver.getCurrentUrl();
		}
}
