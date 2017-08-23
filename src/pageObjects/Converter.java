package pageObjects;

import java.io.File;
import java.io.FilenameFilter;

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

	public static class GenericExtFilter implements FilenameFilter {
		private String ext;
		
		public GenericExtFilter(String ext) {
			this.ext = ext;
		}
		
		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}
		
	public void CheckIfDownloadFinished(){
		//Find if file is still downloading
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\";
		String fileExt = ".crdownload" ;
		File dir = new File(downloadPath);
		GenericExtFilter filter = new GenericExtFilter(fileExt);
		String[] list = dir.list(filter);
		
		while (list.length != 0){
			list = dir.list(filter);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
			
	}
}
