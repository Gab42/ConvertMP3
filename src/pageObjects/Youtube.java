package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import program.Program;

public class Youtube extends utils.Driver{
		public Youtube(WebDriver Driver, WebDriverWait Wait){
			super();		
		}	
		
		public String videoURL;
		
		private WebElement searchbar(){
			return driver.findElement(By.id("masthead-search-term"));
		}
		
		private WebElement searchButton(){
			return driver.findElement(By.className("search-button"));
		}
		
		private WebElement video(){
			return driver.findElement(By.cssSelector("span.yt-thumb-simple > img"));
		}
		
		public void OpenYoutube(){
			driver.get(utils.Links.youtubeURL);	
		}
		
		public void FindVideo(String songName){
			wait.until(ExpectedConditions.visibilityOf(searchbar()));
			searchbar().sendKeys(songName);
			searchButton().click();
		}
		
		public void OpenVideo(){
			video().click();
		}
		
		public void CopyURL(){
			videoURL = driver.getCurrentUrl();
		}
}
